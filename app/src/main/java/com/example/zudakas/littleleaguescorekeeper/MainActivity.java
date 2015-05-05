package com.example.zudakas.littleleaguescorekeeper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView fouls;
    TextView balls;
    TextView strikes;
    TextView outs;
    TextView runs;
    TextView home;
    TextView away;
    TextView currentTeam;

    Button runsbutton;
    Button strikesbutton;
    Button outsbutton;
    Button ballsbutton;
    Button foulsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fouls = (TextView) findViewById(R.id.foulstext);
        balls = (TextView) findViewById(R.id.ballstext);
        strikes = (TextView) findViewById(R.id.strikestext);
        outs = (TextView) findViewById(R.id.outstext);
        runs = (TextView) findViewById(R.id.runstext);
        home = (TextView) findViewById(R.id.homescore);
        away = (TextView) findViewById(R.id.awayscore);
        currentTeam = (TextView) findViewById(R.id.currentteam);

        runsbutton = (Button) findViewById(R.id.runsbutton);
        runsbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (currentTeam.getText().toString() == "Away Team") {
                    int awayScore = Integer.parseInt(away.getText().toString());
                    awayScore = awayScore + 1;
                    away.setText(Integer.toString(awayScore));
                    int runCount = Integer.parseInt(runs.getText().toString());
                    runCount = runCount + 1;
                    runs.setText(Integer.toString(runCount));
                } else if (currentTeam.getText().toString().equals("Home Team")) {
                    int homeScore = Integer.parseInt(home.getText().toString());
                    homeScore = homeScore + 1;
                    home.setText(Integer.toString(homeScore));
                    int runCount = Integer.parseInt(runs.getText().toString());
                    runCount = runCount + 1;
                    runs.setText(Integer.toString(runCount));
                }

            }
        });
        outsbutton = (Button) findViewById(R.id.outsbutton);
        outsbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                countOuts();
            }
        });
        ballsbutton = (Button) findViewById(R.id.ballsbutton);
        ballsbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Integer.parseInt(balls.getText().toString()) < 4) {
                    balls.setText(String.valueOf(Integer.parseInt(balls.getText().toString()) + 1));
                }else {
                    balls.setText("0");
                }
            }
        });

        strikesbutton = (Button) findViewById(R.id.strikesbutton);
        strikesbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int strikeCount = Integer.parseInt(strikes.getText().toString());
                if(strikeCount <2) {
                    strikeCount = strikeCount + 1;
                }else {
                    strikeCount = 0;
                    countOuts();
                }
                strikes.setText(Integer.toString(strikeCount));
            }
        });

        foulsbutton = (Button) findViewById(R.id.foulsbutton);
        foulsbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int foulCount = Integer.parseInt(fouls.getText().toString());
                if(foulCount <2) {
                    foulCount = foulCount + 1;
                    strikes.setText(String.valueOf(Integer.parseInt(strikes.getText().toString())+1));
                }else if (foulCount >= 2) {
                    foulCount = foulCount +1;
                }
                fouls.setText(Integer.toString(foulCount));
            }
        });
        swapTeams();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.quitApp) {
            quitApp(0);
        }

        return super.onOptionsItemSelected(item);
    }
    public void quitApp(int code){
        System.exit(code);
    }
    public void swapTeams(){
        if(currentTeam.getText().toString().equals("Away Team")) {
            currentTeam.setText("Home Team");
        }else if(currentTeam.getText().toString().equals("Home Team")) {
            currentTeam.setText("Away Team");
        }else {
            currentTeam.setText("Away Team");
        }
        runs.setText("0");
        balls.setText("0");
        strikes.setText("0");
        fouls.setText("0");
        outs.setText("0");
    }
    public void countOuts(){
        int outCount = Integer.parseInt(outs.getText().toString());
        if(outCount <2) {
            outCount = outCount + 1;
        }else {
            outCount = 0;
            swapTeams();
        }
        outs.setText(Integer.toString(outCount));

    }
}
