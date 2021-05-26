package web.commands;

import business.entities.Order;
import business.services.OrderFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestListCommand extends CommandProtectedPage{
    OrderFacade orderFacade;
    public RequestListCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(FrontController.database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Order> requestList = orderFacade.getOrdersFromDatabase(1);
        request.setAttribute("requestList", requestList);
        return pageToShow;
    }
}
