package juegos.cartas.cartas.cartas.modelos.imp.es;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;

public class DominioEspaniolIE extends DominioValorPalo<Integer, PaloEspaniol, CartaEspanioIampIE>{

	public DominioEspaniolIE(Dominio<Integer> domValor, Dominio<PaloEspaniol> domPalo,
			Comparator<CartaEspanioIampIE> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	public DominioEspaniolIE(Dominio<Integer> domValor, Dominio<PaloEspaniol> domPalo) {
		super(domValor, domPalo);
	}

	

	
	
}
