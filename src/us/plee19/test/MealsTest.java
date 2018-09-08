package us.plee19.test;

import junit.framework.TestCase;
import org.junit.*;
import us.plee19.*;

public class MealsTest extends TestCase {

    Meals mealTest = new Meals(MealType.DINNER, "pizza", 300);
    Meals mealTest2 = new Meals(MealType.DINNER, "pizza", 300);
    Meals mealTest3 = new Meals(MealType.BREAKFAST, "eggs", 150);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMealType() {
        assertEquals(MealType.DINNER, mealTest.getMealType());
        assertFalse(mealTest.getMealType() == mealTest3.getMealType());
    }

    @Test
    public void testGetItem() {
        assertEquals("pizza", mealTest.getItem());
        assertFalse(mealTest.getItem() == mealTest3.getItem());
    }

    @Test
    public void testGetCalories() {
        assertEquals(300, mealTest.getCalories());
        assertFalse(mealTest.getCalories() == mealTest3.getCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(mealTest.equals(mealTest2));
        assertFalse(mealTest.equals(mealTest3));
    }
}