package juegos.cartas.cartas.cartas.dom.fact;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * factoria que crea dominio valor palo
 * @author victor
 *
 * @param <V>
 * @param <P>
 * @param <C>
 */
public abstract class FactDominioDobleVP <V,P,C extends ICartaNumeroPalo<V,P>>
implements FactDominioDoble<V, P, C>
{
	
	public abstract Dominio<V> getDominioNumerico();
	
	public abstract Dominio<P> getDominioPalos();
	
	public DominioValorPalo<V, P, C> creaDominioVP()
	{
		return new DominioValorPalo<>		
		(
			getDominioNumerico(), 
			getDominioPalos()
		);
	}

}
