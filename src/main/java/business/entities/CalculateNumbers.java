package business.entities;

public class CalculateNumbers {

    private int bomId;
    private double distanceMeasure;
    private int screwKvm;
    private int postPerLength;
    private int screwPackageNumbers;
    private int minimumPosts;
    private int maximumPosts;

    public CalculateNumbers(int bomId, double distanceMeasure, int screwKvm, int postPerLength, int screwPackageNumbers, int minimumPosts, int maximumPosts) {
        this.bomId = bomId;
        this.distanceMeasure = distanceMeasure;
        this.screwKvm = screwKvm;
        this.postPerLength = postPerLength;
        this.screwPackageNumbers = screwPackageNumbers;
        this.minimumPosts = minimumPosts;
        this.maximumPosts = maximumPosts;
    }

    public int getMinimumPosts() {
        return minimumPosts;
    }

    public void setMinimumPosts(int minimumPosts) {
        this.minimumPosts = minimumPosts;
    }

    public int getMaximumPosts() {
        return maximumPosts;
    }

    public void setMaximumPosts(int maximumPosts) {
        this.maximumPosts = maximumPosts;
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
