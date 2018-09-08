package us.plee19;

/**
 * Enumerated class of meal types and String methods.
 * @author plee19
 * @version 1
 */
public enum MealType {
    BREAKFAST("Breakfast"), DESSERT("Dessert"), DINNER("Dinner"), LUNCH("Lunch");

    private String meal;

    /**
     * Method to associate String value of a meal's name with a MealType enum.
     * @param meal String name of meal
     */
    MealType(String meal) {
        this.meal = meal;
    }

    /**
     * Method to return a meal's name.
     * @return meal String name of meal
     */
    public String getMeal() {
        return meal;
    }
}
