public class Script
{
    public static void main(String[] args) throws Exception {
        for(; ;) {
            try {
                GOLController controller = new GOLController();

                controller.welcomeControl();

                controller.rulesControl();

                controller.generationControl();

                controller.dimensionControl();

                controller.intervalControl();

                if (controller.patternControl() == "end")
                    controller.displayParentControl();
                controller.displayChildControl();
            } catch (Exception exep)
            {
                exep.printStackTrace();
            } finally {
                System.out.println("\t\t\t\t\t@* Game of Life Ended *@\n");
            }



        }
    }
}

