package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.CartaNumeroPaloEs;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;

/**
 * Provee una nueva carta con numero y palo frances con enumerado
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerPaloEspaniol implements SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>,Integer,PaloEspaniol>
{

	@Override
	public ICartaNumeroPaloEspaniola<Integer, PaloEspaniol> creaNuevaCarta(Integer numero, PaloEspaniol palo) {
		return new CartaNumeroPaloEs<>(numero,palo) ;
	}

	@Override
	public ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>[][] creaMatriz(Integer numero, PaloEspaniol palo) {
		return new ICartaNumeroPaloEspaniola[numero][palo.values().length];
	}

	@Override
	public ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new ICartaNumeroPaloEspaniola[numero][palo];
}

	
	
}
