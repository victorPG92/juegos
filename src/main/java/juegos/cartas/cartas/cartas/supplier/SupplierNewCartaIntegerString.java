package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Provee una nueva carta con numero y palo en string
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerString implements SupplierNewCarta<CartaNumeroPalo<Integer, String>,Integer,String>
{

	@Override
	public CartaNumeroPalo<Integer, String> creaNuevaCarta(Integer numero, String palo) {
		return new CartaNumeroPalo<Integer, String>(numero,palo	) ;
	}

	@Override
	public CartaNumeroPalo<Integer, String>[][] creaMatriz(Integer numero, String palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaNumeroPalo<Integer, String>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaNumeroPalo[numero][palo];
}

	
	
}
