package business.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x, y, width, height;
    private String viewBox;
    private int carportLength;
    private int carportWidth;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\" " +
            "y=\"%d\" " +
            "preserveAspectRatio=\"xMinYMin\">";

    private final String markerDev = "\n<defs>\n" +
            "    <marker\n" +
            "            id=\"beginArrow\"\n" +
            "            markerWidth=\"12\"\n" +
            "            markerHeight=\"12\"\n" +
            "            refX=\"0\"\n" +
            "            refY=\"6\"\n" +
            "            orient=\"auto\">\n" +
            "      <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "    </marker>\n" +
            "    <marker\n" +
            "            id=\"endArrow\"\n" +
            "            markerWidth=\"12\"\n" +
            "            markerHeight=\"12\"\n" +
            "            refX=\"12\"\n" +
            "            refY=\"6\"\n" +
            "            orient=\"auto\">\n" +
            "      <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "    </marker>\n" +
            "  </defs>";

    public SVG(int x, int y, String viewBox, int height, int width, int carportLength, int carportWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.viewBox = viewBox;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
        svg.append(markerDev);
    }

    public void addRect(int x, int y, double height, double width){
        String rect = "<rect " +
                "x=\"" + x + "\" " +
                "y=\"" + y + "\" " +
                "height=\"" + height + "\" " +
                "width=\"" + width + "\" " +
                "style=\"stroke:#000000; " +
                "fill: #ffffff\"" +
                "/>";
        svg.append(rect);
    }

    public void addDottedLine(int x1, int y1, int x2, int y2){
        String line = "<line " +
                "x1=\"" + x1 + "\" " +
                "y1=\"" + y1 + "\" " +
                "x2=\"" + x2 + "\" " +
                "y2=\"" + y2 + "\" " +
                "style=\"stroke:#000000; stroke-dasharray:10,10;\"" +
                "/>";

        svg.append(line);
    }

    public void addArrow(int x1, int y1, int x2, int y2, boolean isVertical){
        String arrow =
                "<line " +
                        "x1=\"" + x1 + "\" " +
                        "y1=\"" + y1 + "\" " +
                        "x2=\"" + x2 + "\" " +
                        "y2=\"" + y2 + "\" " +

                        "style=\"stroke: #006600; marker-end: url(#endArrow):\"/>" +
                        "\n";

        // The text is styled differently for vertical and horizontal lines.
        // This could possibly be done more efficiently with ternary operators,
        // but is more verbose for the sake of clarity.
        if(isVertical){
            // New x and y values are created to move the text out of the way of the line and center it.
            int newX = x1 + 25;
            int newY = y1 / 2;
            arrow = arrow +
                    "<text style=\"text-anchor: middle\" " +
                    "transform=\"translate(" + newX + "," + newY +") " +
                    "rotate(-90)\">" + carportLength + " cm" +
                    "</text>";
        } else {
            int newX = x2 / 2;
            int newY = y1 - 10;
            arrow = arrow +
                    "<text style=\"text-anchor: middle\" " +
                    "transform=\"translate(" + newX + "," + newY +")\">" + carportWidth + " cm" +
                    "</text>";
        }

        svg.append(arrow);

    /*
    <line x1="0"  y1="600" x2=""   y2="0"
        style="stroke: #006600;
        marker-end: url(#endArrow);"/>

    <text style="text-anchor: middle" transform="translate(25,300) rotate(-90)">600 cm</text>
    */

    }

    public void addSVG(SVG innerSVG){
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
