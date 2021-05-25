package business.services;

import business.entities.MeasureEntities;
import business.entities.StandardCarportEntity;
import business.persistence.CarportMapper;
import business.persistence.Database;

import java.util.List;



public class CarportFacade {
private CarportMapper carportMapper;


    public List<StandardCarportEntity> getStandardCarportEntitiesList() {
        return carportMapper.getStandardCarportEntitiesList();
    }

    public List<MeasureEntities> getMeasureEntities() {
        return carportMapper.getMeasureEntities();
    }



    public CarportFacade(Database database) {
        this.carportMapper = new CarportMapper(database);
    }

    public StandardCarportEntity getCarportFromId(int standard_id, List<StandardCarportEntity> standardCarportEntityList) throws NoSuchFieldException {


        for (StandardCarportEntity s : standardCarportEntityList) {
            if (s.getStandard_id() == standard_id) {
                return s;
            }
        }
        throw new NoSuchFieldException();

    }
}
