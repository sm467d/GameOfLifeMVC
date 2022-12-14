import java.util.Scanner;

public class GOLController {
    GOLModel model = new GOLModel();
    GOLView view = new GOLView();

    // display welcome string from model
    public void welcomeControl()
    {
        view.displayWelcome(model.getWelcome());
    }

    // Uses the view to prompt the user and updates the model
    public void rulesControl()
    {
        view.displayRules(model.setRules(view.ruleChoiceListener()));
    }

    // Get generations count from user and set corresponding model attribute
    public void generationControl()
    {
        model.setGenerations(view.generationsListener());
    }

    // Prompts for dimensions and creates the model's grid
    public void dimensionControl()
    {
        model.setGrid(view.dimensionListener());
    }

    // Prompts for number of intervals and updates corresponding model attribute
    public void intervalControl()
    {
        model.setInterval(view.intervalListener());
    }

    // Changes the current grid to a prompted pattern
    public String patternControl()
    {
        model.setPatternSelection(view.patternSelectionListener(model.getPatternList()));
        if (model.getPatternSelection() == 5) {
            return "end";
        }

        else
            model.setPattern(model.getPatternSelection());
        return "cont";

    }

    // Displays the parent generation (generation with first pattern)
    public void displayParentControl()
    {
        view.displayGenerationHeader(model.getHeader());
        view.displayGrid(model.getGrid());
        view.linebreak();
    }

    // Displays the new generations
    public void displayChildControl() throws Exception
    {
        for(int i = 0; i < model.getGenerations(); i++)
            {
                Thread.sleep(model.getInterval());
                model.calculateNextGeneration(model.getGrid());
                view.displayGenerationTracker(i);
                view.displayGrid(model.getGrid());
                view.linebreak();

            }

    }


}
 

