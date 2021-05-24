package business.entities;

public class CalculateNumbers {

    private int bomId;
    private double distanceMeasure;
    private int screwKvm;
    private int postPerLength;
    private int screwPackageNumbers;

    public CalculateNumbers(int bomId, double distanceMeasure, int screwKvm, int postPerLength, int screwPackageNumbers) {
        this.bomId = bomId;
        this.distanceMeasure = distanceMeasure;
        this.screwKvm = screwKvm;
        this.postPerLength = postPerLength;
        this.screwPackageNumbers = screwPackageNumbers;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }

    public double getDistanceMeasure() {
        return distanceMeasure;
    }

    public void setDistanceMeasure(double distanceMeasure) {
        this.distanceMeasure = distanceMeasure;
    }

    public int getScrewKvm() {
        return screwKvm;
    }

    public void setScrewKvm(int screwKvm) {
        this.screwKvm = screwKvm;
    }

    public int getPostPerLength() {
        return postPerLength;
    }

    public void setPostPerLength(int postPerLength) {
        this.postPerLength = postPerLength;
    }

    public int getScrewPackageNumbers() {
        return screwPackageNumbers;
    }

    public void setScrewPackageNumbers(int screwPackageNumbers) {
        this.screwPackageNumbers = screwPackageNumbers;
    }
}
