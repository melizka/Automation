package ExcerciseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, (10));
    }

    //elements
    private WebElement loginEmailAdressField() {
        return driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    }

    private WebElement loginPasswordField() {
        return driver.findElement(By.xpath("//input[contains(@data-qa, 'login-password')]"));
    }

    public void enterPassword(String userPassword) {
        WebElement passwordField = loginPasswordField();
        passwordField.clear();
        passwordField.sendKeys(userPassword);
    }

    private WebElement loginConfirmButton(){
        return driver.findElement(By.xpath("//form[contains(@action,'login')]/button[contains(@class, 'btn-default')]"));
    }

    private WebElement signUserNameField(){
        return driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
    }

    private WebElement signEmailAdressField(){
        return driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
    }

    private WebElement signUpButton(){
        return driver.findElement(By.xpath("//button[text()='Signup']"));
    }

    private WebElement uniqueElement(){
        return driver.findElement(By.xpath("//h2[@class='or']"));
    }


    //methods
    public void inputEmailInLoginEmailAddressField(String email) {
        loginEmailAdressField().sendKeys(email);
    }

    public void inputLoginPasswordField(String password) {
        loginPasswordField().sendKeys(password);
    }

    public void pressLoginConfirmButton() {
        loginConfirmButton().click();
    }

    public void inputNameInSignUserNameField(String name) {
        signUserNameField().sendKeys(name);
    }

    public void inputEmailInSignEmailAdress(String mail) {
        signEmailAdressField().sendKeys(mail);
    }

    public void pressSignUpButton() {
        signUpButton().click();
    }

    public boolean assertIsAuthorizationPageIsDisplayed() {
        return uniqueElement().isDisplayed();
    }
}


