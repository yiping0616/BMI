package com.example.mom.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findValue(); //取得值

    }

    private void findValue() {
        //取得值
        edWeight = (EditText) findViewById(R.id.Weight);
        edHeight = (EditText) findViewById(R.id.Height);
    }

    //Button onClick
    public void BMI (View v){
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("BMI", String.valueOf(bmi)); // Logcat中顯示,除錯用
        //算完後的顯示,兩種簡單方法Toast , AlertDialog
        //Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show(); // Toast浮動顯示方法

        // AlertDialog用法
        /*new AlertDialog.Builder(this )
                .setMessage("BMI:"+bmi)
                .setTitle("BMI運算")
                .setPositiveButton("OK",null) //null不回傳值,直接結束跳出視窗
                .setNegativeButton("Cancel",null)
                .show();
        */

        //Use Intent 傳資料 intent.putExtra(標籤  ,資料 )
        Intent intent = new Intent(this , ResultActivity.class);
        intent.putExtra(getString(R.string.bmi_extra), bmi); //附帶資料  ;  抽離字串資源 把字串資料放到 R.string
        //startActivity(intent); //放在這就只執行前面的intent

        //bundle 傳送多種資料
        Bundle bag = new Bundle();
        bag.putFloat("BMI_Extra_Bundle",bmi);
        bag.putString("Test_Extra_Bundle","Bundle Testing");
        intent.putExtras(bag);

        startActivity(intent);//執行intent
    }
}
