package web.commands;

import business.entities.Cart;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ConfirmCartCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public ConfirmCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }


    private void addStandardCarportToOrders(HttpServletRequest request, Cart cart) {

        int user_id = (int) request.getSession().getAttribute("user_id");
        int isARequest = 0;
        orderFacade.addStandardCarportToOrders(user_id, isARequest, cart);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, NoSuchFieldException {


        Cart cart = (Cart) request.getSession().getAttribute("cart");
        addStandardCarportToOrders(request, cart);
        cart.clearCart();


        return pageToShow;
    }
}

