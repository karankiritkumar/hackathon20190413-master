package com.example.hackathon20190413;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoanRepayment extends AppCompatActivity {

    EditText pmt;
    EditText principle;
    EditText term;
    EditText interest;
    TextView FutureValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_repayment);

        pmt = (EditText) this.findViewById(R.id.pmt);
        principle = (EditText) this.findViewById(R.id.principle);
        term = (EditText) this.findViewById(R.id.term);
        interest = (EditText) this.findViewById(R.id.interest);
        FutureValue = this.findViewById(R.id.FutureValue);


    }

    public void oncalculatebuttonpressed(View v)
    {
        double term1 = Integer.parseInt(this.term.getText().toString());
        double interest1 = Integer.parseInt(this.interest.getText().toString());
        double pmt1 = Integer.parseInt(this.pmt.getText().toString());
        double principle1 = Integer.parseInt(this.principle.getText().toString());

        double j =0;
        double output = 0;
        double output2 = 0;

        interest1 = interest1/100;



            double something = Math.pow((1+interest1), term1);

            output = (principle1 * something);
            output2 = (pmt1 * ((something -1)/interest1));

            output = output + output2;
        FutureValue.setText(output + "");

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void onClearButtonPressed(View V){

        pmt = (EditText) this.findViewById(R.id.pmt);
        pmt.setText("");
        principle = (EditText) this.findViewById(R.id.principle);
        principle.setText("");
        term = (EditText) this.findViewById(R.id.term);
        term.setText("");
        interest = (EditText) this.findViewById(R.id.interest);
        interest.setText("");
        FutureValue = this.findViewById(R.id.FutureValue);
        FutureValue.setText("");
    }
}


