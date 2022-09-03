package com.example.calculator_cooldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btc_00, btc_0, btc_1, btc_2, btc_3, btc_4, btc_5, btc_6, btc_7, btc_8, btc_9;
    Button btc_dot, btc_equal, btc_plus, btc_minus, btc_multiply, btc_divide, btc_del, btc_percent, btc_ac;

    TextView inputTextC,outputTextC;

    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextC = findViewById(R.id.inputText);
        outputTextC = findViewById(R.id.outputText);

        btc_0 = findViewById(R.id.bt_zero);
        btc_00 = findViewById(R.id.bt_d_zero);
        btc_1 = findViewById(R.id.bt_one);
        btc_2 = findViewById(R.id.bt_two);
        btc_3 = findViewById(R.id.bt_three);
        btc_4 = findViewById(R.id.bt_four);
        btc_5 = findViewById(R.id.bt_five);
        btc_6 = findViewById(R.id.bt_six);
        btc_7 = findViewById(R.id.bt_seven);
        btc_8 = findViewById(R.id.bt_eight);
        btc_9 = findViewById(R.id.bt_nine);

        btc_dot = findViewById(R.id.bt_dot);
        btc_equal = findViewById(R.id.bt_equal);
        btc_plus = findViewById(R.id.bt_plus);
        btc_minus = findViewById(R.id.bt_minus);
        btc_multiply = findViewById(R.id.bt_multiply);
        btc_divide = findViewById(R.id.bt_divide);
        btc_del = findViewById(R.id.bt_del);
        btc_percent = findViewById(R.id.bt_percent);
        btc_ac = findViewById(R.id.bt_ac);


        btc_0.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"0");
        });

        btc_00.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"00");
        });

        btc_1.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"1");
        });

        btc_2.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"2");
        });

        btc_3.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"3");
        });

        btc_4.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"4");
        });

        btc_5.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"5");
        });

        btc_6.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"6");
        });

        btc_7.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"7");
        });

        btc_8.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"8");
        });

        btc_9.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"9");
        });




        btc_dot.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+".");
        });

        btc_ac.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText("");
            outputTextC.setText("");
        });

        btc_plus.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"+");
        });

        btc_minus.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"-");
        });

        btc_percent.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"%");
        });

        btc_multiply.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"x");
        });

        btc_divide.setOnClickListener(view -> {
            data = inputTextC.getText().toString();
            inputTextC.setText(data+"÷");
        });

        btc_del.setOnClickListener(view -> {
            if (!inputTextC.getText().toString().isEmpty()){
                inputTextC.setText(inputTextC.getText().toString().substring(0,inputTextC.getText().length()-1));
                outputTextC.setText("");
            }
        });

        btc_equal.setOnClickListener(view -> {
            data = inputTextC.getText().toString();

            data = data.replaceAll("x","*");
            data = data.replaceAll("%","/100");
            data = data.replaceAll("÷","/");

            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);

            String finalResult;

            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

            outputTextC.setText(finalResult);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.contact_us){
            Intent intent = new Intent(MainActivity.this,CallActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}