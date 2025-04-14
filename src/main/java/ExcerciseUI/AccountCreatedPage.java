package ExcerciseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {
    private WebDriver driver;


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement accountCreated() {
        return driver.findElement(By.xpath("//b"));
    }

    public boolean assertIsAccountIsCreatedIsDisplayed() {
        return accountCreated().isDisplayed();
    }
}


