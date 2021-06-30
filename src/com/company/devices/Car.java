package com.company.devices;

import com.company.Transactions;
import com.company.animals.Human;
import java.util.ArrayList;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;
    public Double price=0.0;
    public int saleAmtID;

    public void setPrice(Double price){
        this.price=price;
    }
    public Double getPrice(){
        return price;
    }


    //list of transactions
    public ArrayList<Transactions> Transies = new ArrayList<Transactions>();
    
    //List of human owners
    public ArrayList<Human> listOfOwners = new ArrayList<Human>();

    public void setListOfOwners(Human human){
        human = this.Human;
        listOfOwners.add(human);
    }

    public ArrayList<Human> getListOfOwners(){
        return listOfOwners;
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price, int ParkingSpot) throws Exception {
        //Sell modification to add to transaction
        Transactions Trans = new Transactions();
        Trans.setTransaction(seller,buyer,price);
        Transies.add(Trans);
        



        //Check if seller has car in garage
        boolean ForTheCheckTest = false;
        int IsCarHere=seller.getGarage().length;
        String[] tempGar = seller.getGarage();
        for(int i; i<IsCarHere; i++){
            if(tempGar[i]==seller.getCar(ParkingSpot)){
                System.out.println("The car is in the garage");
                ForTheCheckTest = True;
                break;
            }
        }
         if (ForTheCheckTest==false){
            throw new Exception("The Seller doesn't have car in Garage.");
        }


        //check if buyer has available spots in the garage
        String[] TempBuyerGarage= buyer.getGarage();
        int IsThereSpace=TempBuyerGarage.length;
        boolean wheresTheSpace = false;
        int spaceCounter;
        for(int n; n<IsThereSpace; n++){
            spaceCounter++;
            if(TempBuyerGarage[n]==null){
                System.out.println("There is space in the garage in spot no: " + wheresTheSpace);
                wheresTheSpace=true;
                break;
            }
        }
        if(wheresTheSpace==false){
            System.out.println("There's no space in the Garage");
            setGarageSize(buyer.getGarage().length+1, buyer.getGarage());
        }



        //Check if buyer has enough cash
        //removal of car from seller's garage
        //addition to buyer's garage
        boolean carSold;
        if(seller.getCar(ParkingSpot) == this) {
            
            if (buyer.cash >= seller.getCar(ParkingSpot).getPrice()) {
                buyer.cash -= seller.getCar(ParkingSpot).getPrice();
                seller.cash += seller.getCar(ParkingSpot).getPrice();
                buyer.setCar(this, spaceCounter);
                seller.setCar(null, ParkingSpot);
                //add buyer to list of human owners
                listOfOwners.add(buyer);
                System.out.println("Car has been sold");
                carSold= true;
            }
            else {
                throw new Exception("Buyer does not have enough money");
            }
            } else {
                throw new Exception("Seller does not own the car to begin with");
            }
            //check if seller is the last owner of the car
            if(carSold==true){
                if(seller==listOfOwners.get(listOfOwners.size()-1)){
                    System.out.println("The seller is still the last owner of the car");
                }
                else{
                    System.out.println("The seller sold the car to the buyer");
                }
            }         
    }
    //check if someone owned the car before
    public void ownerCheck(Human human){
        for(int cs=0; cs<listOfOwners.size();cs++){
            if(listOfOwners.get(cs)==human){
                System.out.println("This person has owned this car before");
            }
        }
    }
    
    //Check if human A sold Car to human B
    public void sellCheck(Human seller, Human buyer){
        int sgsize=seller.Garage.length;
        int bgsize=buyer.Garage.length;
        boolean sgbool = false;
        boolean bgbool = false;
        for (int sg=0; sg<sgsize;sg++){
            if(seller.Garage[sg]==this){
                sgbool=true;
            }
        }
        for (int bg=0; sg<bgsize;sg++){
            if(buyer.Garage[bg]==this){
                bgbool=true;
            }
        }
        if(sgbool || !bgbool){
            System.out.println("The car was not sold");
        }
    }

    //method for number of times car was sold
    public int getSaleAmtID(){
        return listOfOwners.size();
    }
    

    public void refuel() {
        currentFuel = MAX_FUEL;
    }

    
}
