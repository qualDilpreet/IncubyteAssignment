package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "D:/MyMavenProject/InCubyteAssignment/src/test/java/features",
        glue = "StepDefination",
        plugin = {"pretty", "html:target/cucumber-reports"}

)
public class TestRunner {



}