package com.crazyapps.crazynudgemail;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/Hand_Of_Sean_Demo.ttf");
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setTypeface(myTypeface);

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setTypeface(myTypeface);

		Button b3 = (Button) findViewById(R.id.button3);
		b3.setTypeface(myTypeface);

		Button b4 = (Button) findViewById(R.id.button4);
		b4.setTypeface(myTypeface);

		Button b5 = (Button) findViewById(R.id.button5);
		b5.setTypeface(myTypeface);

		Button b6 = (Button) findViewById(R.id.button6);
		b6.setTypeface(myTypeface);

		Button b7 = (Button) findViewById(R.id.button7);
		b7.setTypeface(myTypeface);

		Button b8 = (Button) findViewById(R.id.button8);
		b8.setTypeface(myTypeface);

		Button b9 = (Button) findViewById(R.id.button9);
		b9.setTypeface(myTypeface);

		Button b10 = (Button) findViewById(R.id.button10);
		b10.setTypeface(myTypeface);

		Button b11 = (Button) findViewById(R.id.button11);
		b11.setTypeface(myTypeface);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
