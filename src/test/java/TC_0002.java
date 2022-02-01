import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class TC_0002 {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BasketPage basketPage = new BasketPage();


    @Test
    public void negativeTest() throws InterruptedException {
        loginPage.loginScreen();
        homePage.myBasket();
        homePage.clickSubMenu();
        //homePage.addToBasketInStock();
        homePage.addToBasketNotInStock();
        basketPage.setGoToBasket();
        basketPage.setBasketProductValidation();
        basketPage.setCheckAgreement();
        basketPage.setConfirmCart();
        basketPage.setConfirmDeliveryAddress();
       // basketPage.setPaymentMethod();
        basketPage.setCashOrCartPaymentValidation();





    }
    @AfterMethod
    public void tearMethod(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            Allure.addAttachment("FAILED", new ByteArrayInputStream(((TakesScreenshot) BasePage.drivers()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}


