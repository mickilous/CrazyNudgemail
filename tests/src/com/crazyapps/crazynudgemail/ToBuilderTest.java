package com.crazyapps.crazynudgemail;

import junit.framework.TestCase;

public class ToBuilderTest extends TestCase {

	public void testHours() {
		assertEquals("3h@nudgemail.com", ToBuilder.hours(3));
	}

	public void testDays() {
		assertEquals("2d@nudgemail.com", ToBuilder.days(2));
	}

	public void testDate() {
		assertEquals("11212010@nudgemail.com", ToBuilder.date(2010, 11, 21));
		assertEquals("02032010@nudgemail.com", ToBuilder.date(2010, 2, 3));
	}

}
