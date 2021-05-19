package web.commands;

import business.persistence.BomMapper;
import business.services.BomFacade;
import web.FrontController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BomCommand extends CommandProtectedPage {


    public BomCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        BomFacade bomFacade = new BomFacade(database);

        int order_id = (int) request.getAttribute("order_id");

        request.setAttribute("materialList", bomFacade.getOrderLineMaterials(order_id));

        return pageToShow;
    }

}
