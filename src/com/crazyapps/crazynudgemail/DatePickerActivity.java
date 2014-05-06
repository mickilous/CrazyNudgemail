/**
 * 
 */
package com.crazyapps.crazynudgemail;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

/**
 * @author id0
 * 
 */
public class DatePickerActivity extends Activity {

	private CalendarPickerView	calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_view);

		final Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);

		calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
		calendar.init(new Date(), nextMonth.getTime()) //
				.inMode(SelectionMode.SINGLE) //
				.withSelectedDate(new Date());
	}

}
