package org.mps.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    @BeforeEach
    void setup(){ person = new Person("Alba",19,"Female");
    }
    @AfterEach
    void shutdown(){
        person = null;
    }

    @Test
    void validAverageAgePerGender(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Pedro", 20,"Male"));
        persons.add(new Person("Marta", 40,"Female"));
        persons.add(new Person("Javier", 60,"Male"));
        persons.add(new Person("Lucía", 30,"Female"));
        assertEquals(person.averageAgePerGender(persons)[0],40);
        assertEquals(person.averageAgePerGender(persons)[1],35);
    }
}