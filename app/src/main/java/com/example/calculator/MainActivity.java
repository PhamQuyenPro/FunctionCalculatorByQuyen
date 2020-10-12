package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNumber;
    private TextView tvResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnPoint;
    private Button btnResult;
    private Button btnCE;
    private Button btnC;
    private Button btnBS;
    private Button btnAmDuong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget(){

        editNumber = (EditText) findViewById(R.id.edit_input);
        tvResult = (TextView)findViewById(R.id.tv_result);

        btnNumber1 = (Button)findViewById(R.id.btn_number1);
        btnNumber2 = (Button)findViewById(R.id.btn_number2);
        btnNumber3 = (Button)findViewById(R.id.btn_number3);
        btnNumber4 = (Button)findViewById(R.id.btn_number4);
        btnNumber5 = (Button)findViewById(R.id.btn_number5);
        btnNumber6 = (Button)findViewById(R.id.btn_number6);
        btnNumber7 = (Button)findViewById(R.id.btn_number7);
        btnNumber8 = (Button)findViewById(R.id.btn_number8);
        btnNumber9 = (Button)findViewById(R.id.btn_number9);
        btnNumber0 = (Button)findViewById(R.id.btn_number0);

        btnCong = (Button)findViewById(R.id.btn_Cong);
        btnTru = (Button)findViewById(R.id.btn_Tru);
        btnNhan = (Button)findViewById(R.id.btn_Nhan);
        btnChia = (Button)findViewById(R.id.btn_Chia);

        btnPoint = (Button)findViewById(R.id.btn_Point);
        btnCE = (Button)findViewById(R.id.btn_CE);
        btnC = (Button)findViewById(R.id.btn_C);
        btnBS = (Button)findViewById(R.id.btn_BS);
        btnAmDuong = (Button)findViewById(R.id.btn_AmDuong);
        btnResult = (Button)findViewById(R.id.btn_Result);

    }

    public void setEventClickViews() {
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnAmDuong.setOnClickListener(this);
    }

    long a = 0, b = 0, res = 0;
    int state = 0, state1 = 0;
    @Override

    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_number1:
                editNumber.append("1");
                break;
            case R.id.btn_number2:
                editNumber.append("2");
                break;
            case R.id.btn_number3:
                editNumber.append("3");
                break;
            case R.id.btn_number4:
                editNumber.append("4");
                break;
            case R.id.btn_number5:
                editNumber.append("5");
                break;
            case R.id.btn_number6:
                editNumber.append("6");
                break;
            case R.id.btn_number7:
                editNumber.append("7");
                break;
            case R.id.btn_number8:
                editNumber.append("8");
                break;
            case R.id.btn_number9:
                editNumber.append("9");
                break;
            case R.id.btn_number0:
                editNumber.append("0");
                break;
            case R.id.btn_Cong:
                state = 1;
                if (state1 == 1){
                    tvResult.setText("");
                }
                tvResult.append(editNumber.getText());
                a = Long.valueOf(editNumber.getText().toString());
                tvResult.append("+");
                editNumber.setText("");
                break;
            case R.id.btn_Tru:
                state = 2;
                if (state1 == 1){
                    tvResult.setText("");
                }
                tvResult.append(editNumber.getText());
                a = Long.valueOf(editNumber.getText().toString());
                tvResult.append("-");
                editNumber.setText("");
                break;
            case R.id.btn_Nhan:
                state = 3;
                if (state1 == 1){
                    tvResult.setText("");
                }
                tvResult.append(editNumber.getText());
                a = Long.valueOf(editNumber.getText().toString());
                tvResult.append("x");
                editNumber.setText("");
                break;
            case R.id.btn_Chia:
                state = 4;
                if (state1 == 1){
                    tvResult.setText("");
                }
                tvResult.append(editNumber.getText());
                a = Long.valueOf(editNumber.getText().toString());
                tvResult.append("/");
                editNumber.setText("");
                break;
            case R.id.btn_Point:
                Toast.makeText(getApplicationContext(),"Chỉ thực hiện phép tính với số nguyên", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_CE:
                editNumber.setText("");
                break;
            case R.id.btn_C:
                editNumber.setText("");
                tvResult.setText("");
                break;
            case R.id.btn_BS:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(editNumber,true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_Result:
                state1 = 1;
                b = Long.valueOf(editNumber.getText().toString());
                tvResult.append(editNumber.getText());
                editNumber.setText("");
                if(state == 1){
                    res = a + b;
                    editNumber.append(res + "");
                }
                else if(state == 2){
                    res = a - b;
                    editNumber.append(res + "");
                }
                else if(state == 3){
                    res = a * b;
                    editNumber.append(res + "");
                }
                else if(state == 4){
                    res = a / b;
                    editNumber.append(res + "");
                }

                break;
            case R.id.btn_AmDuong:
                long am = -Long.valueOf(editNumber.getText().toString());
                editNumber.setText("");
                editNumber.append(am + "");
                break;

        }
    }
}