
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickOnItem;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
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
    public void viewFavorisOnSucces(){

        onView(getViewWithContentDescription()).check(matches(isDisplayed()));
        onView(getViewWithContentDescription()).perform(RecyclerViewActions.actionOnItemAtPosition(3, new ClickOnItem()));
        onView(withId(R.id.pageDetail)).check(matches(isDisplayed()));
    }

    // VERIFIER QUE  LORSQU ON CLIQUE SUR LA POSIITON 3 LE NOM DU VOISIN EST AFFICHE
    //DUPLIQUER LA METHODE ET VERIFIER QUE LE NOM AFFICHER EST LE NOM SUR LEQUEL LE SYSTEME A CLIQUER
    //GETNAME POUR VERIFIER SON NOM


    //POUR LA DERNIERE METODE DUPLIQUER LES DEUX PREMEIRE LIGNE
    //PERMFORMER LE CLIQUE SUR
    //PRESSBACK POUR REVENIR EN ARRIERE ET CLIQUER SUR UN AUTRE VOISIN
    //PERFORME LE CLIQUE SUR LE VOISIN
    //VERIFIER QUE LE NOMBRE DANS LE RECYCLER VIEW = 2
    //NE PAS OUBLIER QUE LE PRESSBACK LA DESCRITION EST "1"

    //RESSBACK ET SWIPELIFT RECHERC A FAIRE SUR ESPRESSO

}

