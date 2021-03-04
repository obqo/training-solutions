package covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CovidMainTest {
    CovidDao covidDao = new CovidDao();

    @BeforeEach
    public void init() {
        covidDao.initFlyway();
    }

    //1. Regisztráció
    @Test
    public void insertPersonTest() {
        Person person = new Person("abc", "8130", 35, "a@a", "121251408");
        covidDao.insertRegisteredCitizens(List.of(person));
        assertEquals(1,covidDao.selectAllCitizens().size());
    }

    //2. Tömeges regisztráció
    @Test
    public void insertPeopleTest() {
        covidDao.insertRegisteredCitizens(covidDao.getRegisteredPersonsFromFile("src/test/java/covid/registered_persons.csv"));
        assertEquals(1000,covidDao.selectAllCitizens().size());
    }

    //3. Generálás


    //4. Oltás


    //5. Oltás meghiúsulás


    //6. Riport


}
