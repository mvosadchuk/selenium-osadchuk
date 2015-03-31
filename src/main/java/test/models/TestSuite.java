package test.models;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class TestSuite {
    public String name = "Test Suite Name [mvo]";
    public String details = "Details";

    public TestSuite (String name, String details)
    {
        this.name = new String(name);
        this.details = new String(details);
    }
}
