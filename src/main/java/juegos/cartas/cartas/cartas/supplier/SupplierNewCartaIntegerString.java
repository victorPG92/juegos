package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;

/**
 * Provee una nueva carta con numero y palo en string
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerString implements SupplierNewCarta<ICartaNumeroPalo<Integer, String>,Integer,String>
{

	@Override
	public ICartaNumeroPalo<Integer, String> creaNuevaCarta(Integer numero, String palo) {
		return new CartaNumeroPalo<Integer, String>(numero,palo	) ;
	}

	@Override
	public ICartaNumeroPalo<Integer, String>[][] creaMatriz(Integer numero, String palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICartaNumeroPalo<Integer, String>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaNumeroPalo[numero][palo];
}

	
	
}
