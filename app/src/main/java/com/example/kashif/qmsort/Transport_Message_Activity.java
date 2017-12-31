package com.example.kashif.qmsort;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Transport_Message_Activity extends AppCompatActivity {

    ImageView imageView;
    TextView CheckEff;
    public ViewPager viewPager;
    public TabLayout tabLayout;
    public ArrayList<Fragment> arrayList;
    public QS_SORT qsSort;
    public MS_SORT ms_sort;
    public  QSActivity qsActivity;



    public Patient_LoginPager patientLoginPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_);
        CheckEff = (TextView) findViewById(R.id.CheckEff);

        CheckEff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Transport_Message_Activity.this , CheckEff.class);
                startActivity(intent);
//                Toast.makeText(Transport_Message_Activity.this , "Quick Eff: " + QS_SORT.counter , Toast.LENGTH_SHORT ).show();
//                Toast.makeText(Transport_Message_Activity.this , "Merge Eff: " + MS_SORT.counter , Toast.LENGTH_SHORT ).show();

            }
        });


                initView();


    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        arrayList = new ArrayList<>();
        qsSort = new QS_SORT();
        ms_sort = new MS_SORT();
        qsActivity = new QSActivity();

        arrayList.add(qsSort);
        arrayList.add(ms_sort);

        tabLayout.addTab(tabLayout.newTab().setText("Quick Sort"));
        tabLayout.addTab(tabLayout.newTab().setText("Merge Sort"));

        patientLoginPager = new Patient_LoginPager(Transport_Message_Activity.this.getSupportFragmentManager(), arrayList);
        //is line se tablayout k neche jo shade araaha hai woh change hoga pageviewer k mutabik
        viewPager.setAdapter(patientLoginPager);
        viewPager.setOffscreenPageLimit(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

}
