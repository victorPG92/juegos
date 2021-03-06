package juegos.cartas.cartas;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import juegos.cartas.cartas.cartas.CartaFrancesaOld;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.mazos.fact.FactMazoConcretoEnums;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class BarajaFrancesaFactTest
{
	
	@Test
	void testCrearBaraja() throws Exception {
		
		MazoGen<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances> mazo = new FactMazoConcretoEnums().crearBarajaFrancesa();
		
		Assert.assertNotNull(mazo);
	}

}
