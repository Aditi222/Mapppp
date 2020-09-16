package com.adarsh.chargecity.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.adarsh.chargecity.R;
import com.adarsh.chargecity.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {



    private static int SPLASH_TIMER =5000;

    //variables
    ImageView backgroundImage;
    TextView poweredByLine;
    //Animination
    Animation sideAnim,bottomAnim;


    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        //Hooks
        backgroundImage =findViewById(R.id.background_Image);
        poweredByLine=findViewById(R.id.powered_by_line);


        //Animinations

        sideAnim = AnimationUtils.loadAnimation(  this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation( this,R.anim.bottom_anim );

        //set Animation on elements
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime =onBoardingScreen.getBoolean("firstTime",true);

                if (isFirstTime){
                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    Intent intent= new Intent(getApplicationContext(),OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),UserDashboard.class);
                    startActivity(intent);
                    finish();

                }

                Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                startActivity(intent);
                finish();





            }
        },SPLASH_TIMER);

    }
}








