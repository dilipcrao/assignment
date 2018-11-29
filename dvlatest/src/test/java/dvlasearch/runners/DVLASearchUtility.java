package dvlasearch.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/dvlasearch.feature",
        glue = {"dvlasearch/steps"},
        plugin={"pretty","html:target/cucumber"}
)
public class DVLASearchUtility {
}
