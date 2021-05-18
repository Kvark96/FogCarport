package business.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x, y, width, height;
    private String viewBox;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\" " +
            "y=\"%d\" " +
            "preserveAspectRatio=\"xMinYMin\">";

    public SVG(int x, int y, String viewBox, int height, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.viewBox = viewBox;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
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

    public void addLine(int x1, int y1, int x2, int y2){
        String line = "<line " +
                "x1=\"" + x1 + "\" " +
                "y1=\"" + y1 + "\" " +
                "x2=\"" + x2 + "\" " +
                "y2=\"" + y2 + "\" " +
                "style=\"stroke:#000000; stroke-dasharray:10,10;\"" +
                "/>";

        svg.append(line);
    }

    public void addSVG(SVG innerSVG){
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
