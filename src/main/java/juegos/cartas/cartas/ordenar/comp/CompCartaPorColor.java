package juegos.cartas.cartas.ordenar.comp;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;

/**
 * Compara cartas segun el palo
 * PERMITE IGUALES
 * @author victor
 *
 */
public class CompCartaPorColor<C extends CartaNumeroPalo<N, P>,N,P> implements Comparator<C> {

	Dominio<P> domPalo;
	@Override
	public int compare(C carta1, C carta2) 
	{
		
		P p1= carta1.getPalo();
		P p2= carta2.getPalo();

		if(p1==p2)
			return 0;
	
		int i1=domPalo.indexOf(p1);
		int i2=domPalo.indexOf(p2);
		
		return Integer.compare(i1, i2);
		
	//	int r= Character.compare(p1.letr(), p2.letr());
		
		//return r;
	}

}
