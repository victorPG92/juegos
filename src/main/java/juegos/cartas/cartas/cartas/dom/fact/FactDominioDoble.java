package juegos.cartas.cartas.cartas.dom.fact;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

public interface FactDominioDoble <V,P,C extends ICartaNumeroPalo<V,P>>
{
	
	public DominioValorPalo<V, P, C> creaDominioVP();

}
