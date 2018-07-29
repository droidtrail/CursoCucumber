package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features   = "src/test/resources/features/inserirConta.feature",
		glue       = "br.ce.wcaquino.steps",
		tags       = {"~@ignore"},
		plugin     = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets   = SnippetType.CAMELCASE,
		dryRun     = false,
		strict     = false	
		)
public class RunnerTest {

	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", 
	    "C:\\Users\\Leandro Pereira\\Downloads\\chromedriver2_41\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/login");
		driver.findElement(By.id("email")).sendKeys("teste123@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.findElement(By.linkText("Sair")).click();
		driver.quit();	
	}	
}
