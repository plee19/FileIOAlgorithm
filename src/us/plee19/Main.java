package us.plee19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class to show features of FileInput, FileOutput, Meals, MealsArray and MealType classes.
 * @author plee19
 * @version 1
 */
public class Main {

    private final static FileInput indata = new FileInput("meals_data.csv");
    private static Scanner keyboard = new Scanner(System.in);
    private static MealsArray mealsArray = new MealsArray();

    public static void main(String[] args) {
        String line;
        ArrayList<String> fields;

        while ((line = indata.fileReadLine()) != null) {
            fields = new ArrayList<>(Arrays.asList(line.split(",")));
            mealsArray.addElementWithStrings(fields.get(0),fields.get(1),fields.get(2));
        }
        runMenu();
    }

    /**
     * Method to list options leading to other methods, requiring user input, run before the runMenu() method.
     */
    private static void printMenu() {
        System.out.println("Select Action");
        System.out.println("1. List All Items");
        System.out.println("2. List All Items by Meal");
        System.out.println("3. Search by Meal Name");
        System.out.println("4. Exit");
        System.out.print("Please Enter your Choice: ");
    }

    /**
     * Method to accept user input and run corresponding method.
     */
    private static void runMenu() {
        char ans;
        boolean userContinue = true;
        while(userContinue) {
            printMenu();
            ans = keyboard.next().charAt(0);
            switch(ans) {
                case '1':   mealsArray.printAllMeals();break;
                case '2':   listByMeal();break;
                case '3':   searchByName();break;
                case '4':   userContinue=false;break;
            }
        }
    }

    /**
     * Method to request user input for meal type that reads from mealsArray using enum MealType and returns list of meals.
     */
    private static void listByMeal() {
        char ans;
        int ansNum=0;
        boolean userContinue = true;
        MealType mealType;
        ArrayList<MealType> mealTypeName = new ArrayList<>();

        System.out.println("Which Meal Type");
        int i=1;

        for(MealType m : MealType.values())
        {
            if (i < MealType.values().length + 1) {
                mealTypeName.add(m);
                System.out.println(i++ + ") "+ m.getMeal());
            }
            else {
                System.out.println("Too Many Meal Types " + m.getMeal() + " not included.");
            }
        }
        System.out.print("Please Enter your Choice: ");
        ans = keyboard.next().charAt(0);
        if (Character.isDigit(ans)) {
            ansNum = Character.getNumericValue(ans);
            mealType = mealTypeName.get(ansNum-1);
        }
        else {
            mealType = MealType.DINNER;
            System.out.println("Invalid Meal Type " + ans + ", defaulted to " + mealType.getMeal() + ".");
        }
        mealsArray.printMealsByType(mealType);
    }

    /**
     * Method to search mealsArray for specific user input search string on meal name.
     */
    private static void searchByName() {
        keyboard.nextLine();
        System.out.print("Please Enter Value: ");
        String ans = keyboard.nextLine();
        mealsArray.printByNameSearch(ans);
    }
}