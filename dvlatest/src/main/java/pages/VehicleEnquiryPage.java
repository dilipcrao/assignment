package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleEnquiryPage extends  AbstractPage {

    @FindBy(id = "Vrm")
    WebElement regNumberField;

    @FindBy(name = "Continue")
    WebElement continueButton;

    public VehicleEnquiryPage enterRegNumAndClickContinue(String regNum){
        regNumberField.clear();
        regNumberField.sendKeys(regNum);
        continueButton.click();
        return createPage(VehicleEnquiryPage.class);
    }
}
