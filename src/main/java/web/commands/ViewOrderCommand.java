package web.commands;

import business.entities.Order;
import business.services.OrderFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewOrderCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public ViewOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(FrontController.database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        String type = request.getParameter("typeOfOrder").equals("0") ? "Ordre" : "Forespørgsel";
        Order order = orderFacade.getFullOrderFromDatabase(order_id);

        request.setAttribute("user_email", order.getMail());
        request.setAttribute("price", order.getPrice());
        request.setAttribute("order_id", order_id);
        request.setAttribute("length", order.getLength());
        request.setAttribute("width", order.getWidth());
        request.setAttribute("typeOfOrder", type);

        return pageToShow;
    }
}
