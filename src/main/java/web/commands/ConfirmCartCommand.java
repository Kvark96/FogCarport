package web.commands;

import business.entities.Cart;
import business.services.CartFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ConfirmCartCommand extends CommandProtectedPage {
    CartFacade cartFacade;

    public ConfirmCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        cartFacade = new CartFacade(FrontController.database);
    }


    private void addStandardCarportToOrders(HttpServletRequest request, HttpServletResponse response) {

        int user_id = (int) request.getSession().getAttribute("user_id");
        int isARequest = 0;
        int standard_id = (int) request.getSession().getAttribute("standard_id");
        int price = Integer.parseInt(request.getParameter("price"));

        cartFacade.addStandardCarportToOrders(user_id, isARequest, standard_id, price);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, NoSuchFieldException {

        addStandardCarportToOrders(request, response);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clearCart();


        return pageToShow;
    }
}

