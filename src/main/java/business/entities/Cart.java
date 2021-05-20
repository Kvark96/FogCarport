package business.entities;

import java.util.ArrayList;
import java.util.List;

// IDs are sent through menu, and collected in cart.
// When a given standard carport is selected from the menu,
// the request is redirected through cartCommand, which creates this
// object and adds the ID from requestScope to the list of integers.

public class Cart {
    private List<StandardCarportEntities> carports;
    private int calcprice =  0;

    public Cart(){
        carports = new ArrayList<>();
    }

    public void addCarport(StandardCarportEntities e){ carports.add(e);
        calcprice =calcPrice_();
    }

    public List<StandardCarportEntities> getCarports() {
        return carports;
    }

    public int getCalcprice() {
        return calcprice;
    }

    public int calcPrice_(){
        int total = 0;
        for(StandardCarportEntities SCE : carports){
            total += SCE.getCalcPrice();
        }
        return total;
    }

}
