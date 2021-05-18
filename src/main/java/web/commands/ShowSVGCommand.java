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

    private List<Material> collectBOM(int order_id){
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
                        rs.getString("description")));
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

        SVG svg = new SVG(0, 0, "0 0 855 690", 100, 100);
        for(int x = 0; x < 15; x++){
            svg.addRect(100 + 15*x, 0, 10.0, 10.0);
        }


        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}
