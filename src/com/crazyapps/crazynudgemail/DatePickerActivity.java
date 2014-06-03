/**
 * 
 */
package com.crazyapps.crazynudgemail;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

/**
 * @author id0
 * 
 */
public class DatePickerActivity extends Activity {

	public static final String	RESULT	= "RESULT";
	private CalendarPickerView	calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.date_view);

		defineCalendar();

	}

	private void defineCalendar() {
		final Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.YEAR, 2);

		calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
		calendar.init(new Date(), endDate.getTime()) //
				.inMode(SelectionMode.SINGLE) //
				.withSelectedDate(new Date());

		calendar.setOnDateSelectedListener(new OnDateSelectedListener() {

			@Override
			public void onDateUnselected(Date date) {
			}

			@Override
			public void onDateSelected(Date date) {
				Intent returnIntent = new Intent();
				returnIntent.putExtra(RESULT, date);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}

}
