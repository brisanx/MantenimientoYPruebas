package org.mps.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alba Sánchez Ibáñez
 *
 * Test cases:
 * 1. Age is not valid, as it can't be negative, otherwise it throws NegativeAgeException
 * 2. Gender must be Male or Female, otherwise it throws WrongGenderException
 * 3. All getters should return its respective value (These are: name, age and gender)
 * 4. Valid case for the method averageAgePerGender,
 *    for some specific valid people it returns correctly the average age per gender
 *   5. Empty list will return an EmptyListException
 *   6. Given a list with only men, the mean age for women will be 0, same thing happens with only women
 */
class PersonTest {
    Person person;
    Person person2;
    List<Person> persons;

    @BeforeEach
    void setup() throws NegativeAgeException, WrongGenderException {
        persons = new ArrayList<>();
        person = new Person("Alba",19,"Female");
        person2 = new Person("Juan", 42, "Male");
    }
    @AfterEach
    void shutdown(){
        person = null;
        person2 = null;
        persons = null;
    }

    @Test
    void notValidGenderShouldThrowWrongGenderException(){
        assertThrows(WrongGenderException.class, ()->new Person("Alba", 19, "Patata"));
    }
   @Test
    void notValidAgeShouldThrowNegativeAgeException(){
        assertThrows(NegativeAgeException.class, ()->new Person("Alba", -2, "Female"));
    }
    @Test
    void validGetterForAgeReturnAge(){
        int actualAge = person.age();
        int expectedAge = 19;
        assertEquals(expectedAge,actualAge);
    }
    @Test
    void validGetterForNameReturnName(){
        String actualName = person.name();
        String expectedName = "Alba";
        assertEquals(expectedName,actualName);
    }
    @Test
    void validGetterForGenderReturnGender(){
        String actualGenderFemale = person.gender().toLowerCase();
        String expectedGenderFemale = "female";
        assertEquals(actualGenderFemale,expectedGenderFemale);
    }

    @Test
    void validAverageAgePerGender() throws NegativeAgeException, WrongGenderException, EmptyListException {
        persons.add(new Person("Pedro", 20,"Male"));
        persons.add(new Person("Marta", 40,"female"));
        persons.add(new Person("Javier", 60,"male"));
        persons.add(new Person("Lucia", 30,"Female"));

        double[] expectedValues = {40,35};
        double[] actualValues = person.averageAgePerGender(persons);

        assertEquals(expectedValues[0],actualValues[0]);
        assertEquals(expectedValues[1],actualValues[1]);
    }
    @Test
    void zeroFemaleInTheListShouldReturn() throws NegativeAgeException, WrongGenderException, EmptyListException {
        persons.add(new Person("Pedro", 20,"Male"));
        persons.add(new Person("Javier", 60,"male"));
        assertEquals(person.averageAgePerGender(persons)[1],0.0);
    }
    @Test
    void zeroMaleInTheListShouldReturn() throws NegativeAgeException, WrongGenderException, EmptyListException {
        persons.add(new Person("Pedra", 20,"Female"));
        persons.add(new Person("Javiera", 60,"female"));
        assertEquals(person.averageAgePerGender(persons)[0],0.0);
    }
    @Test
    void emptyListReturnsEmptyError() {
        assertThrows(EmptyListException.class, ()->person.averageAgePerGender(persons));
    }

}