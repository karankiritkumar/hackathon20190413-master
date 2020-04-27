package com.example.hackathon20190413;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Guessthenumber extends AppCompatActivity {

    TextView Answer;
    EditText Guess;
    int highestNum;
    int GuessNum;
    int Guess1;
    int random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessthenumber);
        Random rand = new Random();

        Guess = (EditText) findViewById(R.id.Guess);
        Answer = findViewById(R.id.Answer);

        highestNum = this.getIntent().getIntExtra("highestNum", highestNum);
        GuessNum = this.getIntent().getIntExtra("guesses", GuessNum);

        random = rand.nextInt(highestNum);


    }


    public void onGuessButtonClicked(View V)
    {
        Guess1 = Integer.parseInt(this.Guess.getText().toString());

        if (random != Guess1){
            GuessNum --;
            Answer.setText("Guess Again. You have " + GuessNum + " Guesses remaining before you are kicked out.");

        }

        else if (random == Guess1)
        {
            Answer.setText("You found it out. The number was " + random);
        }

        if (GuessNum ==0)
        {
            finish();
        }

    }
}
