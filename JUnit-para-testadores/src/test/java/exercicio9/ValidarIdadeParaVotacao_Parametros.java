package exercicio9;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import votacao.Votacao;

@RunWith(Parameterized.class)
public class ValidarIdadeParaVotacao_Parametros {

	@Parameter(0) public String nome;
	@Parameter(1) public int anoDeNascimento;
	@Parameter(2) public String resultado;
	
	@Test
	public void validaObrigatoriedadeVoto() {
		assertEquals(resultado, Votacao.podeVotar(nome, anoDeNascimento));
		
	}
	
	@Parameters(name = "{0} | {1} | {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Maria"  , 2008, "Maria você não pode votar"},
			{"Rodrigo", 2007, "Rodrigo seu voto é facultativo"},
			{"João"   , 2006, "João seu voto é facultativo"},
			{"Carla"  , 2005, "Carla seu voto é obrigatório"},
			{"José"   , 1998, "José seu voto é obrigatório"},
			{"Ana"    , 1953, "Ana seu voto é obrigatório"},
			{"Pedro"  , 1946, "Pedro seu voto é facultativo"}
		});
	}
}
