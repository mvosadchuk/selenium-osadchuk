package test.models;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class TestStep {
    public String actions = "Open some page";
    public String expectedResult = "The page is opened";

    public TestStep(String actions, String expectedResult)
    {
        this.actions = actions;
        this.expectedResult = expectedResult;
    }
}
