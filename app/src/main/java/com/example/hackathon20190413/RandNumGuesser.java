package com.example.hackathon20190413;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RandNumGuesser extends AppCompatActivity {

    EditText highestNum;
    EditText guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rand_num_guesser);

        highestNum = (EditText) this.findViewById(R.id.highestNum);
        guesses = (EditText) this.findViewById(R.id.guesses);


    }

    public void onSubmitButtonPressed(View v){
        int  highestNum1 = Integer.parseInt(this.highestNum.getText().toString());
        int  guesses1 = Integer.parseInt(this.guesses.getText().toString());

        Intent i = new Intent (this, Guessthenumber.class);
        i.putExtra("highestNum", highestNum1);
        i.putExtra("guesses", guesses1);
        startActivity(i);
    }

}
