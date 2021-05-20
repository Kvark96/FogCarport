package web.commands;

import business.entities.Cart;
import business.entities.StandardCarportEntities;
import business.persistence.CarportMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CartCommand extends CommandProtectedPage{
    public CartCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchFieldException {
        HttpSession session = request.getSession();
       int standard_id = Integer.parseInt(request.getParameter("standard_id"));
       Cart cart = (Cart) session.getAttribute("cart");
        CarportMapper carportMapper = new CarportMapper(database);
        carportMapper.getStandardCarportEntitiesList();


        String name = carportMapper.getCarportFromId(standard_id).getName();
        int price = carportMapper.getCarportFromId(standard_id).getPrice();
        String description = carportMapper.getCarportFromId(standard_id).getDescription();

        StandardCarportEntities standardCarportEntities = new StandardCarportEntities(standard_id,name,description,price);

        cart.addCarport(standardCarportEntities);


        request.getSession().setAttribute("cart",cart);

        request.getSession().setAttribute("standard_id",standard_id);











        return pageToShow;
    }
}
