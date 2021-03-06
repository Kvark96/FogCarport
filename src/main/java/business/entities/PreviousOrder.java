package business.entities;

import java.sql.Timestamp;

public class PreviousOrder {
    int order_id, user_id, length, width;
    int type;
    Timestamp created;
    double price;

    public PreviousOrder(int order_id, Timestamp created, double price, int user_id, int type, int length, int width){
        this.order_id = order_id;
        this.created = created;
        this.price = price;
        this.user_id = user_id;
        this.type = type;
        this.length =length;
        this.width = width;
    }

    public int getOrder_id() {return order_id;}

    public int getUser_id() {return user_id;}

    public int getLength() {return length;}

    public int getWidth() {return width;}

    public int getType() {return type;}

    public Timestamp getCreated() {return created;}

    public double getPrice() {return price;}
}