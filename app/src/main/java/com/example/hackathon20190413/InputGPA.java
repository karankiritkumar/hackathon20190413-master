package com.example.hackathon20190413;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class InputGPA extends AppCompatActivity {

    public String Classgrade=null;
    EditText ClassgradeET;
    private ArrayAdapter<String> aa;
    TextView gradesTV;
    TextView NameTV;
    String Grades = " ";
    int Classcount = 0;
    double GPA = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_gp);

        ClassgradeET = (EditText)this.findViewById(R.id.EnterGradeET);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();


            TextView NameTV = this.findViewById(R.id.NameTV);
            NameTV.setText("Hello " + name + " Please Enter Your Grades");
        }

    }

    public void onEnterbuttonPRessed(View v){
        Classgrade = this.ClassgradeET.getText().toString().trim();
        Grades = Grades + " " + Classgrade;
        System.out.println("***Classgrade:" + Classgrade);
        TextView gradesTV = this.findViewById(R.id.Grades);
        gradesTV.setText(Grades);
        Classcount = Classcount +1;

        if(Classgrade.equals("A+"))
        {
            GPA = GPA + 4;
        }
        else if(Classgrade.equals("A")) {
            GPA = GPA + 4;
        }
        else if(Classgrade.equals("A-")){
            GPA = GPA + 3.7;
        }else if(Classgrade.equals("B+")){
            GPA = GPA + 3.3;
        }else if(Classgrade.equals("B")){
            GPA = GPA + 3;
        }
        else if(Classgrade.equals("B-")){
            GPA = GPA + 2.7;
        }
        else if(Classgrade.equals("C+")){
            GPA = GPA + 2.3;
        } else if(Classgrade.equals("C")){
            GPA = GPA + 2;
        } else if(Classgrade.equals("C-")){
            GPA = GPA + 1.7;
        }
        else if(Classgrade.equals("D+")){
            GPA = GPA + 1.3;
        } else if(Classgrade.equals("D")){
            GPA = GPA + 1;
        } else if(Classgrade.equals("D-")){
            GPA = GPA + 0.7;
        }
        else if(Classgrade.equals("F")) {
            GPA = GPA + 0;
        }
        ClassgradeET = (EditText)this.findViewById(R.id.EnterGradeET);
        ClassgradeET.setText("");
    }

    public void onCalculateButtonPressed(View v)
    {
        double calGPA = 0;

        calGPA = (double) GPA / Classcount;
        System.out.println("***CalGPA" + calGPA);
        System.out.println("***GPA" + GPA);
        System.out.println("***Classcout" + Classcount);

        String display = calGPA + " ";
        TextView GPA = this.findViewById(R.id.GPA);
        GPA.setText(display);
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void onClearButtonPressed(View v)
    {
        Grades = "";
        Classcount = 0;
        GPA = 0;
        TextView gradesTV = this.findViewById(R.id.Grades);
        gradesTV.setText("");
        ClassgradeET = (EditText)this.findViewById(R.id.EnterGradeET);
        ClassgradeET.setText("");
        TextView GPA = this.findViewById(R.id.GPA);
        GPA.setText("");


    }



}
