package juegos.cartas.cartas.ordenar.comp;

import java.util.Comparator;


import juegos.cartas.cartas.cartas.CartaFrancesaOld;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Compara cartas segun el palo
 * PERMITE IGUALES
 * @author victor
 *
 */
public class CompCartaPorColorYNumero<C extends CartaNumeroPalo<N, P>,N,P> implements Comparator<C> {

	private  CompCartaPorColor compColor= new CompCartaPorColor();
	private CompCartaPorNumero compNumero= new CompCartaPorNumero();
	
	@Override
	public int compare(C carta1, C carta2) 
	{
		int r= compColor.compare(carta1, carta2);
		
		if(r==0)
			r=compNumero.compare(carta1, carta2);
		
		return r;
	}

}
