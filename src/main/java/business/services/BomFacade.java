package business.services;

import business.entities.Material;
import business.entities.Orderline;
import business.persistence.BomMapper;
import business.persistence.Database;

import java.util.List;

public class BomFacade {
    BomMapper bomMapper;
    public BomFacade(Database database){
        this.bomMapper = new BomMapper(database);
    }

    public List<Material> getOrderLineMaterials(int order_id){
        return bomMapper.getOrderLineMaterials(order_id);
    }

    public List<Orderline> getOrderlines(int order_id){
        return bomMapper.getOrderlines(order_id);
    }

    public void generateCarport(int order_id, int length, int width){
        bomMapper.generateCarport(order_id, length, width);
    }


}
