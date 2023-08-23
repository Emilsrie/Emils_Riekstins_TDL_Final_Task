import common.TestBase;
import org.testng.annotations.Test;

public class Task2 extends TestBase {
    @Test
    public void test1() {
        System.out.println("url: " + getConfig().getUrl());
        System.out.println("environment: " + getConfig().getEnvironment());
        System.out.println("name: " + getConfig().getName());
        System.out.println("surname: " + getConfig().getSurname());
    }
}