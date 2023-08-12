package com.example.programming_cw_sem2;

import java.util.Random;

public class RandomDealer {
    //Private variables
    private int randomNumber1;
    private int randomNumber2;
    private int randomNumber3;
    private int randomNumber4;

    //Getters
    public int getRandomNumber1() {
        return randomNumber1;
    }
    public int getRandomNumber2() {
        return randomNumber2;
    }
    public int getRandomNumber3() {
        return randomNumber3;
    }
    public int getRandomNumber4() {
        return randomNumber4;
    }

    //Random number generating method ( 0 - 5 range)
    public void selectRandomNumbers() {
        Random randomObj = new Random();
        randomNumber1 = randomObj.nextInt(6);
        do {
            randomNumber2 = randomObj.nextInt(6);
        } while (randomNumber1 == randomNumber2);
        do {
            randomNumber3 = randomObj.nextInt(6);
        } while (randomNumber3 == randomNumber1 || randomNumber3 == randomNumber2);
        do {
            randomNumber4 = randomObj.nextInt(6);
        } while (randomNumber4 == randomNumber1 || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3);
    }

}
