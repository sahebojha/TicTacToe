
package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer = 0;

    int[] myGameState={2,2,2,2,2,2,2,2,2};


    public void imageTapped(View view) {
        ImageView myTapped = (ImageView)view;
        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tappedImageTag]==2){
            myGameState[tappedImageTag]= myActivePlayer;
            if(myActivePlayer ==0){
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(500);
                myActivePlayer=1;
            }else {
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer=0;
            }

        }else {
            Log.i("msg","this is already filled");
            //Toast.makeText(this,"this is already filled").LENGTH_SHORT
        }


    }

    public void playAgain(View view){

        for (int i=0; i<myGameState.length;i++){
            myGameState[i] = 2;
        }
        myActivePlayer = 0;

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.line1);
        for (int i=0;i<linearLayout.getChildCount();i++){
            ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayouttwo = (LinearLayout)findViewById(R.id.line2);
        for (int i=0;i<linearLayouttwo.getChildCount();i++){
            ((ImageView)linearLayouttwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutthree = (LinearLayout)findViewById(R.id.line3);
        for (int i=0;i<linearLayoutthree.getChildCount();i++){
            ((ImageView)linearLayoutthree.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
