package juegos.cartas.cartas.ordenar.comp;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Compara cartas segun el valor
 * @author victor
 *
 */
public class CompCartaPorNumero<C extends CartaNumeroPalo<Integer, P>,P> implements Comparator<C> {

	@Override
	public int compare(C carta1, C carta2) 
	{
		int n1=carta1.getNumero();
		int n2=carta2.getNumero();
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
	}

}
