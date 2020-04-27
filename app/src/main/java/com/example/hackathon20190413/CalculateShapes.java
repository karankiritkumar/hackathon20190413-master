package com.example.hackathon20190413;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateShapes extends AppCompatActivity {

    EditText shapeNum;
    EditText input1;
    EditText input2;
    TextView shapeoutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_shapes);

        shapeNum = (EditText)this.findViewById(R.id.shapeNum);
        input1 = (EditText)this.findViewById(R.id.input1);
        input2 = (EditText)this.findViewById(R.id.input2);
    }

    public void onCalculateButtonPressed(View v) {



        int shapenumber = Integer.parseInt(this.shapeNum.getText().toString());

        double output = 0;

        if (shapenumber == 1) {
            int in1 = Integer.parseInt(this.input1.getText().toString());
            int in2 = Integer.parseInt(this.input2.getText().toString());
            output = in1 * in2 * 0.5;
            TextView shapeoutput = this.findViewById(R.id.shapeoutput);
            shapeoutput.setText(output + "");

        } else if (shapenumber == 2) {
            int in1 = Integer.parseInt(this.input1.getText().toString());
            output = in1 * in1 * 3.14159;
            TextView shapeoutput = this.findViewById(R.id.shapeoutput);
            shapeoutput.setText(output + "");

        } else if (shapenumber == 3) {
            int in1 = Integer.parseInt(this.input1.getText().toString());
            int in2 = Integer.parseInt(this.input2.getText().toString());
            output = in1 * in2;
            TextView shapeoutput = this.findViewById(R.id.shapeoutput);
            shapeoutput.setText(output + "");


        }
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    public void onClearButtonPressed(View v)
        {
            shapeoutput = this.findViewById(R.id.shapeoutput);
            shapeoutput.setText("");
            input1 = this.findViewById(R.id.input1);
            input1.setText("");
            input2 = this.findViewById(R.id.input2);
            input2.setText("");
            shapeNum = (EditText)this.findViewById(R.id.shapeNum);
            shapeNum.setText("");


        }


}
