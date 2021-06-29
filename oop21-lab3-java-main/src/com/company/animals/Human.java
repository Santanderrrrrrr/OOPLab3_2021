package com.company.animals;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    List<Animal> pets;
    public Phone phone;
    
    

    Car[] Garage = new Car[10];
    public void setGarageSize(int CarNum, Car[] Garage) {

        Garage = Arrays.copyOf(Garage, CarNum);
        // int i;
        // String[] TempGarage = new String[CarNum];
        // int length = Garage.length;
        // for(i=0; i<length; i++){
        //     TempGarage[i]=Garage[i];
        // }
        // Garage=TempGarage;
    }

    public Car[] getGarage(){
        return Garage;
    }
    public Car getCar(int ParkingSpot) {
        return Garage[ParkingSpot];
    }

    public void setCar(Car car, int ParkingSpotForPlacement) {
        this.Garage[ParkingSpotForPlacement]=car;
    }

    public void carsValue(){
        double totalValue = 0;
        for(int i=0;i< this.Garage.length;i++){
            totalValue =+this.Garage[i].getPrice();
            
        }
        
    }

    public ArrayList<Car> ListOfCarsByAge(){

        ArrayList<Car> ListOfCarsByAge = new ArrayList<String>();
        for(int i=0;i< Garage.length-1;i++){
            for(int j=0;j< Garage.length-i-1;j++){
                if(Garage[j].getYearOfProduction()>Garage[j+1].getYearOfProduction()){
                    Car tmp = Garage[j];
                    Garage[j]=Garage[j+1];
                    Garage[j+1] = tmp;
                }
            }
        }
        for (int k=0;k<Garage.length;k++){
            ListOfCarsByAge.add(Garage[k]);
        }
        return ListOfCarsByAge;
        System.out.println(ListOfCarsByAge);

    }

    public Double cash;
    public String[] fingerNames;

    public final int FINGER_COUNT = 10;
    public final static String HUMAN_SPECIE = "homo sapiens";

    private Double salary;

    public Human(Double salary) {
        super(HUMAN_SPECIE);
        this.setSalary(salary);
        fingerNames = new String[FINGER_COUNT];
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        } else {
            System.out.println("NOBODY WILL PAY FOR WORKING");
            this.salary = 0.0;
        }
    }

    public void addPet(Animal pet) {
        if(pets == null) {
            pets = new ArrayList<Animal>();
        }
        pets.add(pet);
    }

    public List<Animal> getPets() {
        return pets;
    }

}
