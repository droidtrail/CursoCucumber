package br.ce.wcaquino.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.servicos.AlguelService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;


public class AlugarFilmeSteps {
	
	private Filme filme;
	private AlguelService aluguel = new AlguelService();
	private NotaAluguel nota;
	private String erro;
	
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		
		filme = new Filme();
		filme.setEstoque(arg1);
	    
	}

	@Dado("^que o preço do aluguel seja de R\\$ (\\d+)$")
	public void queOPreçoDoAluguelSejaDeR$(int arg1) throws Throwable {
	    
		filme.setAluguel(arg1);
		
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
	    try {
	    	
	    	nota = aluguel.alugar(filme);
	    	
	    }catch (RuntimeException e) {
	    	
			erro = e.getMessage();
			
		}
			
	}

	@Então("^o preço do aluguel será de R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráDeR$(int arg1) throws Throwable {
		
		Assert.assertEquals(arg1, nota.getPreco());
	    
	}

	@Então("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
	    
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Date dataRetorno = nota.getDataEntrega();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataRetorno);
		
		Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
		
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
	    
		Assert.assertEquals(arg1, filme.getEstoque());
		
	}
	
	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
	 
		Assert.assertEquals("Filme sem estoque", erro);
	}
}
