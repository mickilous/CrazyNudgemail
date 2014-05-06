package com.crazyapps.crazynudgemail;

import static com.crazyapps.crazynudgemail.TimeUnit.DAYS;
import static com.crazyapps.crazynudgemail.TimeUnit.HOURS;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Typeface	font;
	private EMailer		eMailer;
	private EditText	editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		font = Typeface.createFromAsset(getAssets(), "fonts/Hand_Of_Sean_Demo.ttf");

		editText = (EditText) findViewById(R.id.content_input);

		eMailer = new EMailer(this);

		defineButton(R.id.button1, 1, HOURS);
		defineButton(R.id.button2, 2, HOURS);
		defineButton(R.id.button3, 4, HOURS);
		defineButton(R.id.button4, 6, HOURS);
		defineButton(R.id.button5, 8, HOURS);
		defineButton(R.id.button6, 12, HOURS);
		defineButton(R.id.button7, 1, DAYS);
		defineButton(R.id.button8, 2, DAYS);
		defineButton(R.id.button9, 4, DAYS);

		defineDateButton(R.id.button10);

		defineClearButton(R.id.button11);
	}

	private void defineClearButton(int id) {
		Button b11 = (Button) findViewById(id);
		b11.setTypeface(font);
		b11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editText.setText("");
			}
		});
	}

	private void defineButton(int id, final int quantity, final TimeUnit unit) {
		Button b = (Button) findViewById(id);
		b.setTypeface(font);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String to = null;
				switch (unit) {
					case HOURS:
						to = ToBuilder.hours(quantity);
						break;
					case DAYS:
						to = ToBuilder.days(quantity);
						break;
				}
				String message = editText.getText().toString();
				String subject = message.substring(0, message.length() > 64 ? 64 : message.length());
				eMailer.send(to, subject, message);
			}
		});
	}

	private void defineDateButton(int id) {
		Button b = (Button) findViewById(id);
		b.setTypeface(font);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, DatePickerActivity.class));
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
