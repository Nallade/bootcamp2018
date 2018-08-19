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


public class VandaSteps {

    private WebDriver driver;

    public VandaSteps() {
        this.driver = Hooks.driver;
    }
    //here i`ll write steps
    @Given("^I am logged in the application$")
    public void iAmLoggedInTheApplication() throws Throwable {
        driver.get("http://192.168.8.124:81/wordpress/wp-login.php?redirect_to=http%3A%2F%2F192.168.8.124%3A81%2Fwordpress%2Fwp-admin%2F&reauth=1");
        WebElement usernameField=driver.findElement(By.id("user_login"));
        WebElement passwordField=driver.findElement(By.id("user_pass"));
        usernameField.clear();
        usernameField.sendKeys("USER");
        passwordField.clear();
        passwordField.sendKeys("admin");
        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click();
    }
}
