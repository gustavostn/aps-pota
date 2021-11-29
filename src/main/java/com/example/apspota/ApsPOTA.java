package com.example.apspota;

import com.example.apspota.algorithms.algorithms;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class ApsPOTA extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        generateVector generator = new generateVector();
        int[] array = generator.generate(50);

        algorithms.bubbleSort(array);

        algorithms.quickSort(array, 0, array.length - 1); //Passando params para a primeira chamada
        System.out.println("Comparações realizadas usando o Quick Sort: " + algorithms.countToQuickSort);

        algorithms.selectionSort(array);

        algorithms.heapSort(array);
        System.out.println("Comparações realizadas usando o Heap Sort: " + algorithms.countToHeapSort);

        algorithms.mergeSort(array, 0, array.length); //Passando os parametros para a primeira chamada.
        System.out.println("Comparações realizadas usando o Merge Sort: " + algorithms.countToMergeSort);

        algorithms.insertionSort(array);

//        Count Sort,
//        Bucket Sort
//        Radix Sort

    }

    public static void main(String[] args) {
        launch();
    }
}