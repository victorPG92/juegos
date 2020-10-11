package juegos.cartas.cartas.cartas.modelos.imp.es;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;

/**
 * Implementacion de carta espaniola con CartaNumeroPalo  
 * @author victor
 *
 */
public class CartaEspaniolaImp<V,P> 
extends CartaNumeroPalo<V, P>
implements ICartaNumeroPaloEspaniola<V, P>
{

public CartaEspaniolaImp(V numero, P palo) {
		super(numero, palo);
	}



}
