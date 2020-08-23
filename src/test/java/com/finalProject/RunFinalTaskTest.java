package com.finalProject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        stepNotifications = true,
        tags = "@ContactCustomerService",
        features = "src/test/resources/",
        glue = {"com.finalProject.steps",
                "com.finalProject.hook"
        }
)

public class RunFinalTaskTest {
}
