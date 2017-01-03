package com.game.thathinh;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by quyendinhthuchoang on 12/26/2016.
 */

public class CustomHandler implements ICustomHandler {
    Handler handler;
    Context context;

    public CustomHandler(Context context) {
        handler = new Handler();
        this.context = context;
    }

    public void callGameIntent() {
        final Intent gameIntent = new Intent(context, Credit_1Activity.class);
        handler.post(new Runnable() {
            @Override
            public void run() {
                context.startActivity(gameIntent);
            }
        });
    }
}
