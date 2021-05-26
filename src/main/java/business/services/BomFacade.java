package business.services;

import business.entities.CalculateNumbers;
import business.entities.Material;
import business.entities.Orderline;
import business.persistence.BomCalculateMapper;
import business.persistence.BomMapper;
import business.persistence.Database;

import java.util.List;

public class BomFacade {
    BomMapper bomMapper;
    BomCalculateMapper bomCalculateMapper;


    public List<Material> generateCarport(int length, int width, CalculateNumbers calc, List<Material> materials) {


        double distanceMeasure = calc.getDistanceMeasure();
        int screwKvm = calc.getScrewKvm();
        int postPerLength = calc.getPostPerLength();
        int screwPackageNumbers = calc.getScrewPackageNumbers();
        int minPosts = calc.getMinimumPosts();
        int maxPosts = calc.getMaximumPosts();


        double amountCalc = ((double) length / 100.0) / distanceMeasure;
        double amountScrews = (double) length / 100.0 * (double) width / 100.0 * (double) screwKvm / (double) screwPackageNumbers;
        double widthCalculator = (double) width / 100.0;


        for (Material m : materials) {
            if (m.getMaterial_id() == 5) {
                m.setLength(length);
            }

            if (m.getMaterial_id() == 6) {
                m.setLength(width);
                m.setAmount((int) Math.ceil(amountCalc));
            }

            if (m.getMaterial_id() == 7) {
                if (length < postPerLength) {
                    m.setAmount(minPosts);
                } else {
                    m.setAmount(maxPosts);
                }
            }

            if (m.getMaterial_id() == 10) {
                m.setAmount((int) Math.ceil(widthCalculator));
            }

            if (m.getMaterial_id() == 11) {
                m.setAmount((int) Math.ceil(amountScrews));
            }

            if (m.getMaterial_id() == 13 || m.getMaterial_id() == 14) {
                m.setAmount((int) Math.ceil(amountCalc));
            }
        }

        return materials;

    }



    public BomFacade(Database database) {
        this.bomMapper = new BomMapper(database);
        this.bomCalculateMapper = new BomCalculateMapper(database);
    }

    public List<Material> getOrderLineMaterials(int order_id) {
        return bomMapper.getOrderLineMaterials(order_id);
    }

    public List<Orderline> getOrderlines(int order_id) {
        return bomMapper.getOrderlines(order_id);
    }

    public void generateCarport(int order_id, int length, int width) {

        CalculateNumbers calculateNumbers = bomCalculateMapper.getCalculateNumbers();
        List<Material> materialList = bomMapper.getMaterials();
        List<Material> resultMaterials = generateCarport(length, width, calculateNumbers, materialList);
        bomMapper.insertCustomCartport(order_id, resultMaterials);
    }


}
