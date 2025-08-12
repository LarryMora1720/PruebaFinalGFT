package demoqa.org.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "demoqa.org.stepdefinitions",
        tags = "@RegisterDemoQA", plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class DemoQaRunner {
}


