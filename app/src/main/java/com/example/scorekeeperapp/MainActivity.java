package com.example.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int scoreTeamA = 0;
    public int scoreTeamB = 0;
    public int numYellowA = 0;
    public int numYellowB = 0;
    public int numRedA = 0;
    public int numRedB = 0;
    public int numFoulA = 0;
    public int numFoulB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamA = 0;
        scoreTeamB = 0;
        numYellowA = 0;
        numYellowB = 0;
        numRedA = 0;
        numRedB = 0;
        numFoulA = 0;
        numFoulB = 0;
    }


    // for Score
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    // for faule
    public void addOneFauleTeamA(View v) {
        numFoulA = numFoulA + 1;
        displayFoulA(numFoulA);
    }

    public void addOneFauleTeamB(View v) {
        numFoulB = numFoulB + 1;
        displayFoulB(numFoulB);
    }

    //for yellow card
    public void addOneYellowTeamA(View v) {
        Log.d("dataDebage", "inside one yallow A");
        numYellowA = numYellowA + 1;
        displayYellowA(numYellowA);
    }

    public void addOneYellowTeamB(View v) {
        numYellowB = numYellowB + 1;
        displayYellowB(numYellowB);
    }

    //for red card
    public void addOneRedTeamA(View v) {
        numRedA = numRedA + 1;
        displayRedA(numRedA);
    }

    public void addOneRedTeamB(View v) {
        numRedB = numRedB + 1;
        displayRedB(numRedB);
    }


    //reset all
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        numYellowA = 0;
        numYellowB = 0;
        numRedA = 0;
        numRedB = 0;
        numFoulA = 0;
        numFoulB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayYellowA(numYellowA);
        displayYellowB(numYellowB);
        displayRedA(numRedA);
        displayRedB(numRedB);
        displayFoulA(numFoulA);
        displayFoulB(numFoulB);
    }

    /**
     * Displays the given score for Team A and b
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the  foul for Team A and b
     */
    public void displayFoulA(int f) {
        // get referance
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(f));
    }

    public void displayFoulB(int f) {
        // get referance
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(String.valueOf(f));
    }

    /**
     * Displays the  yellow card for Team A and b
     */
    public void displayYellowA(int y) {
        // get referance
        Log.d("dataDebage", "inside display yallow A");
        TextView yCardView = (TextView) findViewById(R.id.team_a_yellow);
        yCardView.setText(String.valueOf(y));
    }

    public void displayYellowB(int y) {
        // get referance
        TextView yCardView = (TextView) findViewById(R.id.team_b_yellow);
        yCardView.setText(String.valueOf(y));
    }

    /**
     * Displays the  red card for Team A and b
     */
    public void displayRedA(int r) {
        TextView yCardView = (TextView) findViewById(R.id.team_a_red);
        yCardView.setText(String.valueOf(r));
    }

    public void displayRedB(int r) {
        TextView rCardView = (TextView) findViewById(R.id.team_b_red);
        rCardView.setText(String.valueOf(r));
    }

    // display the winner
    public void winner(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("The Final result of the Match");
        if (scoreTeamA>scoreTeamB){
            alertDialog.setMessage("The Winner is : TEAM A \nTEAM A     "+ scoreTeamA+ " X "+ scoreTeamB+"      TEAM B");
        }
        else if(scoreTeamB>scoreTeamA){
            alertDialog.setMessage("The Winner is : TEAM B \nTEAM B     "+ scoreTeamB+ " X "+ scoreTeamB+"      TEAM B");
        }
        else{
            alertDialog.setMessage("Draw   \nTEAM A     "+ scoreTeamA+ " X "+ scoreTeamB+"      TEAM B");
        }
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Congratulation",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();


        resetScore(v);
    }


}//end main activity
