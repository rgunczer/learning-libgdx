package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.MyGdxGameSimpleBounceRealPixelSize;
import com.mygdx.game.MyGdxGameBounceUsingOrthoCameraNormCoords;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
//		initialize(new MyGdxGameSimpleBounceRealPixelSize(), config);
		initialize(new MyGdxGameBounceUsingOrthoCameraNormCoords(), config);
	}
}
