package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<StandardCarportEntity> carports;
    private int calcprice =  0;

    public Cart(){
        carports = new ArrayList<>();
    }

    public void addCarport(StandardCarportEntity e){ carports.add(e);
        calcprice = calcPrice_();
    }

    public List<StandardCarportEntity> getCarports() {
        return carports;
    }

    public int getCalcprice() {
        return calcprice;
    }

    public int calcPrice_(){
        int total = 0;
        for(StandardCarportEntity SCE : carports){
            total += SCE.getPrice();
        }
        return total;
    }

    public void clearCart(){
        carports.clear();
    }

}
