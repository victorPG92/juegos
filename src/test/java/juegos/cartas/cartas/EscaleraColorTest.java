package juegos.cartas.cartas;

import org.junit.Test;

import juegos.cartas.cartas.mesas.Mano;
import juegos.cartas.cartas.poker.manos.NombreMano;
import juegos.cartas.cartas.poker.manos.fact.FactoriaMano;

public class EscaleraColorTest
{
	FactTestManos factTestManos= new FactTestManos();
	FactoriaMano factoriaMano= new FactoriaMano();
	
	
	@Test
	public void creaEscaleraColor() throws Exception {
		Mano manoEscaleraColor = factoriaMano.creaMano(factTestManos.creaEscaleraColor(), NombreMano.straight_flush);
		
		
	}
	@Test
	public void escaleraColorVSEscaleraColorBaja() throws Exception {
		
	}

}
