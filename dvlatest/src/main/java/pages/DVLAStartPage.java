package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DVLAStartPage extends AbstractPage{

    @FindBy(linkText = "Start now")
    WebElement startNowButton;

    public DVLAStartPage clickStartNow(){
        startNowButton.click();
        return createPage(DVLAStartPage.class);
    }


}
