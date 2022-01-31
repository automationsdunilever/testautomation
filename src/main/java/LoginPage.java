import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    public static WebDriver driver;
    By txtPhoneNumber = By.xpath("//input[@id='phone']");
    By txtPassword = By.xpath("//input[@id='sifre']");
    By btnGiris = By.xpath("//button[@id='btnSubmit']");

    public LoginPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ardas\\Documents/chromedriver.exe");
    }

    public void loginScreen() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://siparisdirekt.com/Home/Login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        send(txtPhoneNumber,"5494869017");
        send(txtPassword,"9017");
        click(btnGiris);
        click(By.xpath("//a[@class='cookieConsentOK']"));

    }





}
