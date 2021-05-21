package web.commands;

import business.entities.Material;
import business.entities.Orderline;
import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowSVGCommand extends CommandUnprotectedPage {
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    private List<Orderline> getBOM(int order_id) {

        List<Orderline> orderlines = new ArrayList<>();
        String sql = "SELECT * FROM carport.orderline WHERE order_id = ?";
        try (Connection connection = database.connect()) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                orderlines.add(new Orderline(
                        order_id,
                        rs.getInt("quantity"),
                        rs.getInt("materials_length"),
                        rs.getInt("materials_id")));
            }

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return orderlines;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int width = (int) session.getAttribute("width");
        int length = (int) session.getAttribute("length");
        String viewBox = "0 0 780 780";
        SVG svg = new SVG(0, 0, viewBox, 100, 100);

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        System.out.println("In ShowSVGCommand, order_id = " + order_id);
        System.out.println("For reference, width = " + width + " and length = " + length);
        svg.addRect(0, 0, length, width);
        List<Orderline> bom = getBOM(order_id);
        System.out.println(bom);


        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}
