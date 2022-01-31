import org.openqa.selenium.By;

public class AccountScreen extends BasePage{

   By checkBoxDilan = By.xpath("//span[contains(text(),'Dilan Sans Oyunları Butık G... - 00086498')]");
   By btnSubmit = By.cssSelector("button[type='submit']");





    public void customerSelect(){
        click(checkBoxDilan);
        click(btnSubmit);
    }


}
