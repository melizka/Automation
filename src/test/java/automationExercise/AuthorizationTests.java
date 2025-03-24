package automationExercise;

import UI.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    public class AuthorizationTests {
    private WebDriver driver;
    private HomePage homePage;
    private AuthorizationPage authorizationPage;
    private FormRegistrationPage formRegistrationPage;
    private AccountCreatedPage accountCreatedPage;


        @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage =  new HomePage(driver);
        authorizationPage = new AuthorizationPage(driver);
        formRegistrationPage = new FormRegistrationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);

        }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSignUp() {
        
        String userName = "Yelyataa";
        String userEmail = "biha@example.com";

        homePage.openHomePageAutoinexercise();

        homePage.pressheaderMenuButton();

        Assert.assertTrue(authorizationPage.assertIsAuthorizationPageIsDisplayed());

        authorizationPage.inputNameInSignUserNameField(userName);
        authorizationPage.inputEmailInSignEmailAdress(userEmail);
        authorizationPage.pressSignUpButton();

        Assert.assertTrue(new FormRegistrationPage(driver).assertIsFormRegistrationPageDisplayed());
    }

        @Test
        public void testRegistration() {
            homePage.openHomePageAutoinexercise(); // Відкрити головну сторінку
            homePage.pressheaderMenuButton();

            Assert.assertTrue(authorizationPage.assertIsAuthorizationPageIsDisplayed(),
                    "Authorization page is not displayed!");

            // Ввести дані для реєстрації на першому етапі
            String userName = "Yаgfda";
            String userEmail = "mada@example.com";

            authorizationPage.inputNameInSignUserNameField(userName);
            authorizationPage.inputEmailInSignEmailAdress(userEmail);
            authorizationPage.pressSignUpButton();

            Assert.assertTrue(formRegistrationPage.assertIsFormRegistrationPageDisplayed(),
                    "Registration page is not displayed!");

            // Перевірка автозаповнення полів
            formRegistrationPage.verifyPreFilledNameAndEmail();

            // Заповнення решти полів форми
            formRegistrationPage.enterRandomPasswordInPasswordField();
            formRegistrationPage.selectRandomDateOfBirthField();
            formRegistrationPage.selectRandomDateOfBirthMonth();
            formRegistrationPage.selectRandomDateOfBirthYear();
            formRegistrationPage.selectTitleMrOrMrs("Mr"); // Або "Mrs"
            formRegistrationPage.selectNewsLetter();
            formRegistrationPage.selectReceiveOffersItem();
            formRegistrationPage.enterFirstNameInLastNameField("John");
            formRegistrationPage.enterLastNameInLastNameField("Doe");
            formRegistrationPage.enterCompanyInCompanyField();
            formRegistrationPage.enterRandomAddress1();
            formRegistrationPage.enterRandomAddress2();
            formRegistrationPage.selectRandomCountry();
            formRegistrationPage.enterRandomState();
            formRegistrationPage.enterRandomCity();
            formRegistrationPage.enterRandomZipCode();
            formRegistrationPage.enterRandomMobileNumber();

            formRegistrationPage.createAccountButton().click();

            System.out.println("Кнопку натиснуто!");

            // Додаткове очікування, щоб перевірити, чи сторінка відкривається
            WebDriverWait wait = new WebDriverWait(driver, (10));
            wait.until(ExpectedConditions.urlContains("account_created")); // Очікуємо зміну URL

            System.out.println("Current URL after clicking button: " + driver.getCurrentUrl());

            // Перевіряємо, чи відкрилася сторінка створення акаунта
            AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
            Assert.assertTrue(accountCreatedPage.assertIsAccountIsCreatedIsDisplayed(),
                    "Account Created page is NOT displayed!");

            System.out.println("Registration test passed successfully!");
        }

    @Test
    public void testLogin() {
        String userEmail = "bikita@example.com";
        String userPassword = "password123";

        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        LogOutPage logOutPage = new LogOutPage(driver);

        homePage.openHomePageAutoinexercise();
        homePage.pressheaderMenuButton();

        Assert.assertTrue(authorizationPage.assertIsAuthorizationPageIsDisplayed(),
                "Authorization page is not displayed");

        authorizationPage.inputEmailInLoginEmailAddressField(userEmail);
        authorizationPage.enterPassword(userPassword);
        authorizationPage.pressLoginConfirmButton();

        //  Додаємо очікування, щоб дочекатися, поки кнопка Logout з'явиться
        WebDriverWait wait = new WebDriverWait(driver, (10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));

        Assert.assertTrue(logOutPage.assertIsLogOutPageIsDisplayed(),
                "Login failed, logout page is not displayed");
    }

}


