package com.example.mom.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        float bmi = intent.getFloatExtra("BMI_Extra" , 0); //intent.getXXExtra(資料標籤,若沒收到資料時的預設值)
        //從這改TextView R.id.Result 的內容
        TextView result = (TextView) findViewById(R.id.Result);
        result.setText("您的BMI值為："+bmi);

        // Bundle 方法1
        Bundle bag = intent.getExtras();
        float bmi_b = bag.getFloat("BMI_Extra_Bundle",0);
        String test_b = bag.getString("Test_Extra_Bundle",null);

        // Bundle 方法2
        //float bmi_b = intent.getExtras().getFloat("BMI_Extra_Bundle",0 );
        //String test_b = intent.getExtras().getString("Test_Extra_Bundle",null);
        //從這改TextView R.id.Result_bundle 的內容
        TextView result_b = (TextView) findViewById(R.id.Result_bundle);
        result_b.setText(test_b+"您的BMI值為："+bmi_b);

    }
}
