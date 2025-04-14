package ExcerciseUI;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class FormRegistrationPage {

    private WebDriver driver;
    private static final Faker faker = new Faker();

    public FormRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    private WebElement formRegistrationTitle() {
        return driver.findElement(By.xpath("//h2[contains(@class, 'text-center')]/b[contains(text(), 'Enter Account')]"));
    }

    private WebElement genderMrItem() {
        return driver.findElement(By.xpath("//Input[@id='id_gender1']"));
    }

    private WebElement genderMrsItem() {
        return driver.findElement(By.xpath("//input[@id='id_gender2']"));
    }

    private WebElement nameField() {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }

    private WebElement emailField() {
        return driver.findElement(By.xpath("//input[@id='email']"));
    }

    public void verifyPreFilledNameAndEmail() {
        String nameValue = nameField().getAttribute("value");
        String emailValue = emailField().getAttribute("value");

        Assert.assertFalse(nameValue.isEmpty(), "Name field is empty, but it should be pre-filled!");
        Assert.assertFalse(emailValue.isEmpty(), "Email field is empty, but it should be pre-filled!");

        System.out.println("Name and Email fields are pre-filled correctly: " + nameValue + " | " + emailValue);
    }

    private WebElement passwordField() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public void enterRandomPasswordInPasswordField() {
        String randomPassword = faker.internet().password(8, 16, true, true, true);
        WebElement password = passwordField();
        scrollToElement(password);
        password.clear();
        password.sendKeys(randomPassword);
        System.out.println("Generated Password: " + randomPassword);
    }

    private WebElement dateOfBirthDay() {
        return driver.findElement(By.xpath("//select[@id='days']"));
    }

    private WebElement dateOfBirthMonth() {
        return driver.findElement(By.xpath("//select[@id='months']"));
    }

    private WebElement dateOfBirthYear() {
        return driver.findElement(By.xpath("//select[@id='years']"));
    }

    private WebElement newsLetterItem() {
        return driver.findElement(By.xpath("//input[@id='newsletter']"));
    }

    private WebElement receiveOffersItem() {
        return driver.findElement(By.xpath("//label[@for='optin']"));
    }

    private WebElement firstNameField() {
        return driver.findElement(By.xpath("//input[@id='first_name']"));
    }

    private WebElement lastNameField() {
        return driver.findElement(By.xpath("//input[@id='last_name']"));
    }

    private WebElement companyField() {
        return driver.findElement(By.xpath("//input[@id='company']"));
    }

    private WebElement address1Field() {
        return driver.findElement(By.xpath("//input[@id='address1']"));
    }

    private WebElement address2Field() {
        return driver.findElement(By.xpath("//input[@id='address2']"));
    }

    private WebElement countryField() {
        return driver.findElement(By.xpath("//select[@id='country']"));
    }

    private WebElement stateField() {
        return driver.findElement(By.xpath("//input[@id='state']"));
    }

    private WebElement cityField() {
        return driver.findElement(By.xpath("//input[@id='city']"));
    }

    private WebElement zipCodeField() {
        return driver.findElement(By.xpath("//input[@id='zipcode']"));
    }

    private WebElement mobileNumberField() {
        return driver.findElement(By.xpath("//input[@id='mobile_number']"));
    }

    public WebElement createAccountButton() {
        return driver.findElement(By.xpath("//button[@data-qa='create-account']"));
    }

    public boolean assertIsFormRegistrationPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(@class, 'text-center')]/b[contains(text(), 'Enter Account')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectTitleMrOrMrs(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            scrollToElement(genderMrItem());
            genderMrItem().click();
        } else if (title.equalsIgnoreCase("Mrs")) {
            scrollToElement(genderMrsItem());
            genderMrsItem().click();
        } else {
            throw new IllegalArgumentException("Invalid title: " + title);
        }
    }

    public void enterFirstNameInLastNameField(String firstName) {
        String randomFirstName = faker.name().firstName();
        WebElement field = firstNameField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomFirstName);
    }

    public void enterLastNameInLastNameField(String lastName) {
        String randomLastName = faker.name().lastName();
        WebElement field = lastNameField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomLastName);
    }

    public void enterCompanyInCompanyField() {
        String randomCompany = faker.company().name();
        WebElement field = companyField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomCompany);
    }

    public void enterRandomAddress1() {
        String randomAddress1 = faker.address().streetAddress();
        WebElement field = address1Field();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomAddress1);
        System.out.println("Generated Address 1: " + randomAddress1);
    }

    public void enterRandomAddress2() {
        String randomAddress2 = faker.address().secondaryAddress();
        WebElement field = address2Field();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomAddress2);
        System.out.println("Generated Address 2: " + randomAddress2);
    }

    public void enterRandomCity() {
        String randomCity = faker.address().city();
        WebElement field = cityField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomCity);
        System.out.println("Generated city: " + randomCity);
    }

    public void enterRandomState() {
        String randomState = faker.address().state();
        WebElement field = stateField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomState);
        System.out.println("Generated State: " + randomState);
    }

    public void enterRandomZipCode() {
        String randomZip = faker.address().zipCode();
        WebElement field = zipCodeField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomZip);
        System.out.println("Generated ZIP Code: " + randomZip);
    }

    public void enterRandomMobileNumber() {
        String randomPhoneNumber = faker.phoneNumber().cellPhone();
        WebElement field = mobileNumberField();
        scrollToElement(field);
        field.clear();
        field.sendKeys(randomPhoneNumber);
        System.out.println("Generated Mobile Number: " + randomPhoneNumber);
    }

    public void selectRandomCountry() {
        WebElement field = countryField();
        scrollToElement(field);
        Select select = new Select(field);
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size() - 1) + 1;
        select.selectByIndex(randomIndex);
        System.out.println("Selected Country: " + options.get(randomIndex).getText());
    }

    public void selectNewsLetter() {
        WebElement newsletter = newsLetterItem();
        scrollToElement(newsletter);
        if (!newsletter.isSelected()) {
            newsletter.click();
        }
    }

    public void selectReceiveOffersItem() {
        WebElement element = receiveOffersItem();
        scrollToElement(element);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void selectRandomDateOfBirthField() {
        scrollToElement(dateOfBirthDay());
        Select select = new Select(dateOfBirthDay());
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size() - 1) + 1;
        select.selectByIndex(randomIndex);
    }

    public void selectRandomDateOfBirthMonth() {
        scrollToElement(dateOfBirthMonth());
        Select select = new Select(dateOfBirthMonth());
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size() - 1) + 1;
        select.selectByIndex(randomIndex);
    }

    public void selectRandomDateOfBirthYear() {
        scrollToElement(dateOfBirthYear());
        Select select = new Select(dateOfBirthYear());
        List<WebElement> options = select.getOptions();
        int randomIndex = new Random().nextInt(options.size() - 1) + 1;
        select.selectByIndex(randomIndex);
    }
}
