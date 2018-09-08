package us.plee19;

import java.util.ArrayList;

/**
 * Class to create ArrayList of meals and associated methods.
 * @author plee19
 * @version 1
 */
public class MealsArray {
    private ArrayList<Meals> meals = new ArrayList<>();
    private int i = 0;
    private int calories;

    /**
     * Method to create a new meal element to the meals ArrayList.
     * @param arg1 String argument checked against MealType enum
     * @param arg2 String argument of meal name
     * @param arg3 String argument of meal's calorie value
     */
    public void addElementWithStrings(String arg1, String arg2, String arg3) {
        MealType mealType;
        if (i < meals.size() + 1) {

            switch (arg1) {
                case "Breakfast":
                    mealType = MealType.BREAKFAST;
                    break;
                case "Lunch":
                    mealType = MealType.LUNCH;
                    break;
                case "Dinner":
                    mealType = MealType.DINNER;
                    break;
                case "Dessert":
                    mealType = MealType.DESSERT;
                    break;
                default:
                    mealType = MealType.DINNER;
                    System.out.println("Invalid Meal Type " + arg1 + ", defaulted to Dinner.");
            }

            if (arg3.matches("-?\\d+(\\.\\d+)?")) {
                calories = Integer.parseInt(arg3);
            } else {
                calories = 100;
                System.out.println("Invalid Calories " + arg3 + ", defaulted to 100.");
            }
            meals.add(i++,new Meals(mealType, arg2, calories));
        }
        else {
            System.out.println("Items exceeded system size.  File has " + i + ", while the system can only handle " + meals.size() + ".");
        }
    }

    /**
     * Method to return the entries of the meals ArrayList.
     * @return meals entries of meals ArrayList
     */
    public ArrayList<Meals> getMeals() {
        return meals;
    }

    /**
     * Method to print all meals entries' names to the console.
     */
    public void printAllMeals() {
        for (Meals item: meals) {
            if (item != null) {
                System.out.println(item);
            }

        }
    }

    /**
     * Method to print all meals entries' names to the console, by selected MealType enum.
     * @param mealType enum of MealType by which to limit the result
     */
    public void printMealsByType(MealType mealType) {
        for (Meals item: meals) {
            if (item != null && item.getMealType() == mealType) {
                System.out.println(item);
            }

        }
    }

    /**
     * Method to print meals entries' names matching a name search.
     * @param s String value of meal name by which to limit the result
     */
    public void printByNameSearch(String s) {
        for (Meals item: meals) {
            if (item != null && item.getItem().indexOf(s) >= 0) {
                System.out.println(item);
            }

        }
    }
}
