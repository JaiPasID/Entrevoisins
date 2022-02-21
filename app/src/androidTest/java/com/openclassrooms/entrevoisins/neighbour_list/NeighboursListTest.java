
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.os.IResultReceiver;
import android.view.View;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ActivityDetailVoisin;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickOnItem;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), withContentDescription("0")))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    private Matcher<View>getViewWithContentDescription(){
        return allOf(withId(R.id.list_neighbours), withContentDescription("0"));
    }


    @Test
    public void checkDetailNeighbour(){

        onView(getViewWithContentDescription()).check(matches(isDisplayed()));
        onView(getViewWithContentDescription()).perform(RecyclerViewActions.actionOnItemAtPosition(3, new ClickOnItem()));
        onView(withId(R.id.pageDetail)).check(matches(isDisplayed()));
    }


    @Test
    public void veifyNameNeighbour(){

        onView(getViewWithContentDescription()).check(matches(isDisplayed()));
        onView(getViewWithContentDescription()).perform(RecyclerViewActions.actionOnItemAtPosition(3, new ClickOnItem()));
        onView(withId(R.id.pageDetail)).check(matches(isDisplayed()));
        onView(withClassName(containsString(ActivityDetailVoisin.class.getName())));
    }



    @Test
    public void verifyPositionNeighbour(){


        onView(getViewWithContentDescription()).check(matches(isDisplayed()));
        onView(getViewWithContentDescription()).perform(RecyclerViewActions.actionOnItemAtPosition(3, new ClickOnItem()));
        onView(withId(R.id.pageDetail)).check(matches(isDisplayed()));
        onView(withId(R.id.bouton_flottan)).perform(ViewActions.click());
        Espresso.pressBack();
        onView(allOf(withId(R.id.list_neighbours), withContentDescription("1"))).perform(swipeLeft());


        // POUR LA DERNIERE METODE DUPLIQUER LES DEUX PREMEIRE LIGNE
        // PERMFORMER LE CLIQUE SUR
        // PRESSBACK POUR REVENIR EN ARRIERE ET CLIQUER SUR UN AUTRE VOISIN
        // PERFORME LE CLIQUE SUR LE VOISIN
        // VERIFIER QUE LE NOMBRE DANS LE RECYCLER VIEW = 2
        // NE PAS OUBLIER QUE LE PRESSBACK LA DESCRITION EST "1"

    }





    // RESSBACK ET SWIPELIFT RECHERCHE A FAIRE SUR ESPRESSO

}

