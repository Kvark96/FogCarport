package web.commands;

import business.services.BomFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BomCommand extends CommandProtectedPage {


    public BomCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        BomFacade bomFacade = new BomFacade(database);

        String order_id = request.getParameter("order_id");

        request.setAttribute("materialList", bomFacade.getOrderLineMaterials(Integer.parseInt(order_id)));

        return pageToShow;
    }

}
