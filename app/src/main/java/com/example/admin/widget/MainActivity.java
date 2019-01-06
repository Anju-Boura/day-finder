package com.example.admin.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        EditText date,year;
        TextView txt;
        String monthname;
    String  yearvalue,datevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date =(EditText) findViewById(R.id.date);
        year =(EditText) findViewById(R.id.year);
        txt=(TextView) findViewById(R.id.result);


        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.month_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        monthname=parent.getItemAtPosition(position).toString();




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public  void findDay(View v){
        int centurycode=0;
        int daycode=0;


        datevalue= date.getText().toString();
        yearvalue=year.getText().toString();

        Map<String,Integer> m1=new HashMap<String,Integer>();
        m1.put("JANUARY",1);
        m1.put("FEBRUARY",4);
        m1.put("MARCH",4);
        m1.put("APRIL",0);
        m1.put("MAY",2);
        m1.put("JUNE",5);
        m1.put("JULY",0);
        m1.put("AUGUST",3);
        m1.put("SEPTEMBER",6);
        m1.put("OCTOBER",1);
        m1.put("NOVEMBER",4);
        m1.put("DECEMBER",6);
        Map<Integer,String> m2=new HashMap<Integer,String>();
        m2.put(0,"SUNDAY");
        m2.put(1,"MONDAY");
        m2.put(2,"TUESDAY");
        m2.put(3,"WEDNESDAY");
        m2.put(4,"THURSDAY");
        m2.put(5,"FRIDAY");
        m2.put(6,"SATURDAY");

        int date2=Integer.parseInt(datevalue);


        int year2=Integer.parseInt(yearvalue);
        if(year2>=2000) {
            centurycode=5;
        }
        else if(year2>=1900) {
            centurycode=6;
        }
        else if(year2>=1800) {
            centurycode=1;
        }
        else if(year2>=1700){
            centurycode=3;
        }
        else{
            Toast.makeText(getBaseContext(),"year value is not valid",Toast.LENGTH_SHORT).show();

        }
        int tdy=Integer.parseInt(yearvalue.substring(year.length()-2));
        if(tdy%4==0 &&(monthname.equals("JANUARY")||monthname.equals("FEBRUARY"))) {
            daycode=(centurycode+tdy+(tdy/4)+(m1.get(monthname)-1)+date2)%7;
        }
        else {

            daycode=(centurycode+tdy+(tdy/4)+(m1.get(monthname))+date2)%7;

        }
        String day=m2.get(daycode);
        txt.setText(day);
        System.out.println("day");







    }
}
