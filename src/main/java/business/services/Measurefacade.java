package business.services;

import business.entities.MeasureEntities;
import business.persistence.CarportMapper;

import java.util.List;


public class Measurefacade {


    CarportMapper carportMapper;

    public Measurefacade(CarportMapper carportMapper) {
        this.carportMapper = carportMapper;
    }



    public List<MeasureEntities> MeasureEntities() {
        return carportMapper.getMeasureEntities();
    }

}
