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
        StandardCarportEntity entity = carportFacade.getCarportFromId(standard_id);

        cart.addCarport(entity);

        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("standard_id", standard_id);


        return pageToShow;
    }
}
