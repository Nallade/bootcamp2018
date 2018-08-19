package stepDefinitions;


import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolvitaSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public SolvitaSteps() {
        this.driver = Hooks.driver;
        this.wait=Hooks.wait;
    }

    @Given("^I am logged in$") /*written by Vanda and few of my changes - added 2 last lines*/
    public void iAmLoggedIn() throws Throwable {
        driver.get("http://192.168.8.127:81/wordpress/wp-login.php?redirect_to=http%3A%2F%2F192.168.8.124%3A81%2Fwordpress%2Fwp-admin%2F&reauth=1");
        WebElement usernameField=driver.findElement(By.id("user_login"));
        WebElement passwordField=driver.findElement(By.id("user_pass"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
        usernameField.clear();
        usernameField.sendKeys("USER");
        passwordField.clear();
        passwordField.sendKeys("admin");
        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click();
    }

    @And("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("http://192.168.8.127:81/wordpress/wp-admin/admin.php?page=ninja-forms");
    }

    @And("^I click on AddNew button$")
    public void i_click_on_AddNew_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action button")));
        driver.findElement(By.cssSelector(".action button")).click();
    }

    @Then("^I see Contact Us, Event Registration, Quote Request$")
    public void i_see_Contact_Us_Event_Registration_Quote_Request() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Contact')]")));
        assertTrue(driver.findElement(By.xpath("//a[contains(.,'Contact')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//a[contains(.,'Event')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//a[contains(.,'Quote')]")).isDisplayed());
    }

    private void checkLabels(List<WebElement> fields, boolean[] requiredExpectations) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        assertEquals(requiredExpectations.length, fields.size());
        for (int i = 0; i < fields.size(); i++) {
            jse.executeScript("arguments[0].scrollIntoView(true);", fields.get(i));
            assertEquals("name"+ fields.get(i).getText(),requiredExpectations[i], fields.get(i).getText().contains("*"));
        }
    }

    @When("^I click on Contact Us label$")
    public void i_click_on_Contact_Us_label() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Contact')]")));
        driver.findElement(By.xpath("//a[contains(.,'Contact')]")).click();
    }

    @Then("^I see contact fields and check if mandatory$")
    public void i_see_contact_fields_and_check_if_mandatory() throws Throwable {
        List <WebElement> contactFields = driver.findElements(By.className("nf-field-label"));
        boolean[] requiredExpectations = {true, true, true, false};
        checkLabels(contactFields, requiredExpectations);
    }

    @When("^I click on Quote Request label$")
    public void i_click_on_Quote_Request_label() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Quote')]")));
        driver.findElement(By.xpath("//a[contains(.,'Quote')]")).click();
    }

    @Then("^I see quote fields and check if mandatory$")
    public void i_see_quote_fields_and_check_if_mandatory() throws Throwable {
        List <WebElement> quoteFields = driver.findElements(By.className("nf-field-label"));
        boolean[] requiredExpectations = {false, true, true, false, true, false, false, false, false, false, false, false, false, false, false};
        checkLabels(quoteFields, requiredExpectations);
    }

    @When("^I click on Event Registration label$")
    public void i_click_on_Event_Registration_label() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Event')]")));
        driver.findElement(By.xpath("//a[contains(.,'Event')]")).click();
    }

    @Then("^I see event fields and check if mandatory$")
    public void i_see_event_fields_and_check_if_mandatory() throws Throwable {
        List <WebElement> eventFields = driver.findElements(By.className("nf-field-label"));
        boolean[] requiredExpectations = {false, false, true, true, true, true, false, true, true, true, false, false, false};
        checkLabels(eventFields, requiredExpectations);
    }

    @And("^I click on plus button$")
    public void i_click_on_plus_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Name')]")));
        driver.findElement(By.cssSelector(".nf-master-control")).click();
    }

    @And("^I click additional field$")
    public void i_click_additional_field() throws Throwable {
        driver.findElement(By.cssSelector(".nf-field-type-button+*")).click();
    }

    @And("^I click on done button$")
    public void i_click_on_done_button() throws Throwable {
        driver.findElement(By.cssSelector(".nf-close-drawer")).click();
    }

    @Then("^I see additional field$")
    public void i_see_additional_field() throws Throwable {
        assertTrue(driver.findElement(By.xpath("//span[contains(.,'Date')]")).isDisplayed());
    }

    @And("^I click duplicate button$")
    public void i_click_duplicate_button() throws Throwable {
        Actions action = new Actions(driver);
        WebElement editSettings = driver.findElement(By.cssSelector(".nf-edit-settings"));
        action.moveToElement(editSettings).moveToElement(driver.findElement(By.cssSelector(".nf-duplicate"))).click().build().perform();
    }

    @Then("^I see duplicate field$")
    public void i_see_duplicate_field() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Tell us about your project')]")));
        assertTrue(driver.findElement(By.xpath("//span[contains(.,' Copy')]")).isDisplayed());
    }

    @And("^I click delete button$")
    public void i_click_delete_button() throws Throwable {
        Actions action = new Actions(driver);
        WebElement editSettings = driver.findElement(By.cssSelector(".nf-edit-settings"));
        action.moveToElement(editSettings).moveToElement(driver.findElement(By.cssSelector(".nf-delete"))).click().build().perform();
    }

    @Then("^I do not see deleted field$")
    public void i_do_not_see_deleted_field() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Divider')]")));
        assertTrue(driver.findElements(By.xpath("//span[contains(.,'Event Intro Description')]")).size()<1);
    }

    @And("^I click on edit button$")
    public void i_click_on_edit_button() throws Throwable {
        driver.findElement(By.cssSelector(".nf-edit-settings")).click();
    }

    @And("^I change label info$")
    public void i_change_label_info() throws Throwable {
       WebElement label = driver.findElement(By.id("label"));
       String newName = "Name and Surname";
       label.clear();
       label.sendKeys(newName);
    }

    @Then("^I see label with changed info$")
    public void i_see_label_with_changed_info() throws Throwable {
        assertEquals("Name and Surname *", driver.findElement(By.xpath("//span[contains(.,'Name')]")).getText());
    }

    @And("^I click on changes button$")
    public void i_click_on_changes_button() throws Throwable {
        driver.findElement(By.cssSelector(".dashicons-backup")).click();
    }

    @And("^I click on undo button$")
    public void i_click_on_undo_button() throws Throwable {
        driver.findElement(By.xpath("//a[contains(., 'Undo All')]")).click();
    }

    @Then("^I see original fields$")
    public void i_see_original_fields() throws Throwable {
        List <WebElement> contactFields = driver.findElements(By.className("nf-field-label"));
        ArrayList <String> expectedNames = new ArrayList<String>(Arrays.asList("Name *", "Email *", "Message *", "Submit"));
        for (int i = 0; i < contactFields.size(); i++) {
            assertEquals(expectedNames.get(i), contactFields.get(i).getText());
        }
    }

    @And("^I click on publish button$")
    public void i_click_on_publish_button() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(., 'PUBLISH')]")).click();
    }

    @Then("^I see changes$")
    public void i_see_changes() throws Throwable {
        driver.findElement(By.cssSelector(".preview")).click();
        Thread.sleep(2000);
        for(String winHandle:driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("nf-field-label")));
        assertEquals("Name and Surname *", driver.findElement(By.className("nf-field-label")).getText());
    }
}