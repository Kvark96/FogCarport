package web.commands;

import business.entities.Order;
import business.services.OrderFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderlistCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public OrderlistCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Order> orders = orderFacade.getOrdersFromDatabase(0);
        request.setAttribute("orders", orders);

        return pageToShow;
    }
}
