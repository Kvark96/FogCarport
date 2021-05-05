package business.entities;

public class MeasureEntities {

    int measure_id;
    int length;
    int width;

    public MeasureEntities(int measure_id, int length, int width) {
        this.measure_id = measure_id;
        this.length = length;
        this.width = width;
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "MeasureEntities{" +
                "measure_id=" + measure_id +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
