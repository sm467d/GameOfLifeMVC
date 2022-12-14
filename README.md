# GameOfLifeMVC
Model-View-Controller Representation of Conway's Game of Life

University of Maryland Baltimore County
IS247 Paul Comitz 
Moroti Oyeyemi
Brian Tien
Game of Life Paper
This semester, we were tasked with creating a working simulation of Horton Conway’s Game of Life. Conway’s Game of Life is a simulated one-person game created by famous Cambridge mathematician Horton Conway. The game has 3 components; dead cells, live cells, and the rules. 
	The dead cells make up the board in which the game is viewed and are typically referred to as “dead cells”. The cells that make up the unique patterns are “live cells” and they evolve in elaborate patterns according to the same rules:
A dead cell with 3 neighbors alive becomes living
A live cell survives if it has either 2 or 3 living neighbors
A live cell with more than 3 or less than 2 neighbors dies


	The game typically starts with a “seed” or initial pattern, which gives way to a myriad of possibilities. For this assignment, we were given one to implement (the glider) but came up with another 4 we could successfully incorporate.
	Next, we had to use this information to generate a working game. On that note, the timeline for this assignment was rather linear. The two of us met every Wednesday after class to work on the project anywhere between 30 minutes and up to 2 hours. Using this time paired with individual, allocated work, we were able to finish all parts of the project with time to spare. 
	

When developing the code, we ran into many issues that forced us to change the scope of the project. We really wanted to incorporate JavaFX, but the learning &  implementation exceeded the realm of possibility for this assignment.
	Addressing scope, we also, as demonstrated during our presentation, created a spinning donut pattern which did take plenty of time to create. Still, unfortunately, we felt that it did not fit the criteria for the project so, although fun, it would likely be best just to leave it out. 
	
In developing the game, we aimed to utilize the Model-View-Controller (herein referred to as MVC) design pattern. This would allow us to separate parts of the program, making the code far more readable and debugging much quicker.
	In the MVC design pattern, there are 3 essential components that allow for the program to run accordingly. First is the model which is responsible for managing all the data, their queries, logical operations, and the like. For our code, all of our variables and objects (except the model & view in the controller class) were declared and housed in the model.
Next is the view, which is the graphical, user-facing component of the MVC design pattern. The view is responsible for generating the UI and literal display and is a vessel for program I/O operations. Typically a model has listeners and display interfaces as well. 
Last but most important is the controller, which is the “mastermind” behind a program. The controller is responsible for facilitating communication between the model and the view, as well as the actual implementation of them both. The controller routes commands and data controls between the model and the view, and in a perfect program, the main method would actually be housed here in the controller, but was not in this program, instead in a designated script so users could see clearly each of the processes running.
In order to ensure we could both use all the functions, we had to write documentation for them as we went along.
Model Documentation
	Variables (all user prompted):
int generations: The # of generations to calculate & display
int dimensions: The dimensions of the physical grid
int[][] grid: The literal grid object (2D array)
int interval: The time to sleep between generations
int patternSelection The user-selected pattern (of a prompted list)
String header: String header
String patternList: String representation of the pattern list
	Methods (mostly getters & setters, not included):
public String getWelcome() - Returns the “Welcome” String, which is first shown upon running the program
static void setPATTERN() - Alters the grid to create the user pattern
public void calculateNextGeneration(givenGrid[][]): calculates the next generation to display and changes the “grid” variable accordingly


View Documentation
Methods:
Listeners (Prompts the user and returns corresponding input):
public int dimensionListener(): 
public int ruleChoiceListener()
public int generationsListener()
public int intervalListener()
public int patternSelectionListener(String patternList)

Display (UI representation):
public void displayWelcome(String welcome)
public void displayRules(String rules)
public void displayGrid(int[][] grid)
public void displayGenerationHeader(String generationHeader)
public void displayGenerationTracker(int generation)


public void linebreak(): Prints an empty line to console



Controller Documentation (all methods represent a sequence between components of the program):
Objects:
	GOLModel model = new GOLModel();
  	GOLView view = new GOLView();
Methods (controls):
public void welcomeControl(): Displays the welcome string from model
public void rulesControl(): Uses view to prompt the user and updates the model
public void generationControl(): Get generations count from user and set corresponding model attribute
public void dimensionControl(): Prompts for dimensions and creates the model's grid
public void intervalControl() : Prompts for number of intervals and updates corresponding model attribute
public String patternControl(): Changes the current grid to a prompted pattern
public void displayParentControl(): Displays the parent generation (generation with initial pattern)
public void displayChildControl() : Displays the new generations

Finally, once we finished the code, we couldn’t decide between a “0” symbol, a “1”, or the asterisk many groups, as well as examples online would use. We decided, instead, to go with an “@” symbol, and we came about this while arguing the symbol with the most “white pixels” (more information in the presentation), but this was great information to have, as we implemented the symbol into our working code and the visuals were much more stunning and visible.

