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

    BomMapper bomMapper = new BomMapper(database);

    public void getWidthAndLengthFromOrderId (int order_Id) throws SQLException {


        try (Connection con = FrontController.database.connect()) {
            String sql = "Select length, width from carport.orders where order_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, order_Id);
            while(rs.next()) {
                int length = rs.getInt("length");
               int width = rs.getInt("width");

                bomMapper.generateCarport(order_Id, length, width);

            }


        } catch (SQLException ss) {
            ss.printStackTrace();
        }
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //DescriptionEntities descriptionEntities = new DescriptionEntities();
        BomFacade bomFacade = new BomFacade(database);
        getWidthAndLengthFromOrderId(2);
        //bomMapper.generateCarport(2,500,400);

        request.setAttribute("materialList", bomFacade.getMaterials());
        return pageToShow;
    }

}
