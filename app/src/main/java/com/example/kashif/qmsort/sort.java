package com.example.kashif.qmsort;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Kashif on 12/29/2017.
 */

public class sort implements Runnable {

    int arr[];
    int low;
    int high;

    public sort(int arr[], int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void run() {
        //do work
        DoSort(arr,low,high);
    }

    public void DoSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            QSActivity.glob=0;
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            DoSort(arr, low, pi-1);
            DoSort(arr, pi+1, high);
        }
    }

    public int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        while (( QSActivity.glob==0) && (QSActivity.endPress==false))
        {
        }
        return i+1;
    }
}
