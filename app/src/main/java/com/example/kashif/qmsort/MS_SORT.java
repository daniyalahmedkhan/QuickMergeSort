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

public class MS_SORT extends android.support.v4.app.Fragment {

    int arr[];
    ArrayList arrayList;
    ListView listView;
    public static Boolean endPress = false;
    public static int counter = 0;

    Button Next, END;
    public static int glob = 0;

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

        View view = inflater.inflate(R.layout.mslayout , null);

        Next = (Button)view.findViewById(R.id.NEXXT);
        END = (Button)view.findViewById(R.id.END);
        listView = (ListView)view.findViewById(R.id.sortd);
        arrayList = new ArrayList();


        Thread t = new Thread(new sort2(arr,0,arr.length - 1));
        t.start();
       // printArray(arr);


        END.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endPress = true;
                printArray(arr);


            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endPress = false;
                printArray(arr);
                glob = 1;
            }
        });


        return view;
    }

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        while (MS_SORT.glob == 0){


        }
    }


    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }


     void printArray(int arr[])
    {
        int n = arr.length;

        arrayList.clear();
        for (int i=0; i<n; ++i){


            arrayList.add(arr[i]);

        }

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(adapter);

//            System.out.print(arr[i] + " ");
//        System.out.println();

//        Toast.makeText(getActivity() , " counter " + counter , Toast.LENGTH_SHORT).show();
   }

}
