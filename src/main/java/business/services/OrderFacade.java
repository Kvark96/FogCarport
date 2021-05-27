package business.services;

import business.entities.Cart;
import business.entities.Order;
import business.entities.Orderline;
import business.entities.StandardCarportEntity;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.ArrayList;
import java.util.List;

public class OrderFacade {
    private final OrderMapper orderMapper;
    private Database database;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
        this.database = database;
    }

    public void addOrderToDatabase(int user_id, int length, int width, int customer_request) {
        orderMapper.addOrderToDatabase(user_id, length, width, customer_request);
    }

    public int getLatestOrderIdFromUserId(int user_id) {
        return orderMapper.getLatestOrderIDFromUserID(user_id);
    }

    public List<Order> getOrdersFromDatabase(int customer_request) {
        return orderMapper.getOrdersFromDatabase(customer_request);
    }

    public Order getOrderFromDatabase(int order_id) {
        return orderMapper.getOrderFromDatabase(order_id);
    }

    public Order getFullOrderFromDatabase(int order_id) {
        Order fullOrder = orderMapper.getOrderFromDatabase(order_id);
        BomFacade bomFacade = new BomFacade(database);
        List<Orderline> oL = bomFacade.getOrderlines(fullOrder.getOrder_id());
        fullOrder.setOrderlines(oL);
        return fullOrder;
    }
    public void addStandardCarportToOrders(int user_id, int isARequest, Cart cart){
        orderMapper.addOrderToDatabase(user_id,isARequest, cart);
        int order_id = orderMapper.getLatestOrderIDFromUserID(user_id);
        List<Orderline> orderlines = new ArrayList<>();
        for (StandardCarportEntity carport: cart.getCarports()) {
            Orderline orderline = new Orderline(order_id,1,carport);
            orderlines.add(orderline);
        }
        orderMapper.addOrderlineToDatabase(orderlines);
    }
}
