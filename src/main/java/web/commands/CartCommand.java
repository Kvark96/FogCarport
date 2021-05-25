package web.commands;

import business.entities.Cart;
import business.entities.StandardCarportEntity;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CartCommand extends CommandProtectedPage {
    private CarportFacade carportFacade = new CarportFacade(database);

    public CartCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchFieldException {
        HttpSession session = request.getSession();
        int standard_id = Integer.parseInt(request.getParameter("standard_id"));
        Cart cart = (Cart) session.getAttribute("cart");
        List<StandardCarportEntity> standardCarportEntities = carportFacade.getStandardCarportEntitiesList();

        StandardCarportEntity entity = carportFacade.getCarportFromId(standard_id, standardCarportEntities);
        String name = entity.getName();
        int price = entity.getPrice();
        String description = entity.getDescription();

        StandardCarportEntity standardCarportEntity = new StandardCarportEntity(standard_id, name, description, price);

        cart.addCarport(entity);


        request.getSession().setAttribute("cart", cart);

        request.getSession().setAttribute("standard_id", standard_id);


        return pageToShow;
    }
}
