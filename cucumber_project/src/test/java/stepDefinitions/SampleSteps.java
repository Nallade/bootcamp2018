package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"(.*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
        }
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I am on page locator$")
    public void iAmOnPageLocator() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
        assertEquals("https://kristinek.github.io/test-sample/examples/loc",
                driver.getCurrentUrl());
    }

    @Then("^I should see a heading text$")
    public void iShouldSeeAHeadingText() throws Throwable {
        assertTrue(driver.findElement(By.id("heading_1")).isDisplayed());
        assertEquals("Heading 1",
                driver.findElement(By.xpath("//h2[1]")).getText());
    }

    @Then("^I should see a heading two text$")
    public void i_should_see_a_heading_two_text() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.id("heading_2")).isDisplayed());
        assertEquals("Heading 2 text",
                driver.findElement(By.xpath("//h2[2]")).getText());
    }

    @And("^I change age to (\\d+)$")
    public void iChangeAgeTo(int age) throws Throwable {
        String newAge = String.valueOf(age);
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(newAge);
    }

    @And("^I change name to \"([^\"]*)\"$")
    public void iChangeNameTo(String blabla) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(blabla);
    }

    @Given("^I am on task page$")
    public void iAmOnTaskPage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
        assertEquals("https://kristinek.github.io/test-sample/tasks/task1",
                driver.getCurrentUrl());
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(int arg0) throws Throwable {
        String number = String.valueOf(arg0);
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.xpath("//*[@type='button']")).click();
    }

    @Then("^I should see an error: \"([^\"]*)\"$")
    public void iShouldSeeAnError(String errorText) throws Throwable {
        assertEquals(errorText, driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^I am on task4 page$")
    public void iAmOnTask4Page() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @And("^I choose option Good$")
    public void iChooseOptionGood() throws Throwable {
        driver.findElement(By.cssSelector("[value=\"lang_sp\"]")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@value=\"good\"]")).click();
        System.out.println();
    }

    @Given("^I am on Action page$")
    public void iAmOnTheActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/act");
    }

    @And("^I entered number: (\\d+)$")
    public void iEnterNum(int num) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(String.valueOf(num));
    }

    @And("^I press result$")
    public void iPressResult() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^Message is seen: \"(.*)\"$")
    public void messageIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_number")).getText());
    }


    @Given("^I am on feedback page$")
    public void i_am_on_feedback_page() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @When("^I input name: ([^\"]*)$")
    public void i_input_name(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @When("^I select one language$")
    public void i_select_one_language() throws Throwable {
        WebElement selectLanguage = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        selectLanguage.click();
    }

    @When("^I select two languages$")
    public void i_select_two_languages() throws Throwable {
        WebElement selectLanguage1 = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        WebElement selectLanguage2 = driver.findElement(By.cssSelector(".w3-check[value='French'][type='checkbox'"));
        selectLanguage1.click();
        selectLanguage2.click();
    }

    @When("^I click send$")
    public void i_click_send() throws Throwable {
        driver.findElement(By.className("w3-blue")).click();
    }

    @When("^I click green button$")
    public void i_click_green_button() throws Throwable {
        driver.findElement(By.className("w3-green")).click();
    }
    @Then("^I see feedback: \"([^\"]*)\"$")
    public void i_see_feedback(String msgOneLanguage) throws Throwable {
        assertEquals(msgOneLanguage, driver.findElement(By.xpath("//div[@class=\"description\"][3]//p")).getText());
    }

    @Then("^I see notification: ([^\"]*)$")
    public void i_see_notification(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter data:$")
    public void i_enter_data(Map<String, String> valuesEnter) throws Throwable {
        for (Map.Entry<String, String> ent : valuesEnter.entrySet()) {
            driver.findElement(By.name(ent.getKey())).clear(); /*OR  driver.findElement(By.id("fb_" + ent.getKey())).clear();*/
            driver.findElement(By.name(ent.getKey())).sendKeys(ent.getValue());
        }
    }

    @Then("^I see text:$")
    public void i_see_text(Map<String, String> textEnter) throws Throwable {
        for (Map.Entry<String, String> ent : textEnter.entrySet()) {
            assertEquals(ent.getValue(), driver.findElement(By.id(ent.getKey())).getText());
        }
    }

    @Then("^I see text like this: \"(.*)\"$")
    public void i_see_text_like_this(String seetext) throws Throwable {
            assertEquals(seetext, driver.findElement(By.id("fb_thx")).getText());
    }


    @Given("^I am on task page jobs$")
    public void i_am_on_task_page_jobs() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task3");
    }

    @When("^I click add button$")
    public void i_click_add_button() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @When("^I enter person info:$")
    public void i_enter_person_info(Map<String, String> enterData) throws Throwable {
       for(Map.Entry<String, String> data : enterData.entrySet()) {
           driver.findElement(By.id(data.getKey())).clear();
           driver.findElement(By.id(data.getKey())).sendKeys(data.getValue());
       }
    }

    @Then("^I click other add button$")
    public void i_click_other_add_button() throws Throwable {
       driver.findElement(By.id("modal_button")).click();
    }

    @When("^I click edit button$")
    public void i_click_edit_button() throws Throwable {
        driver.findElement(By.className("editbtn")).click();
    }

    @Then("^I click cancel button$")
    public void i_click_cancel_button() throws Throwable {
        driver.findElement(By.cssSelector("#modal_button + *")).click();
    }

    @When("^I click delete$")
    public void i_click_delete() throws Throwable {
        driver.findElement(By.className("closebtn")).click();
    }

    @When("^I click reset button$")
    public void i_click_reset_button() throws Throwable {
        driver.findElement(By.cssSelector("#addPersonBtn + *")).click();
    }

    @Then ("^I check person on list$")
    public void i_check_person_on_list() throws Throwable {
        driver.findElement(By.id("person3")).isDisplayed();
        Thread.sleep(2000);
        assertEquals("Ann", driver.findElement(By.cssSelector("#person3 span:nth-child(3)")).getText());
        assertEquals("cook", driver.findElement(By.cssSelector("#person3 span:nth-child(5)")).getText());
    }

}
