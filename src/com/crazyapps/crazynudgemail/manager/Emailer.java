package com.crazyapps.crazynudgemail.manager;

import android.content.Context;
import android.content.Intent;

public class Emailer {

	private final static String	to	= "nudge@nudgemail.com";

	private Context				context;

	public Emailer(Context context) {
		super();
		this.context = context;
	}

	public void send(String subject, String message) {
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
		email.putExtra(Intent.EXTRA_SUBJECT, subject);
		email.putExtra(Intent.EXTRA_TEXT, message);
		email.setType("message/rfc822");
		context.startActivity(Intent.createChooser(email, "Choose an Email client :"));
	}

}
