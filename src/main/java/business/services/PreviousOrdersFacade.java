package business.services;

import business.entities.PreviousOrder;
import business.persistence.Database;
import business.persistence.PreviousOrdersMapper;

import java.util.List;

public class PreviousOrdersFacade {

    PreviousOrdersMapper previousOrdersMapper;

    public PreviousOrdersFacade(Database database)
    {
        this.previousOrdersMapper = new PreviousOrdersMapper(database);
    }


    public List<PreviousOrder> getOldOrders(int user_id) {
        return previousOrdersMapper.getOldOrders(user_id);
    }
}
