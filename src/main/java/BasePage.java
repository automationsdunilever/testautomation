import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver drivers(){
        return LoginPage.driver;
    }

    public WebElement find(By locator){
        return drivers().findElement(locator);
    }

    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(drivers(),20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        find(locator).click();
    }

    public void send(By locator,String text){
        WebDriverWait wait = new WebDriverWait(drivers(),20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        find(locator).sendKeys(text);
    }

    public void scrollPageElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) drivers();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void sendKeys1(By locator, Keys text, String value, Keys text2){
        WebDriverWait wait = new WebDriverWait(drivers(),20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        find(locator).sendKeys(text ,value ,text2);

    }



}
