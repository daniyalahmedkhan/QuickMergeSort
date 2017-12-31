package com.example.kashif.qmsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckEff extends AppCompatActivity {


    TextView tQuick ,  tMerge , Better;
    int quick , merge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_eff);

        tQuick = (TextView) findViewById(R.id.QuickEFF);
        tMerge = (TextView) findViewById(R.id.MergeEff);
        Better = (TextView) findViewById(R.id.Better);
        quick = QS_SORT.counter;
        merge = MS_SORT.counter;


//        Toast.makeText(CheckEff.this, "Quick: " + quick, Toast.LENGTH_SHORT).show();
//        Toast.makeText(CheckEff.this, "Merge: " + merge, Toast.LENGTH_SHORT).show();


            tQuick.setText("" + quick );
        tMerge.setText(""+ merge);
//
//
// }
        if (quick < merge){

            Better.setText("" + "Quick");

        }else {


            Better.setText("" + "Merge");
        }
    }

}
