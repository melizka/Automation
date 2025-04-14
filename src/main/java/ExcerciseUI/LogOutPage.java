package ExcerciseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    private WebDriver driver;

    private By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean assertIsLogOutPageIsDisplayed() {
        try {
            WebElement element = driver.findElement(logoutButton);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
