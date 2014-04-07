package com.crazyapps.crazynudgemail;

import android.content.Context;
import android.content.Intent;

public class EMailer {

	private Context	context;

	public EMailer(Context context) {
		this.context = context;
	}

	public void send(String to, String subject, String message) {
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
		email.putExtra(Intent.EXTRA_SUBJECT, subject);
		email.putExtra(Intent.EXTRA_TEXT, message);
		email.setType("message/rfc822");
		context.startActivity(Intent.createChooser(email, "Choose an Email client :"));
	}

}
