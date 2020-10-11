package juegos.cartas.cartas.ordenar.comp;

import java.util.Comparator;


import juegos.cartas.cartas.cartas.CartaFrancesaOld;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Compara cartas segun el palo
 * PERMITE IGUALES
 * @author victor
 *
 */
public class CompCartaPorColor implements Comparator<CartaFrancesaOld> {

	@Override
	public int compare(CartaFrancesaOld carta1, CartaFrancesaOld carta2) 
	{
		PaloFrances p1= carta1.getPalo();
		PaloFrances p2= carta2.getPalo();

		
		
		int r= Character.compare(p1.letr(), p2.letr());
		
		return r;
	}

}
