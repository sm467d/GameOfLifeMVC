import java.util.*;

public class GOLModel {

    // Method to Show the welcome screen the Welcome
    private int generations;
    private int dimensions;
    private int[][] grid;
    private int interval;
    private int patternSelection;
    private String header = "Parent Generation (First Pattern): ";
    private String patternList =
            "\n1. Glider" +
                    "\n2. Horizontal Line" +
                    "\n3. Vertical Line" +
                    "\n4. Cross";


    // Method to get welcome data
    public String getWelcome() {
        ArrayList<String> charStream = new ArrayList<String>();
        //First Row
        for (int i = 0; i < 125; i++) {
            charStream.add("*");
        }
        for (int i = 0; i < 7; i++)
        {
            charStream.add("*                                                               " +
                    "                                                            *\n");
        }
        charStream.add("*\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO GAME OF LIFE! \t\t\t\t\t\t\t\t\t" +
                "                *\n");

        for (int i = 0; i < 7; i++)
        {
            charStream.add("*                                                               " +
                    "                                                            *\n");
        }

        for (int i = 0; i < 125; i++) {
            charStream.add("*");
        }

        return String.join("", charStream);
    }

    // Get and Set Generations
    public int getGenerations() {
        return this.generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    // Get and set dimensions
    public int getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }



    // Get and set Grid
    public void setGrid(int dimensions) {
        this.dimensions = dimensions;
        this.grid = new int[dimensions][dimensions];
    }

    public int[][] getGrid() {
        return this.grid;
    }

    // Get and set interval
    public int getInterval() {
        return this.interval;
    }
    public void setInterval(int interval) {
        this.interval = interval;
    }

    // Method to set the Rules - 0 means no show, 1 means show
    public String setRules(int choice) {
        Scanner input = new Scanner(System.in);
        String rules = "\n1.\tBirth: A dead cell with exactly 3 live neighbors becomes a live cell." +
                "\n2.\tSurvival: A live cell with 2 or 3 live neighbors stays alive." +
                "\n3.\tDeath: In all other cases, a cell dies or remains dead.\n";

        if (choice == 1) {
            return rules;
        } else {
            return "";
        }

    }
    // Patttern Selection getter and setter
    public int getPatternSelection(){
        return this.patternSelection;
    }

    public void setPatternSelection(int patternSelection){
        this.patternSelection = patternSelection;
    }
    // Pattern Setter
    public void setPattern(int patternSelection) {
        if (patternSelection == 1) {
            // GLIDER PATTERN
            // create glider position
            int gliderPosition = dimensions / 2;

            // implement glider
            setGlider(grid, gliderPosition - 1);
        } else if (patternSelection == 2) {
            // HORIZONTAL LINE PATTERN
            // create line position
            int horizontalPosition = dimensions / 2;

            // implement horizontal line
            setHLine(grid, horizontalPosition, dimensions);
        } else if (patternSelection == 3) {
            // VERTICAL LINE PATTERN
            // create line position
            int verticalPostiion = dimensions / 2;

            // implement vertical line
            setVLine(grid, verticalPostiion - 1, dimensions);
        } else if (patternSelection == 4) {
            // CROSS PATTERN
            // create line position
            int crossPosition = dimensions / 2;

            // implement 4 corners
            setCross(grid, crossPosition - 1, dimensions);
        }
    }

    // Starting pattern setters
    static void setGlider(int grid[][], int x) {
        grid[x][x] = 1;
        grid[x - 1][x] = 1;
        grid[x][x + 1] = 1;
        grid[x + 1][x - 1] = 1;
        grid[x + 1][x + 1] = 1;
    }

    // creates horizontal line position
    static void setHLine(int grid[][], int y, int j) {
        for (int k = 0; k < j; k++) {
            grid[y][k] = 1;
        }
    }

    // creates vertical line position
    static void setVLine(int grid[][], int z, int j) {
        for (int p = 0; p < j; p++) {
            grid[p][z] = 1;
        }
    }

    // creates corner positions
    static void setCross(int grid[][], int s, int f) {
        // sets the horizontal line
        for (int t = 0; t < f; t++) {
            grid[s][t] = 1;
        }

        // sets the vertical line
        for (int w = 0; w < f; w++) {
            grid[w][s] = 1;
        }
    }


    // Return String header
    public String getHeader(){
        return this.header;
    }

    // Return pattern list
    public String getPatternList(){
        return this.patternList;
    }

    // Calculate and return the next grid based on 2d grid input
    public void calculateNextGeneration(int givenGrid[][]) {
        int[][] newGrid = new int[givenGrid[0].length][givenGrid[0].length];

        // goes through the grid
        for (int d = 0; d < givenGrid[0].length; d++) {
            for (int u = 0; u < givenGrid[0].length; u++) {

                // determines if there is an alive neighbor
                int aneigh = 0;
                for (int v = -1; v <= 1; v++) {
                    for (int b = -1; b <= 1; b++) {
                        if ((givenGrid[0].length > d + v && v + d >= 0) && (givenGrid[0].length > u + b && u + b >= 0)) {
                            aneigh = aneigh + givenGrid[v + d][b + u];
                        }
                    }
                }
                // cell needs to be taken out
                aneigh = aneigh - givenGrid[d][u];

                // rules of the game of life
                // death
                if ((givenGrid[d][u] == 1) && (aneigh < 2)) {
                    newGrid[d][u] = 0;

                    // death
                } else if ((givenGrid[d][u] == 1) && (aneigh > 3)) {
                    newGrid[d][u] = 0;

                    // birth
                } else if ((givenGrid[d][u] == 0) && (aneigh == 3)) {
                    newGrid[d][u] = 1;

                    // survival
                } else {
                    newGrid[d][u] = givenGrid[d][u];
                }
            }
        }
        this.grid = newGrid;
    }


}

