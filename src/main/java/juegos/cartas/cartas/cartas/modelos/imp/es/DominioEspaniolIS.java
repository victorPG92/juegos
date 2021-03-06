package juegos.cartas.cartas.cartas.modelos.imp.es;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * dominio para cartas de baraja espaniola que se implementa con enteros y string
 * @author victor
 *
 */
public class DominioEspaniolIS extends DominioValorPalo<Integer, String, CartaEspaniolaImpIS>{

	public DominioEspaniolIS(Dominio<Integer> domValor, Dominio<String> domPalo) {
		super(domValor, domPalo);
	
	}

	public DominioEspaniolIS(Dominio<Integer> domValor, Dominio<String> domPalo,
			Comparator<CartaEspaniolaImpIS> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	
	
}
