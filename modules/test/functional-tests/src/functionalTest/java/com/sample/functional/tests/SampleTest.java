package com.sample.functional.tests;

import static com.sample.functional.pages.SamplePage.returnFalse;
import static com.sample.functional.pages.SamplePage.returnTrue;

import com.sample.functional.utils.FunctionalTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends FunctionalTest {

	@BeforeClass
	public static void setup() {
	}

	@AfterClass
	public static void tearDown() {
	}

	@Before
	public void beforeTestMethod() throws Exception {
	}

	@Test
	public void testSample_validFalseReturn_returnFalse() {
		Assert.assertFalse(returnFalse());
	}

	@Test
	public void testSample_validTrueReturn_returnTrue() {
		Assert.assertTrue(returnTrue());
	}

}