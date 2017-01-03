package com.game.thathinh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class Credit_3Activity extends AppCompatActivity {
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_3);
    }

    public void yesPopUp(View v) {
        LinearLayout activity_credit_3 = (LinearLayout) findViewById(R.id.activity_credit_3);
        LayoutInflater layoutInflater =
                (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.yes_pop_up, null);

        popupWindow = new PopupWindow(
                container,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.showAtLocation(activity_credit_3, Gravity.CENTER, 0, 0);

        Button yesButton = (Button) container.findViewById(R.id.fine_yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    public void noPopUp(View v) {
        LinearLayout activity_credit_3 = (LinearLayout) findViewById(R.id.activity_credit_3);
        LayoutInflater layoutInflater =
                (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.no_pop_up, null);

        popupWindow = new PopupWindow(
                container,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.showAtLocation(activity_credit_3, Gravity.CENTER, 0, 0);

        Button yesButton = (Button) container.findViewById(R.id.fine_no);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        Button noButton = (Button) container.findViewById(R.id.still_no);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                stillNoPopUp();
            }
        });
    }

    public void stillNoPopUp() {
        LinearLayout activity_credit_3 = (LinearLayout) findViewById(R.id.activity_credit_3);
        LayoutInflater layoutInflater =
                (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.still_no_pop_up, null);

        popupWindow = new PopupWindow(
                container,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.showAtLocation(activity_credit_3, Gravity.CENTER, 0, 0);

        Button yesButton = (Button) container.findViewById(R.id.fine_stil_no);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
