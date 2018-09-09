package us.plee19.test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.*;

public class MealsArrayTest extends TestCase {

    MealsArray meals = new MealsArray();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddElementWithStrings() {
        meals.addElementWithStrings("Dinner", "pizza", "300");
        assertNotNull(meals);
    }

    @Test
    public void testGetMeals() {
        assertNotNull(meals.getMeals());
    }

    @Test
    public void testPrintAllMeals() {
        meals.printAllMeals();
    }

    @Test
    public void testPrintMealsByType() {
        meals.printMealsByType(MealType.DINNER);
    }

    @Test
    public void testPrintByNameSearch() {
        meals.printByNameSearch("pizza");
    }
}