package com.example.changyuan.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnjia;
    private Button btnjian;
    private Button btncheng;
    private Button btnchu;
    private Button btndian;
    private Button btnclear;
    private Button btnde;
    private Button btndeng;
    private EditText ed;
    boolean flag;//清空标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnjia = (Button) findViewById(R.id.btn_jia);
        btnjian = (Button) findViewById(R.id.btn_jian);
        btncheng = (Button) findViewById(R.id.btn_cheng);
        btnchu = (Button) findViewById(R.id.btn_chu);
        btndeng = (Button) findViewById(R.id.btn_deng);
        btnde = (Button) findViewById(R.id.btn_del);
        btnclear = (Button) findViewById(R.id.btn_clear);
        btndian = (Button) findViewById(R.id.btn_dian);
        ed = (EditText) findViewById(R.id.input);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnjia.setOnClickListener(this);
        btnjian.setOnClickListener(this);
        btncheng.setOnClickListener(this);
        btnchu.setOnClickListener(this);
        btndeng.setOnClickListener(this);
        btndian.setOnClickListener(this);
        btnde.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        ed.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str = ed.getText().toString();
        switch (v.getId()) {

            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_dian:
                if(flag)
                {
                    flag=false;
                    ed.setText("");
                }
                ed.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_jia:
            case R.id.btn_jian:
            case R.id.btn_cheng:
            case R.id.btn_chu:
                if(flag)
                {
                    flag=false;
                    ed.setText("");
                }
                ed.setText(str + " " + ((Button) v).getText() + "　");
                break;
            case R.id.btn_clear:
                ed.setText("");
                break;
            case R.id.btn_del:
                if (str != null && str.equals("")) {
                    ed.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_deng:
                getResult();
                break;

        }
    }

    //结果
    private void getResult() {
        String content = ed.getText().toString();
        if (content == null && content.equals("")) {
            return;
        }
        if (!content.contains("")) {
            return;
        }
        if(flag)
        {
            flag=true;
            return;
        }
        double result = 0;
        //截取运算符前面的字符串
        String s1 = content.substring(0, content.indexOf(""));
        //截取运算符
        String op = content.substring(content.indexOf("") + 1, content.indexOf("") + 2);
        String s3 = content.substring(content.indexOf("") + 3);//运算符后面的字符串
        if (!s1.equals("") && !s3.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d3 = Double.parseDouble(s3);
            if (op.equals("+")) {
                result = d1 + d3;
            } else if (op.equals("-")) {
                result = d1 - d3;
            } else if (op.equals("*")) {
                result = d1 * d3;
            } else if (op.equals("/")) {
                if (d3 == 0) {
                    result = 0;
                } else {
                    result = d1 / d3;
                }
            }
            if (!s1.contains(".") && !s3.contains(".")) {
                int r = (int) result;
                ed.setText(r + "");
            } else {
                ed.setText(result + "");
            }
        } else if (!s1.equals("") && s3.equals("")) {
            ed.setText(content);
        }
        else if (s1.equals("") &&! s3.equals("")) {
            double d3 = Double.parseDouble(s3);
            if (op.equals("+")) {
                result = 0 + d3;
            } else if (op.equals("-")) {
                result = 0 - d3;
            } else if (op.equals("*")) {
                result = 0;
            } else if (op.equals("/")) {
                if (d3 == 0) {
               result=0;
                }
            }
            if ( s3.contains(".")) {
                int r = (int) result;
                ed.setText(r + "");
            } else {
                ed.setText(result + "");
            }
        } else{
            ed.setText("");
        }
    }
}
