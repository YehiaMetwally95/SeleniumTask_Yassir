package CucumberClassRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles"
        , glue = "CucumberStepDefinitions"
        , plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
        //, name = "Add Product to Cart"
        )

public class CucumberTestNGRunnerTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                // Dynamically adjust thread count
                return super.scenarios();
        }
}
