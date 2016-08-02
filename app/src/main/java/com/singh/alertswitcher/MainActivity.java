package com.singh.alertswitcher;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        FrameLayout ContentView = (FrameLayout) findViewById(R.id.content);
        ContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RingerHelper.performToggle(audioManager);
                updateUi();
            }
        });
    }
        private void updateUi()
    {
        ImageView imageView= (ImageView) findViewById(R.id.picture);
        int phoneimage=RingerHelper.isPhoneSilent(audioManager)
                ? R.drawable.ringer_off
                :R.drawable.ringer_on;
        imageView.setImageResource(phoneimage);
    }
        @Override
    protected void onResume()
        {
            super.onResume();
            updateUi();
    }
}
