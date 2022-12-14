import java.lang.*;
import java.util.*;

// Method to listen for generations input
public class GOLView {

    // Display welcome string object input
    public void displayWelcome(String welcome) {
        System.out.println(welcome);
    }

    // Listen for and return rule choice
    public int ruleChoiceListener() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\nSee rules? (0 = No, 1 = Yes) \n");
        return input.nextInt();
    }

    // Display Rules
    public void displayRules(String rules) // takes in a string,
    {
        if (rules == "")
            ;
        else
            System.out.println(rules);
    }

    // Listen for and return generations
    public int generationsListener() {
        int generations;
        Scanner input = new Scanner(System.in);

        System.out.print("How many generations?");
        System.out.println();
        generations = input.nextInt();
        return generations;
    }

    // Listen for and return dimensions
    public int dimensionListener() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter # of rows and columns (equal) ");
        return input.nextInt();

    }

    //Listen for and return interval
    public int intervalListener() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter time Interval (in ms) (1 sec = 1000ms): ");
        return input.nextInt();

    }

    // Listen for and return pattern choice
    public int patternSelectionListener(String patternList) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\nSelect pattern: " +
                patternList +
                "\n\nEnter your choice below\n");

        return input.nextInt();
    }


    // Method to display a 2x2 grid
    public void displayGrid(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print("@ ");
            }
            // line break
            System.out.println();
        }
    }

    // Method to display a new Generation Header
    public void displayGenerationHeader(String generationHeader) {
        System.out.println(generationHeader);
    }

    //Method to display the generation tracker
    public void displayGenerationTracker(int generation) {
        System.out.println("Generation: " + (generation + 1));
    }

    public void linebreak() {
        System.out.println();
    }
}





