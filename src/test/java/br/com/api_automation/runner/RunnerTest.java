package br.com.api_automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions (
		features = "src/test/resources/features",
		glue = { "br.com.api_automation.steps" },
		plugin = { "pretty", "html:target/cucumber-reports" },
		tags = {"not @ignore", ""})
public class RunnerTest { }
