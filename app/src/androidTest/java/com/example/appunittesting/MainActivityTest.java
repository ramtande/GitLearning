package com.example.appunittesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;


import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;

     Instrumentation.ActivityMonitor monitor = InstrumentationRegistry.getInstrumentation() .addMonitor(SecondActivity.class.getName(),null,false);




    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mainActivity.findViewById(R.id.testTv);
        assertNotNull(view);

    }

    @Test
    public void testLanuchSecondActivityonBuutonClick() {
        View view = mainActivity.findViewById(R.id.button);
        assertNotNull(view);

        Espresso. onView(withId(R.id.button)).perform(click());
        Activity secondaActivity=InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(secondaActivity);
        secondaActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}