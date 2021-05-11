package business.services;

import business.persistence.BomMapper;
import business.persistence.Database;

public class BomFacade {
    BomMapper bomMapper;
    public BomFacade(Database database){
        this.bomMapper = new BomMapper(database);
    }

    public String getList(int length, int width){
        bomMapper.calculateCarport(length,width);

        return bomMapper.getMats();
    }


}
