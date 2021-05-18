package business.services;

import business.entities.Material;
import business.persistence.BomMapper;
import business.persistence.Database;

import java.util.List;

//public class BomFacade {
//    BomEntities bomMapper;
//
//    public BomFacade(Database database) {
//        this.bomMapper = new BomEntities(database);
//    }
//
//    public String getList(int length, int width) {
//        bomMapper.calculateCarport(length, width);
//
//        return bomMapper.getMats();
//    }

public class BomFacade {
    BomMapper bomMapper;
    public BomFacade(Database database){
        this.bomMapper = new BomMapper(database);
    }

    public List<Material> getMaterials(){
        return bomMapper.getMaterials();
    }

}
