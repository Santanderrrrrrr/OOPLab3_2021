package com.company.animals;

import java.util.Comparator;

public class AnimalWeightComparator implements Comparator<Animal> {
    @Override
    /*
        Compares its two arguments for order.
        Returns a:
        negative integer - first argument is less than second,
        zero - both arguments are equal ,
        positive integer - first argument is greater than the second.
    */
    public int compare(Animal o1, Animal o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else if (o1.getWeight() == o2.getWeight()) {
            return 0;
        } else if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
