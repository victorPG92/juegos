package juegos.cartas.cartas.ordenar.comp;

import java.util.Comparator;


import juegos.cartas.cartas.cartas.Carta;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Compara cartas segun el palo
 * PERMITE IGUALES
 * @author victor
 *
 */
public class CompCartaPorColor implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) 
	{
		PaloFrances p1= carta1.getPalo();
		PaloFrances p2= carta2.getPalo();

		
		
		int r= Character.compare(p1.letr(), p2.letr());
		
		return r;
	}

}
