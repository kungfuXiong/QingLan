package com.xbl.designPattern._08_filterPattern;

import com.xbl.designPattern._08_filterPattern.filiter.*;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));


        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleFemale = new AndCriteria(single, female);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("Females: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("Singles: ");
        printPersons(single.meetCriteria(persons));

        System.out.println("Single Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("Single Females: ");
        printPersons(singleFemale.meetCriteria(persons));


        System.out.println("Single Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));



}
    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}

