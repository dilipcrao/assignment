package dvlasearch.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import pages.ConfirmVehiclePage;
import pages.DVLAStartPage;
import pages.VehicleEnquiryPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVLASearchStepDef extends AbstractPage {

    private WebDriver driver;
    private DVLAStartPage dvlaStartPage;
    private VehicleEnquiryPage vehicleEnquiryPage;
    private ConfirmVehiclePage confirmVehiclePage;
    private Path path = Paths.get(""); // Points to the root directory of the current project
    private  String testDir = path.toAbsolutePath().toString()+"/src/test/resources/files/";// a Directory contains various test files
    private String filename = testDir+"VehicleDetails.csv";

    @Given("^I am a web user$")
    public void iAmAWebUser()  {
        setDriver();
        driver = getDriver();

    }

    @When("^I navigate to dvla website$")
    public void iNavigateToDvlaWebsite()  {
        driver.get(dvlaUrl);
        driver.manage().window().maximize();

    }

    @And("^I provide the registration number of a vehicle from a csv file$")
    public void iProvideTheRegistrationNumberOfAVehicleFromACsvFile() {
        Scanner input=null;
        File file = new File(filename);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        while (input.hasNextLine()){
            list.add(input.nextLine());
        }
        for(int i=0;i<list.size();i++){
            String currentLine = list.get(i);
            if(currentLine.contains("#"))
                continue;
            String [] currentLineValue = list.get(i).split(",");
            dvlaStartPage=createPage(DVLAStartPage.class);
            dvlaStartPage.clickStartNow();
            vehicleEnquiryPage=createPage(VehicleEnquiryPage.class);
            vehicleEnquiryPage.enterRegNumAndClickContinue(currentLineValue[0]);
            confirmVehiclePage = createPage(ConfirmVehiclePage.class);
            try {
                Assert.assertTrue("Error!, the value in the file for Make doesn't match as in the website", confirmVehiclePage.getMakeText().getText().equalsIgnoreCase(currentLineValue[1]));
                Assert.assertTrue("Error!, the value in the file for Colour doesn't match as in the website", confirmVehiclePage.getColourText().getText().equalsIgnoreCase(currentLineValue[2]));
                driver.get(dvlaUrl);
            }catch (AssertionError ae){
                log.error("Assertion failed!");
                quitDriver();
                ae.printStackTrace();
            }

            /*for(int j=0;j<currentLineValue.length;j++){
                System.out.println("value of field "+(j+1)+" is >>>> "+currentLineValue[j]);

            }*/
        }

    }

    @Then("^I should be able to verify the details of the vehicle as present in the csv file$")
    public void iShouldBeAbleToVerifyTheDetailsOfTheVehicleAsPresentInTheCsvFile() {
        quitDriver();

    }
}
