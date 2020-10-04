package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.PaloFrances;

/**
 * Provee una nueva carta con numero y palo
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerPaloFrances implements SupplierNewCarta<CartaNumeroPalo<Integer, PaloFrances>,Integer,PaloFrances>
{

	@Override
	public CartaNumeroPalo<Integer, PaloFrances> creaNuevaCarta(Integer numero, PaloFrances palo) {
		return new CartaNumeroPalo<Integer, PaloFrances>(numero,palo	) ;
	}

	@Override
	public CartaNumeroPalo<Integer, PaloFrances>[][] creaMatriz(Integer numero, PaloFrances palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaNumeroPalo<Integer, PaloFrances>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaNumeroPalo[numero][palo];
}

	
	
}
