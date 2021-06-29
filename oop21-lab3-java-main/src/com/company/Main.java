package com.company;

import com.company.animals.*;
import com.company.devices.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //implementation in main
        //create new human
        Human Gianluca = new Human();

        //give human car
        Car Ferrari = new Car();
        Car Lamb = new Car();
        Gianluca.setCar(Ferrari, 0);
        Gianluca.setCar(Lamb,1);
        Gianluca.Ferrari.price=200000;
        Gianluca.Lamb.price=180000;

        //print the value of his garage
        Gianluca.carsValue();
        
        //List of cars by age printed out
        Gianluca.ListOfCarsByAge();

        //sell cars
        Ferrari.sell(Gianluca, me, Ferrari.price,0);
        Lamb.sell(Gianluca, me, Lamb.price,1);



        Human me = new Human(1000000.0);
        me.firstName = "Jan";
        me.lastName = "Kowalski";

        Animal dog = new Animal("dog");
        dog.name = "Szarik";
        Animal cat = new Animal("cat");
        cat.name = "Puszek";

        me.addPet(dog);
        me.addPet(cat);
        List<Animal> pets = me.getPets();
        for (Animal pet: pets) {
            System.out.println(pet.name);
        }

        for(int i=0;i<pets.size();i++) {
            System.out.println(String.format("Pet number %d is named %s and weights %.2f", i, pets.get(i).name, pets.get(i).getWeight()));
        }

        List<Animal> sortedAnimalsFirstApproach = pets.stream().sorted(Comparator.comparing(Animal::getWeight)).toList();
        for (Animal pet: sortedAnimalsFirstApproach) {
            System.out.println(String.format("Pet named %s weights %.2f", pet.name, pet.getWeight()));
        }
        List<Animal> sortedAnimalsSecondApproach = pets.stream().sorted(new AnimalWeightComparator()).toList();
        for (Animal pet: sortedAnimalsSecondApproach) {
            System.out.println(String.format("Pet named %s weights %.2f", pet.name, pet.getWeight()));
        }

        me.fingerNames[0] = "Left pinkie";
        me.fingerNames[1] = "Left ring";
        me.fingerNames[2] = "Left middle";
        me.fingerNames[3] = "Left index";
        me.fingerNames[4] = "Left thumb";

        me.fingerNames[5] = "Right thumb";
        me.fingerNames[6] = "Right index";
        me.fingerNames[7] = "Right middle";
        me.fingerNames[8] = "Right ring";
        me.fingerNames[9] = "Right pinkie";

        System.out.println(String.format("I have %d fingers", me.fingerNames.length));

        for (String fingerName: me.fingerNames) {
            System.out.println(fingerName);
        }

        List<String> sortedFingerNames = Arrays.stream(me.fingerNames).sorted().toList();

        for (String fingerName: sortedFingerNames) {
            System.out.println(fingerName);
        }




        Phone onePlus = new Phone("onePlus",
                "8Pro",
                2.3,
                "Android");

        Phone iPhone6 = new Phone("Apple", "6s", 5.0, "iOS");

        System.out.println("phone: " + onePlus);
        System.out.println("phone: " + iPhone6);
        System.out.println("human: " + me);


        onePlus.turnOn();

        Car fiat = new Car();
        fiat.engineSize = 1.9;
        fiat.fuelType = "Diesel";
        fiat.setProducer("Fiat");
        fiat.setModel("Bravo");

        System.out.println(iPhone6.getModel());
        System.out.println(iPhone6.getProducer());
        System.out.println(iPhone6.os);
        System.out.println(iPhone6.screenSize);


        fiat.turnOn();
        iPhone6.turnOn();
    }
}
