package steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import classe.Somar;

public class SomarSteps {

	private Somar somar;

	@Given("um somador é criado")
	@Aliases(values = { "um somador é instanciado" })
	public void umSomadorECriado() {
		somar = new Somar();
	}

	@When("eu adiciono $a a $b")
	public void euAdicionoDoisNumeros(int a, int b) {
		somar.adicionar(a, b);
	}

	@Then("o resultado deve ser $c")
	public void oResultadoDeveSer(int c) {
		assertEquals(somar.getResultado(), c);
	}

}
