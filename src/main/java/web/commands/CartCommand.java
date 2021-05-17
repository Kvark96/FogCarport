package web.commands;

import business.entities.Cart;
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
        request.getSession().getAttribute("user_id");
        int carportID = (int) request.getAttribute("standard_id");
       Cart cart = (Cart) session.getAttribute("cart");
        CarportMapper carportMapper = new CarportMapper(database);

        String name = carportMapper.getCarportFromId(carportID).getName();
        int price = carportMapper.getCarportFromId(carportID).getPrice();

        request.setAttribute("name", name);
        request.setAttribute("price",price );








        return "cartPage";
    }
}
