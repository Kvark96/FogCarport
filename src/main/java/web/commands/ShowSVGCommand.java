package web.commands;

import business.entities.Material;
import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowSVGCommand extends CommandUnprotectedPage{
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    private List<Material> getBOM(int order_id){
        List<Material> bom = new ArrayList<>();
        String sql = "SELECT * FROM carport.orderline WHERE order_id = ?";
        try(Connection connection = database.connect())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bom.add(new Material(
                        rs.getInt("material_id"),
                        rs.getString("name"),
                        rs.getInt("length"),
                        rs.getInt("unit"),
                        rs.getString("description"),
                        rs.getString("unit")));
            }

        } catch(SQLException se)
        {
            System.out.println(se.getMessage());
            se.printStackTrace();
        }
        return bom;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        //String order_id = (String) request.getParameter("order_id");
        String width = request.getParameter("width");
        String length = request.getParameter("length");
        String viewBox = "0 0 "  +  length + " " + width;
        SVG svg = new SVG(0, 0, viewBox, 100, 100);

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        List<Material> bom = getBOM(order_id);



        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}
