package com.mobdev.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addAll, viewAll;
    EditText customerName, customerAge;
    Switch customerSwitch;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAll = (Button)findViewById(R.id.addAll);
        viewAll = (Button)findViewById(R.id.viewAll);
        customerName = (EditText) findViewById(R.id.customName);
        customerAge = (EditText) findViewById(R.id.customerAge);
        customerSwitch = findViewById(R.id.customerSwitch);
        lv_customerList= findViewById(R.id.lv_customerList);

        addAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                try{
                    customerModel= new CustomerModel(-1, customerName.getText().toString(),Integer.parseInt(customerAge.getText().toString()),customerSwitch.isActivated());
                    //Toast.makeText(MainActivity.this,customerModel.toString(), Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,"Error creating customer", Toast.LENGTH_LONG).show();
                    customerModel = new CustomerModel(-1,"error",0,false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean sucess = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "SUCCESS" + sucess, Toast.LENGTH_SHORT).show();
            }
        });
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}