package business.services;

import business.entities.CalculateNumbers;
import business.entities.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BomFacadeUnitTest {

    private static CalculateNumbers calculateNumbers;
    private static List<Material> materialList;
    private static BomFacade bomFacade;

    @BeforeEach
    void setUp() {
        bomFacade = new BomFacade(null);
        calculateNumbers = new CalculateNumbers(1, 0.55, 13, 401, 200, 4, 6);
        materialList = new ArrayList<>();
        materialList.add(new Material(1, "", 360, 4, "", ""));
        materialList.add(new Material(5, "", 0, 2, "", ""));
        materialList.add(new Material(6, "", 0, 0, "", ""));
        materialList.add(new Material(7, "", 300, 6, "", ""));
        materialList.add(new Material(10, "", 600, 0, "", ""));
        materialList.add(new Material(11, "", 0, 0, "", ""));
        materialList.add(new Material(12, "", 1000, 2, "", ""));
        materialList.add(new Material(13, "", 0, 0, "", ""));
        materialList.add(new Material(14, "", 0, 0, "", ""));
    }

    @Test
    void generateCarportTestWithMinMaterial() {
        List<Material> resultList = bomFacade.generateCarport(240, 240, calculateNumbers, materialList);
        Map<Integer, Material> map = new HashMap<>();
        resultList.forEach(material -> {
            map.put(material.getMaterial_id(), material);
        });

        Material test = map.get(1);
        assertEquals(360, test.getLength());
        assertEquals(4, test.getAmount());

        test = map.get(5);
        assertEquals(240, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(6);
        assertEquals(240, test.getLength());
        assertEquals(5, test.getAmount());

        test = map.get(7);
        assertEquals(300, test.getLength());
        assertEquals(4, test.getAmount());

        test = map.get(10);
        assertEquals(600, test.getLength());
        assertEquals(3, test.getAmount());

        test = map.get(11);
        assertEquals(0, test.getLength());
        assertEquals(1, test.getAmount());

        test = map.get(12);
        assertEquals(1000, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(13);
        assertEquals(0, test.getLength());
        assertEquals(5, test.getAmount());

        test = map.get(14);
        assertEquals(0, test.getLength());
        assertEquals(5, test.getAmount());
    }


    @Test
    void generateCarportTestWithMaxMaterial() {
        List<Material> resultList = bomFacade.generateCarport(780, 780, calculateNumbers, materialList);
        Map<Integer, Material> map = new HashMap<>();
        resultList.forEach(material -> {
            map.put(material.getMaterial_id(), material);
        });

        Material test = map.get(1);
        assertEquals(360, test.getLength());
        assertEquals(4, test.getAmount());

        test = map.get(5);
        assertEquals(780, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(6);
        assertEquals(780, test.getLength());
        assertEquals(15, test.getAmount());

        test = map.get(7);
        assertEquals(300, test.getLength());
        assertEquals(6, test.getAmount());

        test = map.get(10);
        assertEquals(600, test.getLength());
        assertEquals(8, test.getAmount());

        test = map.get(11);
        assertEquals(0, test.getLength());
        assertEquals(4, test.getAmount());

        test = map.get(12);
        assertEquals(1000, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(13);
        assertEquals(0, test.getLength());
        assertEquals(15, test.getAmount());

        test = map.get(14);
        assertEquals(0, test.getLength());
        assertEquals(15, test.getAmount());
    }

    @Test
    void generateCarportTestWithMaxMaterialExspectedToFail() {
        //Some of the lenght and amounts wont change with width and length therefore user og both assertEquals & assertNotEquals
        List<Material> resultList = bomFacade.generateCarport(240, 240, calculateNumbers, materialList);
        Map<Integer, Material> map = new HashMap<>();
        resultList.forEach(material -> {
            map.put(material.getMaterial_id(), material);
        });
        Material test = map.get(1);
        assertEquals(360, test.getLength());
        assertEquals(4, test.getAmount());

        test = map.get(5);
        assertNotEquals(780, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(6);
        assertNotEquals(780, test.getLength());
        assertNotEquals(15, test.getAmount());

        test = map.get(7);
        assertEquals(300, test.getLength());
        assertNotEquals(6, test.getAmount());

        test = map.get(10);
        assertEquals(600, test.getLength());
        assertNotEquals(8, test.getAmount());

        test = map.get(11);
        assertEquals(0, test.getLength());
        assertNotEquals(4, test.getAmount());

        test = map.get(12);
        assertEquals(1000, test.getLength());
        assertEquals(2, test.getAmount());

        test = map.get(13);
        assertEquals(0, test.getLength());
        assertNotEquals(15, test.getAmount());

        test = map.get(14);
        assertEquals(0, test.getLength());
        assertNotEquals(15, test.getAmount());

    }
}