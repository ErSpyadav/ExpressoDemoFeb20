package demo.expresso.expresstestapp18feb2020;

import android.util.Log;
import android.widget.EditText;

import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpressoTest1 {


    @Before
    public void setUp() throws Exception {

    }

    @Rule
    public  ActivityTestRule<MainActivity> activityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUi(){
        onView(withText("Hello World!")).check(matches(isDisplayed()));
        onView(withText("Save")).check(matches(isDisplayed()));
        onView(withText("Save")).check(matches(isCompletelyDisplayed()));

        onView(withContentDescription("images")).check(matches(isDisplayed()));
        onView(withHint("enter your name")).check(matches(isDisplayed()));


        onView(withId(R.id.btn)).check(matches(isDisplayed()));
        onView(withId(R.id.imgButton)).check(matches(isDisplayed()));
        onView(withId(R.id.editText)).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.btn),isClickable()));
        onView(allOf(withId(R.id.btn),isFocusable()));
        onView(allOf(withId(R.id.btn),hasFocus()));
        onView(allOf(withId(R.id.imgButton),hasContentDescription()));
        /* isChecked(), isNotChecked(),hasLink(),isSelected() */

        onView(withClassName(endsWith("EditText")));
        onView(withText(startsWith("Hello")));




    }



    @After
    public void tearDown() throws Exception {

    }
}
