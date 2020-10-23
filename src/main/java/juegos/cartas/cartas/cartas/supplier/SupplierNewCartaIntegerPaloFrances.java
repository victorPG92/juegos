package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaFrancesaOld;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Provee una nueva carta con numero y palo frances con enumerado
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerPaloFrances implements SupplierNewCarta<CartaFrancesaOld,Integer,PaloFrances>
{

	@Override
	public CartaFrancesaOld creaNuevaCarta(Integer numero, PaloFrances palo) {
		return new CartaFrancesaOld(numero,palo) ;
	}

	@Override
	public CartaFrancesaOld[][] creaMatriz(Integer numero, PaloFrances palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaFrancesaOld[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaFrancesaOld[numero][palo];
}

	
	
}
