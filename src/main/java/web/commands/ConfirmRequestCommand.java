package web.commands;

import business.persistence.BomMapper;
import business.services.BomFacade;
import business.services.OrderFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ConfirmRequestCommand extends CommandProtectedPage {

    BomFacade bomFacade = new BomFacade(database);
    OrderFacade orderFacade;

    public ConfirmRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(FrontController.database);
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int user_id = (int) request.getSession().getAttribute("user_id");
        int isARequest = (int) request.getSession().getAttribute("isARequest");
        int length = (int) request.getSession().getAttribute("length");
        int width = (int) request.getSession().getAttribute("width");

        orderFacade.addOrderToDatabase(user_id, length, width, isARequest);
        int order_id = orderFacade.getLatestOrderIdFromUserId(user_id);

        request.setAttribute("order_id", order_id);
        bomFacade.generateCarport(order_id, length, width);

        return pageToShow;
    }


}

