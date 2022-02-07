import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class HomePage extends BasePage {
    By iconBasket = By.xpath("//i[@title='Sepetim']");
    By removeBasket = By.xpath("//span[@onclick='deleteAllBasketItems()']");
    By btnYes = By.xpath("//button[normalize-space()='Evet']");
    By moveToBeautyCategory = By.xpath("//li//a[contains(text(),'GÜZELLİK & KİŞİSEL BAKIM')]");
    By btnAxe = By.xpath("//a[contains(text(),'AXE')]");
    By btnHomeCare = By.xpath("//span[contains(text(),'ÇAMAŞIR & EV BAKIM')]");
    By searchBox = By.xpath("//input[@id='mainSearch']");
    By iconSearch = By.xpath("//button[normalize-space()='ARA']");
    By addBasket = By.xpath("//button[normalize-space()='Sepete Ekle']");
    By valueArea = By.xpath("//input[@class='piece']");
    By addProductIconBasket = By.xpath("//body//div//button[3]");


    public void myBasket() {

        String basketValue = drivers().findElement(By.xpath("//em[@id='sepetCount']")).getText().replace("(", "").replace(")", ""); //replacement = parantezi boşlukla değiştir.

        System.out.println(basketValue);
        int intBasketValue = Integer.parseInt(basketValue);
        if (intBasketValue != 0) {
            click(iconBasket);
            click(removeBasket);
            click(btnYes);

        }


    }

    public void clickSubMenu() throws InterruptedException {

        Thread.sleep(2000);

        WebElement mainMenu = find(By.xpath("//li[@class='dropdown yamm-fw visible-lg-inline-block visible-md-inline-block']/a[contains(text(), 'ÇAMAŞIR & EV BAKIM')]/.."));
        Actions actions = new Actions(drivers());

        actions.moveToElement(mainMenu);

        WebElement subMenu = find(By.xpath("//a/b[contains(text(), 'ÇAMAŞIR & EV BAKIM')]"));

        actions.moveToElement(subMenu);

        actions.click().build().perform();

    }

    public void addToBasketInStock() throws InterruptedException {
        List<WebElement> products = drivers().findElements(By.xpath("//div[@style='color:#00beff;white-space:nowrap;']/../.."));

        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            products.get(i).findElement(By.xpath(".//button[@class='secondary-button add-basket']")).click();
            products.get(i).findElement(By.xpath(".//button[@class='action-button plus']")).click();
            products.get(i).findElement(By.xpath(".//button[@class='add-to-basket']")).click();
        }
    }

    public void addToBasketNotInStock() throws InterruptedException {
        List<WebElement> products = drivers().findElements(By.xpath("//div[@style='color:red;white-space:nowrap;']/../.."));

        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            products.get(i).findElement(By.xpath(".//button[@class='secondary-button add-basket']")).click();
            products.get(i).findElement(By.xpath(".//button[@class='action-button plus']")).click();
            products.get(i).findElement(By.xpath(".//button[@class='add-to-basket']")).click();
            products.get(i).findElement(By.xpath(".//button[@class='add-to-basket']")).click();
        }
        Thread.sleep(1000);
    }
}


