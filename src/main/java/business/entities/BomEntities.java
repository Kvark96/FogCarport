package business.entities;

import java.util.ArrayList;

public class BomEntities {

    //ArrayList<Integer> materials = new ArrayList<>();

   private int pressureBoardUnderSternFrontAndBackMeasure = 360;
   private int pressureBoardUnderSternFrontAndBackQuant = 4;

   private int pressureBoardUnderSternSidesMeasure = 540;
   private int pressureBoardUnderSternSidesQuant = 4;

   private int pressureBoardOverSternFrontMeasure = 360;
   private int pressureBoardOverSternFrontQuant = 2;

   private int pressureBoardOverSternSidesMeasure = 540;
   private int pressureBoardOverSternSidesQuant = 4;

   private int wallPlateQuant = 2; //remme
   private int wallPlatemeasure;

   private int rafterQuant; //spærtræ
   private int rafterMeasure;

   private int beamQuant; //stolpe

   private int weatherBoardSidesMeasure = 540; //vandbræt
   private int weatherBoardSidesQuant = 4;

   private int weatherBoardFrontMeasure = 360;
   private int weatherBoardFrontQuant = 2;

   private int roofPlatesQuant;  //tagPlader
   private int roofPlatesMeasure;

   private int screwFasteningQuantPackages; //bundskrue

   private int punchTape = 2; //hulbånd

   private int universalRightQuant;
   private int universalLeftQuant;

   private int screwPacks = 1;
   private int mountScrewPacks = 1;   //beslagSkruer

   private int boardBolt;  //boardBolt
   private int squareDiscs;   //squareDiscs

    public BomEntities(int width, int length) {
        generateCarport(length, width);
    }

    public int getPressureBoardUnderSternFrontAndBackMeasure() {
        return pressureBoardUnderSternFrontAndBackMeasure;
    }

    public void setPressureBoardUnderSternFrontAndBackMeasure(int pressureBoardUnderSternFrontAndBackMeasure) {
        this.pressureBoardUnderSternFrontAndBackMeasure = pressureBoardUnderSternFrontAndBackMeasure;
    }

    public int getPressureBoardUnderSternFrontAndBackQuant() {
        return pressureBoardUnderSternFrontAndBackQuant;
    }

    public void setPressureBoardUnderSternFrontAndBackQuant(int pressureBoardUnderSternFrontAndBackQuant) {
        this.pressureBoardUnderSternFrontAndBackQuant = pressureBoardUnderSternFrontAndBackQuant;
    }

    public int getpressureBoardUnderSternSidesMeasure() {
        return pressureBoardUnderSternSidesMeasure;
    }

    public void setPressureBoardUnderSternSidesMeasure(int pressureBoardUnderSternSidesMeasure) {
        this.pressureBoardUnderSternSidesMeasure = pressureBoardUnderSternSidesMeasure;
    }

    public int getPressureBoardUnderSternSidesQuant() {
        return pressureBoardUnderSternSidesQuant;
    }

    public void setPressureBoardUnderSternSidesQuant(int pressureBoardUnderSternSidesQuant) {
        this.pressureBoardUnderSternSidesQuant = pressureBoardUnderSternSidesQuant;
    }

    public int getPressureBoardOverSternFrontMeasure() {
        return pressureBoardOverSternFrontMeasure;
    }

    public void setPressureBoardOverSternFrontMeasure(int pressureBoardOverSternFrontMeasure) {
        this.pressureBoardOverSternFrontMeasure = pressureBoardOverSternFrontMeasure;
    }

    public int getPressureBoardOverSternFrontQuant() {
        return pressureBoardOverSternFrontQuant;
    }

    public void setPressureBoardOverSternFrontQuant(int pressureBoardOverSternFrontQuant) {
        this.pressureBoardOverSternFrontQuant = pressureBoardOverSternFrontQuant;
    }

    public int getPressureBoardOverSternSidesMeasure() {
        return pressureBoardOverSternSidesMeasure;
    }

    public void setPressureBoardOverSternSidesMeasure(int pressureBoardOverSternSidesMeasure) {
        this.pressureBoardOverSternSidesMeasure = pressureBoardOverSternSidesMeasure;
    }

    public int getPressureBoardOverSternSidesQuant() {
        return pressureBoardOverSternSidesQuant;
    }

    public void setPressureBoardOverSternSidesQuant(int pressureBoardOverSternSidesQuant) {
        this.pressureBoardOverSternSidesQuant = pressureBoardOverSternSidesQuant;
    }

    public int getWallPlateQuant() {
        return wallPlateQuant;
    }

    public void setWallPlateQuant(int wallPlateQuant) {
        this.wallPlateQuant = wallPlateQuant;
    }

    public int getWallPlatemeasure() {
        return wallPlatemeasure;
    }

    public void setWallPlatemeasure(int wallPlatemeasure) {
        this.wallPlatemeasure = wallPlatemeasure;
    }

    public int getRafterQuant() {
        return rafterQuant;
    }

    public void setRafterQuant(int rafterQuant) {
        this.rafterQuant = rafterQuant;
    }

    public int getRafterMeasure() {
        return rafterMeasure;
    }

    public void setRafterMeasure(int rafterMeasure) {
        this.rafterMeasure = rafterMeasure;
    }

    public int getBeamQuant() {
        return beamQuant;
    }

    public void setBeamQuant(int beamQuant) {
        this.beamQuant = beamQuant;
    }

    public int getWeatherBoardSidesMeasure() {
        return weatherBoardSidesMeasure;
    }

    public void setWeatherBoardSidesMeasure(int weatherBoardSidesMeasure) {
        this.weatherBoardSidesMeasure = weatherBoardSidesMeasure;
    }

    public int getWeatherBoardSidesQuant() {
        return weatherBoardSidesQuant;
    }

    public void setWeatherBoardSidesQuant(int weatherBoardSidesQuant) {
        this.weatherBoardSidesQuant = weatherBoardSidesQuant;
    }

    public int getWeatherBoardFrontMeasure() {
        return weatherBoardFrontMeasure;
    }

    public void setWeatherBoardFrontMeasure(int weatherBoardFrontMeasure) {
        this.weatherBoardFrontMeasure = weatherBoardFrontMeasure;
    }

    public int getWeatherBoardFrontQuant() {
        return weatherBoardFrontQuant;
    }

    public void setWeatherBoardFrontQuant(int weatherBoardFrontQuant) {
        this.weatherBoardFrontQuant = weatherBoardFrontQuant;
    }

    public int getRoofPlatesQuant() {
        return roofPlatesQuant;
    }

    public void setRoofPlatesQuant(int roofPlatesQuant) {
        this.roofPlatesQuant = roofPlatesQuant;
    }

    public int getRoofPlatesMeasure() {
        return roofPlatesMeasure;
    }

    public void setRoofPlatesMeasure(int roofPlatesMeasure) {
        this.roofPlatesMeasure = roofPlatesMeasure;
    }

    public int getScrewFasteningQuantPackages() {
        return screwFasteningQuantPackages;
    }

    public void setScrewFasteningQuantPackages(int screwFasteningQuantPackages) {
        this.screwFasteningQuantPackages = screwFasteningQuantPackages;
    }

    public int getPunchTape() {
        return punchTape;
    }

    public void setPunchTape(int punchTape) {
        this.punchTape = punchTape;
    }

    public int getUniversalRightQuant() {
        return universalRightQuant;
    }

    public void setUniversalRightQuant(int universalRightQuant) {
        this.universalRightQuant = universalRightQuant;
    }

    public int getUniversalLeftQuant() {
        return universalLeftQuant;
    }

    public void setUniversalLeftQuant(int universalLeftQuant) {
        this.universalLeftQuant = universalLeftQuant;
    }

    public int getScrewPacks() {
        return screwPacks;
    }

    public void setScrewPacks(int screwPacks) {
        this.screwPacks = screwPacks;
    }

    public int getMountScrewPacks() {
        return mountScrewPacks;
    }

    public void setMountScrewPacks(int mountScrewPacks) {
        this.mountScrewPacks = mountScrewPacks;
    }

    public int getBoardBolt() {
        return boardBolt;
    }

    public void setBoardBolt(int boardBolt) {
        this.boardBolt = boardBolt;
    }

    public int getSquareDiscs() {
        return squareDiscs;
    }

    public void setSquareDiscs(int squareDiscs) {
        this.squareDiscs = squareDiscs;
    }


    public void generateCarport(int length, int width) {


        double antalRegner = (length / 100) / 0.55;
        double antalSkruer = length * width * 13 / 200;

        wallPlatemeasure = length;

        rafterQuant = (int) Math.ceil(antalRegner);
        rafterMeasure = width;

        if (length >= 500) {
            beamQuant = 6;
        } else {
            beamQuant = 4;
        }

        roofPlatesQuant = width / 100;

        if (length > 360) {
            roofPlatesMeasure = 600;
        } else {
            roofPlatesMeasure = 360;
        }

        screwFasteningQuantPackages = (int) Math.ceil(antalSkruer);
        universalRightQuant = (int) Math.ceil(antalRegner);
        universalLeftQuant = (int) Math.ceil(antalRegner);

        boardBolt = beamQuant * 2;
        squareDiscs = beamQuant * 2;

//        materials.add(trykimpBrædtUnderSternForOgBagMål);
//        materials.add(getTrykimpBrædtUnderSternForOgBagAntal);
//        materials.add(tryKimpBrædtUnderSternTilSiderneMål);
//        materials.add(pressureBoardUnderSternSidesQuant);
//        materials.add(pressureBoardOverSternFrontMeasure);
//        materials.add(pressureBoardOverSternFrontQuant);
//        materials.add(pressureBoardOverSternSidesMeasure);
//        materials.add(pressureBoardOverSternSidesQuant);
//        materials.add(wallPlateQuant);
//        materials.add(wallPlatemeasure);
//        materials.add(rafterQuant);
//        materials.add(rafterMeasure);
//        materials.add(beamQuant);
//        materials.add(weatherBoardSidesMeasure);
//        materials.add(weatherBoardSidesQuant);
//        materials.add(weatherBoardFrontMeasure);
//        materials.add(weatherBoardFrontQuant);
//        materials.add(roofPlatesQuant);
//        materials.add(roofPlatesMeasure);
//        materials.add(screwFasteningQuantPackages);
//        materials.add(punchTape);
//        materials.add(universalRightQuant);
//        materials.add(universalLeftQuant);
//        materials.add(screwPacks);
//        materials.add(mountScrewPacks);
//        materials.add(boardBolt);
//        materials.add(squareDiscs);
//
//                return materials;


    }
}
