package juegos.cartas.cartas.cartas.dom.dominios;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Dominio doble para las cartas valor palo
 * tiene un comparador para comparar esas cartas
 * 
 * lo logico es que el valor se compare pero el palo de igual
 * 
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
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
