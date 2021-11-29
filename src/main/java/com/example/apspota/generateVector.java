package com.example.apspota;


public class generateVector {

    public static int[] generate(int lengthVector) {
        int randomNumber;
        int[] array = new int[lengthVector];

        for (int index = 0; index < array.length; index++) {
            randomNumber = generateRandomNumbers();
            for (int subIndex = 0; subIndex < array.length; subIndex++) {
                if (randomNumber == array[subIndex] && subIndex != index) randomNumber = generateRandomNumbers();
                else array[index] = randomNumber;
            }
        }
        return array;
    }

    public static int generateRandomNumbers() {
        return (int) (Math.random() * (9999 + 1));
    }

}
