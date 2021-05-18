package business.entities;

import java.util.ArrayList;
import java.util.List;

// IDs are sent through menu, and collected in cart.
// When a given standard carport is selected from the menu,
// the request is redirected through cartCommand, which creates this
// object and adds the ID from requestScope to the list of integers.

public class Cart {
    private List<StandardCarportEntities> carports;

    public Cart(){
        carports = new ArrayList<>();
    }

    public void addCarport(StandardCarportEntities e){ carports.add(e);
    }
}
