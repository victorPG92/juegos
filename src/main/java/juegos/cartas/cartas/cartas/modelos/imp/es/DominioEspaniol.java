package juegos.cartas.cartas.cartas.modelos.imp.es;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;

/**
 * Dominio de cartas francesas
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class DominioEspaniol<V,P> extends DominioValorPalo<V, P, ICartaNumeroPaloEspaniola<V, P>>{

	public DominioEspaniol(Dominio<V> domValor, Dominio<P> domPalo,
			Comparator<ICartaNumeroPaloEspaniola<V, P>> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
		// TODO Auto-generated constructor stub
	}

	public DominioEspaniol(Dominio<V> domValor, Dominio<P> domPalo) {
		super(domValor, domPalo);
		// TODO Auto-generated constructor stub
	}

	

	

	
	
}
