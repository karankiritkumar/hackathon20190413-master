package com.example.hackathon20190413;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TableofContents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableof_contents);
    }

    public void onGPAbuttonClicked(View v) {
        Intent i = new Intent(this, InputGPA.class);
        startActivity(i);
    }

    public void onUpdateButtonPress(View v) {
        Intent i = new Intent(this, updateUser.class);
        startActivity(i);
    }
    public void onShapeButtonPress(View v) {
        Intent i = new Intent(this, CalculateShapes.class);
        startActivity(i);
    }
    public void onInvestmentButtonPress(View v) {
        Intent i = new Intent(this, LoanRepayment.class);
        startActivity(i);
    }
    public void onRandGameButtonPress(View v) {
        Intent i = new Intent(this, RandNumGuesser.class);
        startActivity(i);
    }

}
