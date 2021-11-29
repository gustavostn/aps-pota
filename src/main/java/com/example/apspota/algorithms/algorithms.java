package com.example.apspota.algorithms;

public class algorithms {

    //Variaveis globais para arm a qtd de comparações realizadas pelos algoritmos.
    public static int countToQuickSort = 0, countToHeapSort = 0, countToMergeSort = 0;


    public static int bubbleSort(int[] vector) {
//        System.out.println("vetor: " + vector);
        boolean verifyNextItem;
        int currentValue, totalComparisons = 0;

        for (int index = 0; index < vector.length; index++) {
            verifyNextItem = true;
            for (int subIndex = 0; subIndex < (vector.length - 1); subIndex++) {
                totalComparisons++;
                if (vector[subIndex] > vector[subIndex + 1]) {
                    verifyNextItem = false;
                    currentValue = vector[subIndex];
                    vector[subIndex] = vector[subIndex + 1];
                    vector[subIndex + 1] = currentValue;
                    //System.out.println("caiu no if: " + verifyNextItem + vector[subIndex + 1]);
                }
            }
            if (verifyNextItem) break;
        }
//        System.out.println("Comparações realizadas usando o Bubble Sort: " + totalComparisons);
        return totalComparisons;
    } // OK


    public static void quickSort(int[] vector, int initialIndex, int lastIndex) {

        if (initialIndex < lastIndex) {
            countToQuickSort++;// = (countToQuickSort + countToQuickSort);
            int keyPosition = getKeyPositionInVector(vector, initialIndex, lastIndex);
            quickSort(vector, initialIndex, (keyPosition - 1));
            quickSort(vector, (keyPosition + 1), lastIndex);
        }

    } // OK

    public static int getKeyPositionInVector(int[] vector, int initial, int last) {

        int key = vector[initial];
        int initialValue = (initial + 1);
        int lastValue = last;

        while (initialValue <= lastValue) {

            countToQuickSort = (countToQuickSort + 1);

            if (vector[initialValue] <= key) {
                countToQuickSort = (countToQuickSort + 1);
                initialValue = (initialValue + 1);
            }

            else if (key < vector[lastValue]) lastValue = (lastValue - 1);

            else {
                int value = vector[initialValue];
                vector[initialValue] = vector[lastValue];
                vector[lastValue] = value;
                initialValue = (initialValue + 1);
                lastValue = (initialValue - 1);

            }

        }

        vector[initial] = vector[lastValue];
        vector[lastValue] = key;
        return lastValue;
    } // OK


    public static void heapSort(int[] vector) {
        int lengthVector = vector.length;
        makeMaxHeap(vector);

        for (int index = (vector.length - 1); index > 0; index--) {
            swap(vector, index, 0);
            adjustHeap(vector, 0, --lengthVector); //lengthVector - 1);
        }
    } // OK

    public static void makeMaxHeap(int[] vector) {
        int calcIndex = ((vector.length / 2) - 1);
        for (int index = calcIndex; index >= 0; index--) adjustHeap(vector, index, vector.length);
    } // OK

    public static void adjustHeap(int[] vector, int index, int lengthVector) {

        int maxValue = ((2 * index) + 1);
        int nextItem = (maxValue + 1);

        countToHeapSort = (countToHeapSort + 1);
        if (lengthVector > maxValue) {
            countToHeapSort = (countToHeapSort + 1);

            if (nextItem < lengthVector && vector[maxValue] < vector[nextItem]) {
                maxValue = nextItem;
                countToHeapSort = (countToHeapSort + 1);
            }

            if (vector[maxValue] > vector[index]) {
                swap(vector, maxValue, index);
                adjustHeap(vector, maxValue, lengthVector);
            }
        }
    } // OK


    public static int selectionSort(int[] vetor) {
        int count = 0;

        for (int index = 0; index < vetor.length; index++) {
            int minValue = index;

            for (int subIndex = (index + 1); subIndex < vetor.length; subIndex++) {
                count = (count + 1);

                if (vetor[subIndex] < vetor[minValue]) minValue = subIndex;
            }
            swap(vetor, index, minValue);
        }
        return count;
//        System.out.println("Comparações realizadas usando o Selection Sort: " + count);

    } // OK


    public static void mergeSort(int[] vector, int firstIndex, int lengthVector) {
        countToMergeSort++;
        if (firstIndex < lengthVector) {
            int calcLengthVector = ((firstIndex + lengthVector) / 2);
            mergeSort(vector, firstIndex, calcLengthVector);
            mergeSort(vector, (calcLengthVector + 1), lengthVector);
            tradePosition(vector, firstIndex, calcLengthVector, lengthVector);
        }
    }

    public static void tradePosition(int[] lengthVector, int index, int mediumLengthVector, int totalLengthVector) {

        int vector[] = new int[lengthVector.length]; //Criar vetor

        for (int i = index; i <= mediumLengthVector; i++) vector[i] = lengthVector[i];
        for (int i = (mediumLengthVector + 1); i < totalLengthVector; i++) vector[mediumLengthVector - i + totalLengthVector] = lengthVector[i];

        int firstIndexVector = index;
        int calcIndexVector = (totalLengthVector - 1); //remover um valor para voltar ao valor padrao

        for (int i = index; i < totalLengthVector; i++) {
            countToMergeSort = (countToMergeSort + 1);

            //System.out.println("merge troca de posicao" + vector[firstIndexVector] + vector[calcIndexVector]);
            if (vector[firstIndexVector] <= vector[calcIndexVector]) {
                //System.out.println("Caiu no if" + vector[firstIndexVector] + vector[calcIndexVector]);
                lengthVector[i] = vector[firstIndexVector];
                firstIndexVector = (firstIndexVector + 1);
            } else {
                lengthVector[i] = vector[calcIndexVector];
                calcIndexVector = (calcIndexVector - 1);
            }
        }
    }


    public static int insertionSort(int[] vector) {
        int countTotalTrades = 0;
        int tempAmzValueVector = 0;
        int index = 0;

        for (int i = 0; i < (vector.length - 1); i++) {
            countTotalTrades = (countTotalTrades + 1);
            index = (i - 1);
            tempAmzValueVector = vector[i];
            //System.out.println("tempAmzValueVector" + tempAmzValueVector);

            while ( index > 0 && vector[index] > tempAmzValueVector) {
                //System.out.println("Tamanho index: " + index);
                vector[(index + 1)] = vector[index];
                index = (index - 1);
            }
            //System.out.println("Tamanho index: " + index);
            vector[index + 1] = tempAmzValueVector;
        }
        return countTotalTrades;
//        System.out.println("Comparações realizadas usando o Insertion Sort: " + countTotalTrades);
    } // OK

    //swap utilizado pelo professor para troca, usar este como o default.
    public static void swap(int[] vector, int index, int aposJ) {
        int armValue = vector[index];
        vector[index] = vector[aposJ];
        vector[aposJ] = armValue;
    }

}
