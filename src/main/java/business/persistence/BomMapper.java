package business.persistence;

import java.util.ArrayList;

public class BomMapper {

    int trykimpBrædtUnderSternForOgBagMål = 360;
    int getTrykimpBrædtUnderSternForOgBagAntal = 4;

    int tryKimpBrædtUnderSternTilSiderneMål = 540;
    int tryKimpBrædtUnderSternTilSidernAntal = 4;

    int tryKimpBrædtOverSternTilForendenMål = 360;
    int getTryKimpBrædtOverSternTilForendenAntal = 2;

    int tryKimpBrædtOverSternTilSiderneMål = 540;
    int tryKimpBrædtOverSternTilSiderneAntal = 4;

    int remmeAntal = 2;
    int remMål;

    int spærTræAntal;
    int spærTræMål;

    int stolpeAntal;

    int vandBrætSiderMål = 540;
    int getVandBrætSiderAntal = 4;

    int vandBrætForendeMål = 360;
    int vandBrætForendeAntal = 2;

    int tagPladerAntal;
    int tagPladerMål;

    int bundSkruerAntalPakker;

    int hulBånd = 2;

    int universalHøjreAntal;
    int universalVenstreAntal;

    int pakkeSkruer = 1;
    int pakkeBeslagSkruer = 1;

    int bræddeBolte;
    int firkantSkiver;

    public void calculateCarport(int length, int width) {

        double antalRegner = (length/100) / 0.55;
        double antalSkruer = length * width * 13 / 200;

        remMål = length;

        spærTræAntal = (int) Math.ceil(antalRegner);
        spærTræMål = width;

        if (length >= 500) {
            stolpeAntal = 6;
        } else {
            stolpeAntal = 4;
        }

        tagPladerAntal = width /100;

        if (length > 360) {
            tagPladerMål = 600;
        } else {
            tagPladerMål = 360;
        }

        bundSkruerAntalPakker = (int) Math.ceil(antalSkruer);
        universalHøjreAntal = (int) Math.ceil(antalRegner);
        universalVenstreAntal = (int) Math.ceil(antalRegner);

        bræddeBolte = stolpeAntal*2;
        firkantSkiver = stolpeAntal*2;

    }
}
