package br.ce.wcaquino.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;


public class InserirContasSteps {
	
	private WebDriver driver;

	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", 
	    		"C:\\Users\\Leandro Pereira\\Downloads\\chromedriver2_41\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/login");
		driver.manage().window().maximize();
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String usuario) throws Throwable {
	    driver.findElement(By.id("email")).sendKeys(usuario);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String senha) throws Throwable {
	    driver.findElement(By.id("senha")).sendKeys(senha);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
	    driver.findElement(By.tagName("button")).click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, teste!", texto);
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
	    driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String conta) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(conta);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
	    driver.findElement(By.tagName("button")).click();
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}

	
}
