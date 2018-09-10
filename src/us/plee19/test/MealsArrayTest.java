package us.plee19.test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MealsArrayTest extends TestCase {

    MealsArray meals;
    FileInput inputTest;
    private final ByteArrayOutputStream outStuff = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Before
    public void setUp() throws Exception {
        meals = new MealsArray();
        System.setOut(new PrintStream(outStuff));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(original);
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

    // Issues with proper output in void methods
    @Test
    public void testPrintAllMeals() {
        meals.addElementWithStrings("Dinner", "pizza", "300");
        meals.printAllMeals();
        assertEquals("Meals{mealType=Dinner, item='pizza', calories=300}\r\n", outStuff.toString());
    }

    @Test
    public void testPrintMealsByType() {
        meals.addElementWithStrings("Dinner", "pizza", "300");
        meals.printMealsByType(MealType.DINNER);
        assertEquals("Meals{mealType=Dinner, item='pizza', calories=300}\r\n", outStuff.toString());
    }

    //
    @Test
    public void testPrintByNameSearch() {
        meals.addElementWithStrings("Dinner", "pizza", "300");
        meals.printByNameSearch("pizza");
        assertEquals("Meals{mealType=DINNER, item='pizza', calories=300}\r\n",  outStuff.toString());
    }
}