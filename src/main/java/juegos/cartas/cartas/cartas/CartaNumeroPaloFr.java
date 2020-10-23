package juegos.cartas.cartas.cartas;

import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;

/**
 * Carta con 2 caracteristicas, valor y palo
 * los cuales pueden son parametrizables
 * esta implementada la igualdad
 * ( primero se compara el palo y
 *  luego el numero 
 *  por suposicion que hay menos palos que numeros)
 * @author victor
 *
 * @param <N>
 * @param <P>
 */
public class CartaNumeroPaloFr<N,P> extends CartaNumeroPalo<N,P> implements ICartaNumeroPaloFrancesa<N,P>
{

	public CartaNumeroPaloFr(N numero, P palo)
	{
		super(numero, palo);
	}

	
	
	
}
