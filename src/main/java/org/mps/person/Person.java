package org.mps.person;
import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Alba Sanchez Ibanez
 */
public class Person {
        private final String name;
        private final int age;
        private final String gender; // Male, Female

        /**
         * Constructs a person with a name, age and gender. Age can't be negative. Gender must be Male or Female.
         *
         * @param name   the name of the person
         * @param age    the age of the person
         * @param gender the gender of the person
         */
    public Person(String name, int age, String gender){
        this.name = name;
        if(age<0) throw new RuntimeException("Age can't be negative");
        else this.age = age;
        if(gender != "Male" && gender != "Female") throw new RuntimeException("Gender should be Male or Female");
        else this.gender = gender;
    }

    public String name(){return name;}

    public int age() {return age;}

    public String gender(){
        return gender ;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in an array of two elements
     * (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons){
        double[] medias = new double[2];
        int contMale = 0;
        int contFemale = 0;
        for (Person p : persons) {
            if(p.gender().compareTo("Male")==0){
                medias[0] += p.age();
                contMale++;
            } else {
                medias[1] += p.age();
                contFemale++;
            }
        }
        medias[0] = medias[0]/contMale;
        medias[1] = medias[1]/contFemale;
        return medias;
    }
}