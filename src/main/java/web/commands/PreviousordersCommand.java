package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.services.PreviousOrdersFacade;

public class PreviousordersCommand extends CommandProtectedPage{


    public PreviousordersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        PreviousOrdersFacade previousOrdersFacade = new PreviousOrdersFacade(database);

        int user_id = (int) request.getSession().getAttribute("user_id");
        System.out.println(user_id);
        request.setAttribute("previousOrdersList" ,previousOrdersFacade.getOldOrders(user_id));


        return pageToShow;
    }
}
