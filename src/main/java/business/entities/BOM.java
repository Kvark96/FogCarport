package business.entities;

import java.util.ArrayList;
import java.util.List;

// Bill of Materials (Stykliste)
public class BOM {

    public void calcBOM(Order order){
        List<Material> bom = new ArrayList<>();

    }

    //width = {240, 750}     length = {240, 780}
    private int calcNoOfPoles(int length, int width, boolean hasToolShed){
        int total = 4;

        if(width <= 300) {
        }

        if(hasToolShed){
            total += 4;
        }
        return 0;
    }

}
