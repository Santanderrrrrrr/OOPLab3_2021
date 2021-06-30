package com.company;
import com.company.devices.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Transactions{
    
    Human seller;
    Human buyer;
    Double price;
    String date;

    public String DateTime(){
        LocalDateTime DateObj = LocalDateTime.now();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = DateObj.format(FormatObj);
        return formattedDate;
    }

    public setTransaction(Human seller, Human buyer, Double price){
        this.seller=seller;
        this.buyer=buyer;
        this.price=price;
        this.date= DateTime();
    }

}