package steps;

import pages.InputComponentPage;

public class InputDataSteps {
    InputComponentPage enter = new InputComponentPage();

    public void inputCorrectAllData(int age, int weight, int growth) {
        enter.enterDataFieldAge(age)
                .enterDataFieldWeight(weight)
                .enterDataFieldGrowth(growth)
                .getCalculate();
    }
}
