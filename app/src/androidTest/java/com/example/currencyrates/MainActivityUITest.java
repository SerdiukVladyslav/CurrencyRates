package com.example.currencyrates;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUIElementsDisplayed() {
        onView(withId(R.id.txtFilter)).check(matches(isDisplayed()));

        onView(withId(R.id.listRates)).check(matches(isDisplayed()));
    }

    @Test
    public void testFilterInput() {
        onView(withId(R.id.txtFilter)).perform(typeText("USD"));
    }
}
