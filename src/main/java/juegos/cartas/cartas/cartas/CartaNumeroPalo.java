package juegos.cartas.cartas.cartas;

import java.util.Comparator;

public class CartaNumeroPalo<N,P> implements ICartaComparable
{

	protected N numero;
	protected P palo;
	
	/**
	 * Compara las cartas para saber cual vale mas dentro del juego
	 * no para ordenar , por ejemplo, 
	 */
	//Comparator<CartaNumeroPalo<N,P>> compCartasValor;
	
	public CartaNumeroPalo(N numero, P palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	public final N getNumero() {
		return numero;
	}

	public final P getPalo() {
		return palo;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		CartaNumeroPalo<N, P> carta= (CartaNumeroPalo<N, P>) obj;
		 
		boolean r= palo.equals(carta.palo);
		
		if(!r)
			return r;
		
		r= numero.equals(carta.numero);
			
		 
		return r;
	}

	/*
	public final Comparator<CartaNumeroPalo<N, P>> getCompCartasValor() {
		return compCartasValor;
	}

	public final void setCompCartasValor(Comparator<CartaNumeroPalo<N, P>> compCartasValor) {
		this.compCartasValor = compCartasValor;
	}
*/
	public final void setNumero(N numero) {
		this.numero = numero;
	}

	public final void setPalo(P palo) {
		this.palo = palo;
	}

	/*
	@Override
	public int compareTo(ICartaComparable o) {
		return compCartasValor.compare(this, (CartaNumeroPalo<N,P>)o);
	}
	*/
	
	
	
	
	
}
