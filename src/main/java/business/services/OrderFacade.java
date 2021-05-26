package business.services;

import business.entities.Order;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {
    private final OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }

    public void addOrderToDatabase(int user_id, int length, int width, int customer_request){
        orderMapper.addOrderToDatabase(user_id, length, width, customer_request);
    }

    public int getLatestOrderIdFromUserId(int user_id){
        return orderMapper.getLatestOrderIDFromUserID(user_id);
    }

    public List<Order> getOrdersFromDatabase(int customer_request) {
        return orderMapper.getOrdersFromDatabase(customer_request);
    }

    public Order getFullOrderFromDatabase(int order_id){
        return orderMapper.getFullOrderFromDatabase(order_id);
    }
}
