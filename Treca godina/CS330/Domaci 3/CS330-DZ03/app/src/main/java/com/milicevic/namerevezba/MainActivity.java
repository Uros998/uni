package com.milicevic.namerevezba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView) findViewById(R.id.tvMessage);
        btn = (Button) findViewById(R.id.bChangeText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Metropolitan Univerzitet");
            }
        });
    }




    public void onClickShowMap(View view) {
        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/%D0%9C%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B0%D0%BD/@43.3070294,21.9450551,17z/data=!3m1!4b1!4m5!3m4!1s0x4755b06571362991:0x25d6cceab952b797!8m2!3d43.30706!4d21.9470396?hl=sr"));


        startActivity(i);
    }
}