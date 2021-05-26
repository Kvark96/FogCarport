package web.commands;

import business.entities.Orderline;
import business.exceptions.UserException;
import business.services.BomFacade;
import business.services.SVG;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowSVGCommand extends CommandUnprotectedPage {
    BomFacade bomFacade;
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
        bomFacade = new BomFacade(FrontController.database);
    }

    private List<Orderline> getBOM(int order_id) {
        List<Orderline> orderlines = bomFacade.getOrderlines(order_id);
        return orderlines;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int carportWidth = (int) session.getAttribute("width");
        int carportLength = (int) session.getAttribute("length");
        String viewBox = "0 0 780 780";
        SVG svg = new SVG(0,0,viewBox, 100, 100, carportLength, carportWidth);
        SVG innerSvg = new SVG(30, 25, viewBox, 80, 80, carportLength, carportWidth);


        int order_id = Integer.parseInt(request.getParameter("order_id"));
        innerSvg.addRect(0, 0, carportLength, carportWidth);
        List<Orderline> bom = getBOM(order_id);

        // Remme
        innerSvg.addRect(35, 0, bom.get(4).getLength(), 4.5);
        innerSvg.addRect(carportWidth - 35, 0, bom.get(4).getLength(), 4.5);


        // Spær
        int numberOfSpares = bom.get(5).getQuantity();
        int distBetweenSpares = carportLength / numberOfSpares;
        int startPosForSpares = distBetweenSpares / 2;

//        int startPosForPoles;

        for(int i = 0; i < numberOfSpares; i++){
            innerSvg.addRect(0, startPosForSpares  + distBetweenSpares * i, 4.5, bom.get(5).getLength());
            //if(i == 1) startPosForPoles = startPosForSpares  + distBetweenSpares * i;
        }

        // Stolper
        int numberOfPoles = bom.get(6).getQuantity();
        int startPosForPoles = startPosForSpares + distBetweenSpares;
        int distBetweenPoles = (carportWidth - (startPosForSpares  + distBetweenSpares * 2)) / 2;

        double poleSize = 9.7;

        // Left side of carport, same as the x value of the first rim - 2, for better visuals
        int pole_x1 = 33;

        // Right side of carport, same as above
        int pole_x2 = carportWidth - 37;

        // First set of poles are placed on the intersection of the second spare and the rim
        int pole_y1 = startPosForSpares + distBetweenSpares - 2;

        innerSvg.addRect(pole_x1, pole_y1, poleSize, poleSize);
        innerSvg.addRect(pole_x2, pole_y1, poleSize, poleSize);

        // Second set of poles are placed on the intersection of the second-to-last spare and the rim
        int pole_y2 = startPosForSpares + (numberOfSpares - 2) * distBetweenSpares - 2;

        innerSvg.addRect(pole_x1, pole_y2, poleSize, poleSize);
        innerSvg.addRect(pole_x2, pole_y2, poleSize, poleSize);

        // If there are 3 spares on either side, one pair is placed in the middle of pole_y1 and pole_y2
        if(numberOfPoles > 4){
            int pole_y3 = (pole_y2 - pole_y1)/ 2;
            pole_y3 += pole_y1;
            innerSvg.addRect(pole_x1, pole_y3, poleSize, poleSize);
            innerSvg.addRect(pole_x2, pole_y3, poleSize, poleSize);
        }

        // Hulbånd
        innerSvg.addDottedLine(pole_x1, pole_y1, pole_x2, pole_y2);
        innerSvg.addDottedLine(pole_x1, pole_y2, pole_x2, pole_y1);

        // Længde og bredde markører
        // Indre SVG tilføjes først, fordi det skal den :)
        svg.addSVG(innerSvg);
        svg.addArrow(0, carportLength, 0, 0, true);
        svg.addArrow(0, carportLength, carportWidth, carportLength, false);


        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}
