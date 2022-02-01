import org.openqa.selenium.By;

public class AccountScreen extends BasePage{

    By iconBasket = By.xpath("//i[@title='Sepetim']");
    By totalPrice = By.xpath("//div[@class='total-price']//span[2]");
    By checkBoxAgreement = By.xpath("//div[@class='icheckbox_minimal']");
    By btnConfirmCart = By.xpath("//a[normalize-space()='Sepeti Onayla']");
    By btnConfirmDeliveryAddress = By.xpath("//a[normalize-space()='Teslimat Adresini Onayla']");
    By btnCancel = By.xpath("//div[@id='Tabbed1']//div//button[@type='button'][normalize-space()='×']");
    By btnPayAtTheDoor = By.xpath("//div[@id='btnCollapseDoor']");
    By btnPayAtTheDoorClose = By.xpath("//div[@id='PayAtTheDoor']//i[2]");
    By checkBoxCash = By.xpath("//span[contains(text(),'Kapıda nakit ödemek istiyorum')]");
    By checkBoxCard = By.xpath("//span[contains(text(),'Kapıda kredi kartı ile ödemek istiyorum')]");


    public void setGoToBasket() {
        click(iconBasket);

    }

    public void setBasketProductValidation() {
        scrollPageElement(drivers().findElement(By.xpath("//div[@class='product-list'][2]//div[@class='price-info']//span[2]")));
        String firstBasketProductGetValue = drivers().findElement(By.xpath("//div[@class='product-list'][1]//div[@class='price-info']//span[2]")).getText()
                .replace("Toplam Fiyat: ", "").replace(" TL", "").replace(",", ".");
        System.out.println(firstBasketProductGetValue);
        Double firstValue = Double.parseDouble(firstBasketProductGetValue);

        String secondBasketProductGetValue = drivers().findElement(By.xpath("//div[@class='product-list'][2]//div[@class='price-info']//span[2]")).getText()
                .replace("Toplam Fiyat: ", "").replace(" TL", "").replace(",", ".");
        System.out.println("second " + secondBasketProductGetValue);
        Double secondValue = Double.parseDouble(secondBasketProductGetValue);
        Double finalValue = firstValue + secondValue;
        System.out.println(finalValue);
        String totalPrice = drivers().findElement(By.xpath("//div[@class='total-price']//span[2]")).getText()
                .replace(" TL", "").replace(",", ".");
        System.out.println("totalprice " + totalPrice);
        Double doubleTotalPrice = Double.parseDouble(totalPrice);
        if (doubleTotalPrice != finalValue) {
            System.out.println("Fiyatlar Eşleşmiyor");

        }
        // Assert.assertEquals(doubleTotalPrice, finalValue);


    }

    public void setCheckAgreement() {
        scrollPageElement(drivers().findElement(By.xpath("//label[@class='form-label check-label']")));
        click(checkBoxAgreement);
    }

    public void setConfirmCart() {
        scrollPageElement(drivers().findElement(By.xpath("//a[normalize-space()='Sepeti Onayla']")));
        click(btnConfirmCart);

    }

    public void setConfirmDeliveryAddress() {
        scrollPageElement(drivers().findElement(By.xpath("//a[normalize-space()='Teslimat Adresini Onayla']")));
        click(btnConfirmDeliveryAddress);
    }

    public void setPopUpCancel() {
        click(btnCancel);
    }

    public void setPaymentMethodStock() {
        click(btnPayAtTheDoor);

    }
    public void setPaymentMethod() {
        click(btnPayAtTheDoorClose);

    }

    public void setCashOrCartPaymentValidation() throws InterruptedException {
        click(checkBoxCash);
        Thread.sleep(2000);
        String cashPaymentValueText = drivers().findElement(By.xpath("//div[@class='total-price']//span[2]")).getText()
                .replace(" TL", "").replace(",", ".");
        System.out.println(cashPaymentValueText);
        Double cashPayment = Double.parseDouble(cashPaymentValueText);

        click(checkBoxCard);
        Thread.sleep(2000);

        String cartPaymentValueText = drivers().findElement(By.xpath("//div[@class='total-price']//span[2]")).getText()
                .replace(" TL", "").replace(",", ".");
        System.out.println(cashPaymentValueText);
        Double cartPayment = Double.parseDouble(cashPaymentValueText);

        Double paymentDifference = cartPayment - cashPayment;
        System.out.println(paymentDifference);


    }

}
