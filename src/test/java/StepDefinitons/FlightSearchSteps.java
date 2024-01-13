package StepDefinitons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
public class FlightSearchSteps {
    private final WebDriver driver = new ChromeDriver();

    @Given("the user is on the flight search page")
    public void the_user_is_on_the_flight_search_page() {
        driver.get("https://flights-app.pages.dev/");
    }

    @When("the user enters the same departure and destination locations")
    public void the_user_enters_the_same_departure_and_destination_locations() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));

        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Istanbul");
        toInput.submit();
    }

    @Then("an error should be displayed")
    public void an_error_should_be_displayed() {
        // Assert that an error message is displayed
        // This will depend on how the error is displayed in the application
    }

    @When("the user searches for flights from Istanbul to Los Angeles")
    public void the_user_searches_for_flights_from_istanbul_to_los_angeles() {
        WebElement fromInput = driver.findElement(By.name("from"));
        WebElement toInput = driver.findElement(By.name("to"));

        fromInput.clear();
        toInput.clear();
        fromInput.sendKeys("Istanbul");
        toInput.sendKeys("Los Angeles");
        toInput.submit();
    }

    @Then("the listed flights count should match the found items count")
    public void the_listed_flights_count_should_match_the_found_items_count() {
        // Wait for the page to load and the count to be displayed
        // Check that the count matches the number of displayed flights
    }
}
