package com.example.kashif.qmsort;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kashif on 12/27/2017.
 */

public class Random_Numbers extends android.support.v4.app.Fragment {

    EditText editFrom , editTo , editRange;
    Button btnGenerate, btnSort;
    ListView listView;
    ArrayList arrayList;
  public static   int arr[];
public static int loop;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.randon_numbers , null);
        editFrom = (EditText)view.findViewById(R.id.fromRandom);
        editTo = (EditText)view.findViewById(R.id.ToRandom);
        editRange = (EditText)view.findViewById(R.id.howMany);
        arrayList = new ArrayList();
        btnSort  = (Button)view.findViewById(R.id.Sort);
        btnGenerate = (Button)view.findViewById(R.id.BtnGenerate);
        listView  = (ListView)view.findViewById(R.id.ListofRandom);



        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int max = Integer.parseInt(editTo.getText().toString());
                int min = Integer.parseInt(editFrom.getText().toString());
                 loop = Integer.parseInt(editRange.getText().toString());

                arr = new int[loop];

                for (int i = 0; i<loop; i++){


                    Random r = new Random();
                    int Low =  min;
                    int High =  max;
                    int Result = r.nextInt(High-Low) + Low;



                    arr[i] = Result;

                    arrayList.add(arr[i]);
                    ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_list_item_1, arrayList);

//
//
                    listView.setAdapter(adapter);
//


                }

            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getActivity() , QSActivity.class);
//                startActivity(intent);


             getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content , new MS_SORT()).commit();

            }
        });



        return view;

    }
}
