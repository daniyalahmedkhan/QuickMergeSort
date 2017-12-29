package com.example.kashif.qmsort;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QSActivity extends AppCompatActivity {

    int arr[] , n;
    int counter = 0;
    ListView sortd;
    Button NEXXT;
    ArrayList arrayList;
    int glob = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qs);

        sortd = (ListView) findViewById(R.id.sortd);
        NEXXT = (Button) findViewById(R.id.NEXXT);

        arrayList = new ArrayList();
        n  = Random_Numbers.loop;
        arr = new int[Random_Numbers.loop];
        for (int i = 0; i < Random_Numbers.loop; i++) {


            arr[i] = Random_Numbers.arr[i];

        }


        NEXXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                glob = 1;
                sort(arr , 0 , n-1);

            }
        });





    }


    int partition(int arr[], int low, int high) {
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

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        printArray(arr);


       glob = 0;

            return i + 1;



    }


    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */

            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);


            counter++;
        }

    }

     void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i < n; ++i) {
            //
//             System.out.print(arr[i]+" ");
//            System.out.println();

            arrayList.add(arr[i]);

           // Toast.makeText(QSActivity.this, " " + arr[i], Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(QSActivity.this,
                android.R.layout.simple_list_item_1, arrayList);

        sortd.setAdapter(adapter);


        // Toast.makeText(QSActivity.this , "Key Comparison" + counter , Toast.LENGTH_SHORT).show();

    }


}
