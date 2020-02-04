package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.Random;

public class Stepdefs {
    
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    

    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }    

    @Given("user with username {string} with password {string} is successfully created")
    public void newUserwithUserNameAndPasswordIsCreate(String username, String password) {
        newUserIsSelected();
        SignUpWith(username, password, password);        
        newUserIsCreated();
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click(); 
        element = driver.findElement(By.linkText("logout"));       
        element.click();
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithBadCredentialsIsTriedToBeCreated(String username, String password) {
        newUserIsSelected();
        SignUpWith(username, password, password);
        driver.get(baseUrl);
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }   
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAreGiven(String username, String password) {
        SignUpWith(username, password, password);
    }
    
    @When("a too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAreGiven(String username, String password) {
        SignUpWith(username, password, password);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndTooShortPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        SignUpWith(username, password, password);
    }

    @When("a valid username {string} and password {string} and non-matching password confirmation {string} are entered")
    public void nonMatchingPasswordConfirmationAreEntered(String username, String password, String passwordConfirm) {
        SignUpWith(username, password, passwordConfirm);
    }

    @When("a too short username {string} adn too short password {string} and matching password confirmation are entered")
    public void aTooShortUsernameAdnTooShortPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        logInWith(username, password);
    }
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("nonexistent username and password are given")
    public void nonexistentUsernameAndIncorrectPasswordAreGiven() {
        logInWith("username" + new Random().nextInt(), "password" + new Random().nextInt());
    }    

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("continue to application mainpage");
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String string) {        
        pageHasContent(string);
    }

    /*@When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    /*@Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }*/
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void SignUpWith(String username, String password, String passwordConfirm) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirm);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 

    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}

