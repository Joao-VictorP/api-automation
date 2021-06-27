package br.com.api_automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
		glue = {"br.com.api_automation.steps"},
		features = "src/test/resources/features")
public class RunnerTest { }
