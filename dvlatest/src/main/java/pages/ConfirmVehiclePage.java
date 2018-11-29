package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmVehiclePage extends  AbstractPage{

    @FindBy(xpath = "//span[@class='reg-mark']")
    WebElement regNumText;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/ul[1]/li[2]/span[2]/strong[1]")
    WebElement makeText;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/ul[1]/li[3]/span[2]/strong[1]")
    WebElement colourText;

    public WebElement getRegNumText() {
        return regNumText;
    }

    public WebElement getMakeText() {
        return makeText;
    }

    public WebElement getColourText() {
        return colourText;
    }

    public ConfirmVehiclePage getObjects(){
        return createPage(ConfirmVehiclePage.class);
    }
}
