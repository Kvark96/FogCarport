package business.entities;

import java.util.ArrayList;

public class BomEntities {

    //ArrayList<Integer> materials = new ArrayList<>();

   private int pressureBoardUnderSternFrontAndBackMeasure = 360;
   private int pressureBoardUnderSternFrontAndBackQuant = 4;

   private int tryKimpBrædtUnderSternTilSiderneMål = 540;
   private int tryKimpBrædtUnderSternTilSidernAntal = 4;

   private int tryKimpBrædtOverSternTilForendenMål = 360;
   private int getTryKimpBrædtOverSternTilForendenAntal = 2;

   private int tryKimpBrædtOverSternTilSiderneMål = 540;
   private int tryKimpBrædtOverSternTilSiderneAntal = 4;

   private int remmeAntal = 2;
   private int remMål;

   private int spærTræAntal;
   private int spærTræMål;

   private int stolpeAntal;

   private int vandBrætSiderMål = 540;
   private int getVandBrætSiderAntal = 4;

   private int vandBrætForendeMål = 360;
   private int vandBrætForendeAntal = 2;

   private int tagPladerAntal;
   private int tagPladerMål;

   private int bundSkruerAntalPakker;

   private int hulBånd = 2;

   private int universalHøjreAntal;
   private int universalVenstreAntal;

   private int pakkeSkruer = 1;
   private int pakkeBeslagSkruer = 1;

   private int bræddeBolte;
   private int firkantSkiver;

    public BomEntities(int width, int length) {
        generateCarport(length, width);
    }

    public int getTrykimpBrædtUnderSternForOgBagMål() {
        return trykimpBrædtUnderSternForOgBagMål;
    }

    public void setTrykimpBrædtUnderSternForOgBagMål(int trykimpBrædtUnderSternForOgBagMål) {
        this.trykimpBrædtUnderSternForOgBagMål = trykimpBrædtUnderSternForOgBagMål;
    }

    public int getGetTrykimpBrædtUnderSternForOgBagAntal() {
        return getTrykimpBrædtUnderSternForOgBagAntal;
    }

    public void setGetTrykimpBrædtUnderSternForOgBagAntal(int getTrykimpBrædtUnderSternForOgBagAntal) {
        this.getTrykimpBrædtUnderSternForOgBagAntal = getTrykimpBrædtUnderSternForOgBagAntal;
    }

    public int getTryKimpBrædtUnderSternTilSiderneMål() {
        return tryKimpBrædtUnderSternTilSiderneMål;
    }

    public void setTryKimpBrædtUnderSternTilSiderneMål(int tryKimpBrædtUnderSternTilSiderneMål) {
        this.tryKimpBrædtUnderSternTilSiderneMål = tryKimpBrædtUnderSternTilSiderneMål;
    }

    public int getTryKimpBrædtUnderSternTilSidernAntal() {
        return tryKimpBrædtUnderSternTilSidernAntal;
    }

    public void setTryKimpBrædtUnderSternTilSidernAntal(int tryKimpBrædtUnderSternTilSidernAntal) {
        this.tryKimpBrædtUnderSternTilSidernAntal = tryKimpBrædtUnderSternTilSidernAntal;
    }

    public int getTryKimpBrædtOverSternTilForendenMål() {
        return tryKimpBrædtOverSternTilForendenMål;
    }

    public void setTryKimpBrædtOverSternTilForendenMål(int tryKimpBrædtOverSternTilForendenMål) {
        this.tryKimpBrædtOverSternTilForendenMål = tryKimpBrædtOverSternTilForendenMål;
    }

    public int getGetTryKimpBrædtOverSternTilForendenAntal() {
        return getTryKimpBrædtOverSternTilForendenAntal;
    }

    public void setGetTryKimpBrædtOverSternTilForendenAntal(int getTryKimpBrædtOverSternTilForendenAntal) {
        this.getTryKimpBrædtOverSternTilForendenAntal = getTryKimpBrædtOverSternTilForendenAntal;
    }

    public int getTryKimpBrædtOverSternTilSiderneMål() {
        return tryKimpBrædtOverSternTilSiderneMål;
    }

    public void setTryKimpBrædtOverSternTilSiderneMål(int tryKimpBrædtOverSternTilSiderneMål) {
        this.tryKimpBrædtOverSternTilSiderneMål = tryKimpBrædtOverSternTilSiderneMål;
    }

    public int getTryKimpBrædtOverSternTilSiderneAntal() {
        return tryKimpBrædtOverSternTilSiderneAntal;
    }

    public void setTryKimpBrædtOverSternTilSiderneAntal(int tryKimpBrædtOverSternTilSiderneAntal) {
        this.tryKimpBrædtOverSternTilSiderneAntal = tryKimpBrædtOverSternTilSiderneAntal;
    }

    public int getRemmeAntal() {
        return remmeAntal;
    }

    public void setRemmeAntal(int remmeAntal) {
        this.remmeAntal = remmeAntal;
    }

    public int getRemMål() {
        return remMål;
    }

    public void setRemMål(int remMål) {
        this.remMål = remMål;
    }

    public int getSpærTræAntal() {
        return spærTræAntal;
    }

    public void setSpærTræAntal(int spærTræAntal) {
        this.spærTræAntal = spærTræAntal;
    }

    public int getSpærTræMål() {
        return spærTræMål;
    }

    public void setSpærTræMål(int spærTræMål) {
        this.spærTræMål = spærTræMål;
    }

    public int getStolpeAntal() {
        return stolpeAntal;
    }

    public void setStolpeAntal(int stolpeAntal) {
        this.stolpeAntal = stolpeAntal;
    }

    public int getVandBrætSiderMål() {
        return vandBrætSiderMål;
    }

    public void setVandBrætSiderMål(int vandBrætSiderMål) {
        this.vandBrætSiderMål = vandBrætSiderMål;
    }

    public int getGetVandBrætSiderAntal() {
        return getVandBrætSiderAntal;
    }

    public void setGetVandBrætSiderAntal(int getVandBrætSiderAntal) {
        this.getVandBrætSiderAntal = getVandBrætSiderAntal;
    }

    public int getVandBrætForendeMål() {
        return vandBrætForendeMål;
    }

    public void setVandBrætForendeMål(int vandBrætForendeMål) {
        this.vandBrætForendeMål = vandBrætForendeMål;
    }

    public int getVandBrætForendeAntal() {
        return vandBrætForendeAntal;
    }

    public void setVandBrætForendeAntal(int vandBrætForendeAntal) {
        this.vandBrætForendeAntal = vandBrætForendeAntal;
    }

    public int getTagPladerAntal() {
        return tagPladerAntal;
    }

    public void setTagPladerAntal(int tagPladerAntal) {
        this.tagPladerAntal = tagPladerAntal;
    }

    public int getTagPladerMål() {
        return tagPladerMål;
    }

    public void setTagPladerMål(int tagPladerMål) {
        this.tagPladerMål = tagPladerMål;
    }

    public int getBundSkruerAntalPakker() {
        return bundSkruerAntalPakker;
    }

    public void setBundSkruerAntalPakker(int bundSkruerAntalPakker) {
        this.bundSkruerAntalPakker = bundSkruerAntalPakker;
    }

    public int getHulBånd() {
        return hulBånd;
    }

    public void setHulBånd(int hulBånd) {
        this.hulBånd = hulBånd;
    }

    public int getUniversalHøjreAntal() {
        return universalHøjreAntal;
    }

    public void setUniversalHøjreAntal(int universalHøjreAntal) {
        this.universalHøjreAntal = universalHøjreAntal;
    }

    public int getUniversalVenstreAntal() {
        return universalVenstreAntal;
    }

    public void setUniversalVenstreAntal(int universalVenstreAntal) {
        this.universalVenstreAntal = universalVenstreAntal;
    }

    public int getPakkeSkruer() {
        return pakkeSkruer;
    }

    public void setPakkeSkruer(int pakkeSkruer) {
        this.pakkeSkruer = pakkeSkruer;
    }

    public int getPakkeBeslagSkruer() {
        return pakkeBeslagSkruer;
    }

    public void setPakkeBeslagSkruer(int pakkeBeslagSkruer) {
        this.pakkeBeslagSkruer = pakkeBeslagSkruer;
    }

    public int getBræddeBolte() {
        return bræddeBolte;
    }

    public void setBræddeBolte(int bræddeBolte) {
        this.bræddeBolte = bræddeBolte;
    }

    public int getFirkantSkiver() {
        return firkantSkiver;
    }

    public void setFirkantSkiver(int firkantSkiver) {
        this.firkantSkiver = firkantSkiver;
    }

    public String getMats() {
        return "antal remme: " + remmeAntal + " Remmemål: " + remMål +
                "\nantal Spærtræ: " + spærTræAntal + " spærtræ mål: " + spærTræMål +
                "\nantal stolper: " + stolpeAntal +
                "\nantal Tagplader: " + tagPladerAntal + "tagplade mål: " + tagPladerMål +
                "\nantal bundskruepakker: " + bundSkruerAntalPakker +
                "\nantal bræddebolte: " + bræddeBolte +
                "\nantal firkantSkiver: " + firkantSkiver;
    }


    public void generateCarport(int length, int width) {


        double antalRegner = (length / 100) / 0.55;
        double antalSkruer = length * width * 13 / 200;

        remMål = length;

        spærTræAntal = (int) Math.ceil(antalRegner);
        spærTræMål = width;

        if (length >= 500) {
            stolpeAntal = 6;
        } else {
            stolpeAntal = 4;
        }

        tagPladerAntal = width / 100;

        if (length > 360) {
            tagPladerMål = 600;
        } else {
            tagPladerMål = 360;
        }

        bundSkruerAntalPakker = (int) Math.ceil(antalSkruer);
        universalHøjreAntal = (int) Math.ceil(antalRegner);
        universalVenstreAntal = (int) Math.ceil(antalRegner);

        bræddeBolte = stolpeAntal * 2;
        firkantSkiver = stolpeAntal * 2;

//        materials.add(trykimpBrædtUnderSternForOgBagMål);
//        materials.add(getTrykimpBrædtUnderSternForOgBagAntal);
//        materials.add(tryKimpBrædtUnderSternTilSiderneMål);
//        materials.add(tryKimpBrædtUnderSternTilSidernAntal);
//        materials.add(tryKimpBrædtOverSternTilForendenMål);
//        materials.add(getTryKimpBrædtOverSternTilForendenAntal);
//        materials.add(tryKimpBrædtOverSternTilSiderneMål);
//        materials.add(tryKimpBrædtOverSternTilSiderneAntal);
//        materials.add(remmeAntal);
//        materials.add(remMål);
//        materials.add(spærTræAntal);
//        materials.add(spærTræMål);
//        materials.add(stolpeAntal);
//        materials.add(vandBrætSiderMål);
//        materials.add(getVandBrætSiderAntal);
//        materials.add(vandBrætForendeMål);
//        materials.add(vandBrætForendeAntal);
//        materials.add(tagPladerAntal);
//        materials.add(tagPladerMål);
//        materials.add(bundSkruerAntalPakker);
//        materials.add(hulBånd);
//        materials.add(universalHøjreAntal);
//        materials.add(universalVenstreAntal);
//        materials.add(pakkeSkruer);
//        materials.add(pakkeBeslagSkruer);
//        materials.add(bræddeBolte);
//        materials.add(firkantSkiver);
//
//                return materials;

    }
}
