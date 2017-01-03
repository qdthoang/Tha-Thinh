package com.game.thathinh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Credit_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_1);
    }

    public void next(View v) {
        Intent intent = new Intent(this, Credit_2Activity.class);
        startActivity(intent);
    }
}
