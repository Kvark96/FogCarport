package web.commands;

import business.entities.DescriptionEntities;
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
        //DescriptionEntities descriptionEntities = new DescriptionEntities();
        BomFacade bomFacade = new BomFacade(database);
        request.setAttribute("materialList", bomFacade.getMaterials());
        return pageToShow;
    }


}