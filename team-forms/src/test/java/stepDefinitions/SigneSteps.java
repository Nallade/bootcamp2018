package stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SigneSteps {
    private WebDriver driver;

    public SigneSteps() {
        this.driver = Hooks.driver;
    }

    //here write some code

}
