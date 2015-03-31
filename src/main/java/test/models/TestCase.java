package test.models;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class TestCase {
    public String name = "Test Case";
    public String summary = "Some Summary for a Test Case.";
    public String preconditions = "Some preconditions for a Test Case.";

    public TestCase(String name, String summary, String preconditions)
    {
        this.name = new String(name);
        this.summary = new String(summary);
        this.preconditions = new String(preconditions);
    }
}
