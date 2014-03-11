package com.crazyapps.crazynudgemail;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.crazyapps.crazynudgemail.manager.Emailer;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Emailer emailer = new Emailer(this);
		View btnSend = findViewById(R.id.button1);
		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				emailer.send("1m", "test");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
