package com.example.apspota;

import com.example.apspota.algorithms.algorithms;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class ApsPOTA extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        generateVector generator = new generateVector();

        int acmBubble = 0, acmQuick = 0, acmSelection = 0, acmHeap = 0, acmMerge = 0, acmInsert = 0;
        int[] lengthVectores = {5, 10, 50, 100, 1000, 10000};

        for (int index = 0; index < lengthVectores.length; index++) {
            acmBubble = 0;
            acmQuick = 0;
            acmSelection = 0;
            acmHeap = 0;
            acmMerge = 0;
            acmInsert = 0;
            int[] vector = generator.generate(lengthVectores[index]);
            for (int repeat = 0; repeat < 50; repeat++) {

                acmBubble += algorithms.bubbleSort(vector);

                algorithms.quickSort(vector, 0, vector.length - 1); //Passando params para a primeira chamada
                acmQuick += algorithms.countToQuickSort;

                acmSelection += algorithms.selectionSort(vector);

                algorithms.heapSort(vector);
                acmHeap += algorithms.countToHeapSort;

                algorithms.mergeSort(vector, 0, vector.length); //Passando os parametros para a primeira chamada.
                acmMerge += algorithms.countToMergeSort;

                acmInsert += algorithms.insertionSort(vector);
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("Média da quantidade de comparações realizadas com o vetor de: " + lengthVectores[index] + " posições");
            System.out.println("Bubble: " + acmBubble / 50);
            System.out.println("Selection: " + acmSelection / 50);
            System.out.println("Quick: " + acmQuick / 50);
            System.out.println("Heap: " + acmHeap / 50);
            System.out.println("Merge: " + acmMerge / 50);
            System.out.println("Insert: " + acmInsert / 50);
            System.out.println("----------------------------------------------------------------------------------------------------");

        }


    }

    public static void main(String[] args) {
        launch();
    }
}