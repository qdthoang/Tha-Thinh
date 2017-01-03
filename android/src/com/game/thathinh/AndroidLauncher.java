package com.game.thathinh;

import android.content.res.Resources;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
	private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
	private CustomHandler customHandler;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		customHandler = new CustomHandler(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = true;
		initialize(new ThaThinh(screenWidth, screenHeight, customHandler), config);
	}
}
