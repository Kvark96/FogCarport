package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<StandardCarportEntities> carports;
    private int calcprice =  0;

    public Cart(){
        carports = new ArrayList<>();
    }

    public void addCarport(StandardCarportEntities e){ carports.add(e);
        calcprice = calcPrice_();
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
            total += SCE.getPrice();
        }
        return total;
    }

    public void clearCart(){
        carports.clear();
    }

}
