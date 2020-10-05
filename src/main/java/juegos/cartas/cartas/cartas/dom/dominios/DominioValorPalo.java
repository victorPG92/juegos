package juegos.cartas.cartas.cartas.dom.dominios;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.alias.ParToString;
import juegos.cartas.cartas.cartas.dom.alias.ParToStringEsp;

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
	private Dominio<P> domPalo;
	
	private Comparator<CartaNumeroPalo<V, P>> comparadorCartasValoracion;
	
	ParToString parToString= new ParToStringEsp();
	
	public DominioValorPalo(Dominio<V> domValor, Dominio<P> domPalo) {
		super();
		this.domValor = domValor;
		this.domPalo = domPalo;
	}

	public DominioValorPalo(Dominio<V> domValor, Dominio<P> domPalo,
			Comparator<CartaNumeroPalo<V, P>> comparadorCartasValoracion) {
		super();
		this.domValor = domValor;
		this.domPalo = domPalo;
		this.comparadorCartasValoracion = comparadorCartasValoracion;
	}
	
	
	public String toString(CartaNumeroPalo<V, P> carta)
	{
		return parToString.toString(domValor.toString(carta.getNumero()),
				domPalo.toString(carta.getPalo()));	
	}
	

	public final Dominio<V> getDomValor() {
		return domValor;
	}

	public final void setDomValor(Dominio<V> domValor) {
		this.domValor = domValor;
	}

	public final Dominio<P> getDomPalo() {
		return domPalo;
	}

	public final void setDomPalo(Dominio<P> domPalo) {
		this.domPalo = domPalo;
	}

	public final Comparator<CartaNumeroPalo<V, P>> getComparadorCartasValoracion() {
		return comparadorCartasValoracion;
	}

	public final void setComparadorCartasValoracion(Comparator<CartaNumeroPalo<V, P>> comparadorCartasValoracion) {
		this.comparadorCartasValoracion = comparadorCartasValoracion;
	}
	
	
	
	
	
	
	
	
}
