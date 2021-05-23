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
        int carportWidth = (int) session.getAttribute("width");
        int carportLength = (int) session.getAttribute("length");
        String viewBox = "0 0 780 780";
        SVG svg = new SVG(0, 0, viewBox, 100, 100);

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        System.out.println("In ShowSVGCommand, order_id = " + order_id);
        System.out.println("For reference, carportWidth = " + carportWidth + " and carportLength = " + carportLength);
        svg.addRect(0, 0, carportLength, carportWidth);
        List<Orderline> bom = getBOM(order_id);

        // Remme
        svg.addRect(35, 0, bom.get(4).getLength(), 4.5);
        svg.addRect(carportWidth - 35, 0, bom.get(4).getLength(), 4.5);


        // Spær
        int numberOfSpares = bom.get(5).getQuantity();
        System.out.println("number of spares = " + numberOfSpares);

        int distBetweenSpares = carportLength / numberOfSpares;
        System.out.println("dist = " + distBetweenSpares);

        int startPosForSpares = distBetweenSpares / 2;
        System.out.println("startPos = " + startPosForSpares);

//        int startPosForPoles;

        for(int i = 0; i < numberOfSpares; i++){
            svg.addRect(0, startPosForSpares  + distBetweenSpares * i, 4.5, bom.get(5).getLength());
            //if(i == 1) startPosForPoles = startPosForSpares  + distBetweenSpares * i;
        }

        // Stolper
        int numberOfPoles = bom.get(7).getQuantity();
        int startPosForPoles = startPosForSpares + distBetweenSpares;
        int distBetweenPoles = (carportWidth - (startPosForSpares  + distBetweenSpares * 2)) / 2;
        System.out.println(numberOfPoles);

        double poleSize = 9.7;

        // Left side of carport, same as the x value of the first rim - 2, for better visuals
        int x1 = 33;

        // Right side of carport, same as above
        int x2 = carportWidth - 37;

        // First set of poles are placed on the intersection of the second spare and the rim
        int y1 = startPosForSpares + distBetweenSpares;

        svg.addRect(x1, y1, poleSize, poleSize);
        svg.addRect(x2, y1, poleSize, poleSize);

        // Second set of poles are placed on the intersection of the second-to-last spare and the rim
        int y2 = startPosForSpares + (numberOfSpares - 2) * distBetweenSpares;

        svg.addRect(x1, y2, poleSize, poleSize);
        svg.addRect(x2, y2, poleSize, poleSize);

        // If there are 3 spares on either side, one pair is placed in the middle of y1 and y2
        if(numberOfPoles > 4){
            int y3 = y1 + y2 / 2;
            svg.addRect(x1, y3, poleSize, poleSize);
            svg.addRect(x2, y3, poleSize, poleSize);
        }
        

        System.out.println(bom);


        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}
