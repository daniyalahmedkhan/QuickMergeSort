package com.example.kashif.qmsort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kashif on 12/29/2017.
 */

public class QS_SORT extends android.support.v4.app.Fragment {

    int arr[];
    Button NEXXT, END;
    public static Boolean endPress = false;
    public static int glob = 0;
    ListView sortd;
    ArrayList arrayList;
    public static int counter =  0;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        arr = new int[Random_Numbers.loop];


        for (int i =0; i<Random_Numbers.loop; i++){


            arr[i] = Random_Numbers.arr[i];

        }



        View view = inflater.inflate(R.layout.qslayout , null);
        NEXXT = (Button)view.findViewById(R.id.NEXXT);
        END = (Button)view.findViewById(R.id.END);
        sortd = (ListView)view.findViewById(R.id.sortd);

        arrayList = new ArrayList();


        Thread t = new Thread(new sort(arr,0,arr.length - 1));
        t.start();


        END.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                endPress = true;
                printArray(arr);
            }
        });

        NEXXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endPress=false;
                printArray(arr);
                glob = 1;
//                counter++;
//                sort(arr, 0, n - 1);

            }
        });



        return view;

    }


    public int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

//    Thread t = new Thread(sort(arr,0,1));
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


     void printArray(int arr[])
    {
        int n = arr.length;

        arrayList.clear();

        for (int i=0; i<n; ++i){



            arrayList.add(arr[i]);


        }

//        if (sort.low < sort.high){
//
//            Toast.makeText(getActivity() , "counter" + counter , Toast.LENGTH_SHORT).show();
//
//
//
//        }

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, arrayList);

        sortd.setAdapter(adapter);
    }



}


