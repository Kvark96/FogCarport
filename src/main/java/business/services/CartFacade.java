package business.services;

import business.persistence.CartMapper;
import business.persistence.Database;

public class CartFacade {
    CartMapper cartMapper;
    public CartFacade(Database database){
        cartMapper = new CartMapper(database);
    }


    public void addStandardCarportToOrders(int user_id, int isARequest, int standard_id, int price) {
        cartMapper.addStandardCarportToOrders(user_id, isARequest, standard_id, price);
    }
}
