package com.crazyapps.crazynudgemail;

import static com.crazyapps.crazynudgemail.TimeUnit.DAYS;
import static com.crazyapps.crazynudgemail.TimeUnit.HOURS;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;

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
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int	SUBJECT_LENGTH		= 32;
	protected static final int	DATEPICKER_REQUEST	= 0;
	private Typeface			font;
	private EMailer				eMailer;
	private EditText			editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
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
		Button clearButton = (Button) findViewById(id);
		clearButton.setTypeface(font);
		clearButton.setOnClickListener(new OnClickListener() {

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
				sendMail(to);
			}

		});
	}

	private void defineDateButton(int id) {
		Button dateButton = (Button) findViewById(id);
		dateButton.setTypeface(font);
		dateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent datePickerIntent = new Intent(MainActivity.this, DatePickerActivity.class);
				startActivityForResult(datePickerIntent, DATEPICKER_REQUEST);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (DATEPICKER_REQUEST == requestCode && RESULT_OK == resultCode) {
			Date date = (Date) data.getSerializableExtra(DatePickerActivity.RESULT);
			toast(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			String to = ToBuilder.date(cal.get(YEAR), cal.get(MONTH) + 1, cal.get(DAY_OF_MONTH));
			sendMail(to);
		}
	}

	private void sendMail(String to) {
		String message = editText.getText().toString();
		String subject = message.substring(0, message.length() > SUBJECT_LENGTH ? SUBJECT_LENGTH : message.length());
		eMailer.send(to, subject, message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void toast(Date date) {
		Toast toast = Toast.makeText(this, date.toString(), 2);
		toast.show();
	}
}
