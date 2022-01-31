import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class TC_0001 {

    String firstProductId = "70007538";
    String secondProductId = "68174113";
    String thirdProductId= "68488509";

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginScreen();
        HomePage homePage = new HomePage();
        homePage.myBasket();
        Assert.assertTrue(false);
        homePage.clickSubMenu();
        homePage.addToBasketInStock();
        homePage.addToBasketNotInStock();
    }

    @AfterMethod
    public void tearMethod(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            Allure.addAttachment("FAILED", new ByteArrayInputStream(((TakesScreenshot) BasePage.drivers()).getScreenshotAs(OutputType.BYTES)));
        }
    }
    @AfterClass
    public void tearDown() {
        BasePage.drivers().close();
    }
}
