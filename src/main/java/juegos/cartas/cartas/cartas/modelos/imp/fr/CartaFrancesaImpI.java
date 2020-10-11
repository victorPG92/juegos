package juegos.cartas.cartas.cartas.modelos.imp.fr;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;

/**
 * Implementacion carta francesa con CartaNumeroPalo
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class CartaFrancesaImpI<V,P> 
extends CartaNumeroPalo<V, P>
implements ICartaNumeroPaloFrancesa<V, P>
{

public CartaFrancesaImpI(V numero, P palo) {
		super(numero, palo);
	}



}
