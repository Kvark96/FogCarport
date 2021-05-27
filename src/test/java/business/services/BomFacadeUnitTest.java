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
    void whenGenerateCarportWithDifferentInputThenMaterialIdOneShouldBeTheSame() {
        List<Material> testlist = new ArrayList<>();
        testlist.add(new Material(1, "", 360, 4, "", ""));
        List<Material> resultList = bomFacade.generateCarport(240, 240, calculateNumbers, testlist);


        int material1Lenght = resultList.get(0).getLength();
        resultList = bomFacade.generateCarport(270, 270, calculateNumbers, testlist);

        assertEquals(material1Lenght, resultList.get(0).getLength());
    }

    @Test
    void whenGenerateCarportWithDifferentInputThenMaterialIdFiveShouldNotBeTheSame() {
        List<Material> testlist = new ArrayList<>();
        testlist.add(new Material(5, "", 0, 2, "", ""));
        List<Material> resultList = bomFacade.generateCarport(240, 240, calculateNumbers, testlist);


        int material1Lenght = resultList.get(0).getLength();
        resultList = bomFacade.generateCarport(270, 270, calculateNumbers, testlist);

        assertNotEquals(material1Lenght, resultList.get(0).getLength());
    }

    @Test
    void generateCarportListTest() {
        List<Material> resultList = bomFacade.generateCarport(240, 240, calculateNumbers, materialList);
      assertEquals(materialList.size(), resultList.size());

    }
}