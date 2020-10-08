package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;

/**
 * Provee una nueva carta con numero y palo frances con enumerado
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerPaloEspaniol implements SupplierNewCarta<CartaNumeroPalo<Integer, PaloEspaniol>,Integer,PaloEspaniol>
{

	@Override
	public CartaNumeroPalo<Integer, PaloEspaniol> creaNuevaCarta(Integer numero, PaloEspaniol palo) {
		return new CartaNumeroPalo<Integer, PaloEspaniol>(numero,palo) ;
	}

	@Override
	public CartaNumeroPalo<Integer, PaloEspaniol>[][] creaMatriz(Integer numero, PaloEspaniol palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaNumeroPalo<Integer, PaloEspaniol>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaNumeroPalo[numero][palo];
}

	
	
}
