package juegos.cartas.cartas.cartas.dom;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;

public class DominioValorPalo<V,P> //extends Comparable<V>,P>  
{
	
	private Dominio<V> domValor;
	private Dominio<V> domPalo;
	
	private Comparator<CartaNumeroPalo<V, P>> comparadorCartasValoracion;
	
	public DominioValorPalo(Dominio<V> domValor, Dominio<V> domPalo) {
		super();
		this.domValor = domValor;
		this.domPalo = domPalo;
	}
	
	
	
	
	
	
}
