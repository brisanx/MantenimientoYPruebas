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
 * 1. Age is not valid, as it can't be negative, otherwise it throws RuntimeException
 * 2. Gender must be Male or Female, otherwise it throws RuntimeException
 * 3. All getters should return its respective value
 * 4. Valid case for the method averageAgePerGender,
 *    for some specific valid people it returns correctly the average age per gender
 */
class PersonTest {
    Person person;
    @BeforeEach
    void setup(){
        person = new Person("Alba",19,"Female");
    }
    @AfterEach
    void shutdown(){
        person = null;
    }

    @Test
    void notValidGenderShouldThrowRunTimeException(){
        assertThrows(RuntimeException.class, ()->new Person("Alba", 19, "Patata"));
    }
   @Test
    void notValidAgeShouldThrowRunTimeException(){
        assertThrows(RuntimeException.class, ()->new Person("Alba", -2, "Female"));
    }
    @Test
    void validGetterForAgeReturnAge(){
        assertEquals(person.age(),19);
    }
    @Test
    void validGetterForNameReturnName(){
        assertEquals(person.name(), "Alba");
    }
    @Test
    void validGetterForGenderReturnGender(){
        assertEquals(person.gender(),"Female");
    }
    @Test
    void validAverageAgePerGender(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Pedro", 20,"Male"));
        persons.add(new Person("Marta", 40,"Female"));
        persons.add(new Person("Javier", 60,"Male"));
        persons.add(new Person("Lucia", 30,"Female"));
        assertEquals(person.averageAgePerGender(persons)[0],40);
        assertEquals(person.averageAgePerGender(persons)[1],35);
    }
}