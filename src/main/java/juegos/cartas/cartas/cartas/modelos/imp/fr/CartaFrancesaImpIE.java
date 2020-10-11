package juegos.cartas.cartas.cartas.modelos.imp.fr;

import juegos.cartas.cartas.cartas.modelos.CartaFrancesa;
import juegos.cartas.cartas.cartas.palos.PaloFrances;

/**
 * Implementacion carta francesa con CartaNumeroPalo
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class CartaFrancesaImpIE 
extends CartaFrancesaImpI<Integer, PaloFrances>
implements CartaFrancesa
{

public CartaFrancesaImpIE(Integer numero, PaloFrances palo) {
		super(numero, palo);
	}



}
