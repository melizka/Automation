package ExcerciseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement headerMenuButtons(){
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }

    public void pressheaderMenuButton() {
        headerMenuButtons().click();
    }

    public void openHomePageAutoinexercise() {
        driver.get("https://www.automationexercise.com/");
    }
}
