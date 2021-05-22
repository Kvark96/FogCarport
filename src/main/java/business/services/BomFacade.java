package business.services;

import business.entities.Material;
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

}
