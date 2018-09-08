package us.plee19;

/**
 * Class to create individual Meals objects with corresponding MealType to end up in a MealsArray.
 * @author plee19
 * @version 1
 */
public class Meals {
    private MealType mealType;
    private String item;
    private int calories;

    /**
     * Meals constructor with mealType, item and calories parameters to create instance of Meals object.
     * @param mealType type of meal, from mealType enum
     * @param item String name of meal
     * @param calories Integer calorie value of meal
     */
    public Meals(MealType mealType, String item, int calories) {
        this.mealType = mealType;
        this.item = item;
        this.calories = calories;
    }

    /**
     * When used on an instance of Meals, returns the mealType value from the mealType enum.
     * @return mealType type of meal, from mealType enum
     */
    public MealType getMealType() {
        return mealType;
    }

    /**
     * When used on an instance of Meals, returns the name of the meal.
     * @return String name of meal
     */
    public String getItem() {
        return item;
    }

    /**
     * When used on an instance of Meals, returns the integer value of calories for that instance.
     * @return int calorie value of meal
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Overridden method of equals to check class, calories, mealtype and item name for equality
     * @param o object to be checked against
     * @return boolean, true if matched, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meals meals = (Meals) o;

        if (getCalories() != meals.getCalories()) return false;
        if (getMealType() != meals.getMealType()) return false;
        return getItem().equals(meals.getItem());
    }

    /**
     * Overrides method of hashCode by multiplying hashCode value by 31 twice and adding calorie value
     * @return int new hashCode value result
     */
    @Override
    public int hashCode() {
        int result = getMealType().hashCode();
        result = 31 * result + getItem().hashCode();
        result = 31 * result + getCalories();
        return result;
    }

    /**
     * Overrides method of toString to produce concatenated strings with mealType, item and calories values
     * @return String concatenation with mealType, item and calories values
     */
    @Override
    public String toString() {
        return "Meals{" +
                "mealType=" + mealType +
                ", item='" + item + '\'' +
                ", calories=" + calories +
                '}';
    }

}
