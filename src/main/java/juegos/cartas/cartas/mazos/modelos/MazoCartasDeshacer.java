package juegos.cartas.cartas.mazos.modelos;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Permite almacenar las cartas que han sido repartidas en orden,
 * y devolverlas al mazo en ese orden
 * @author victor
 *
 * @param <C>
 */
public interface MazoCartasDeshacer <C extends ICartaComparable>
{
	

	/**
	 * Apila carta para deshacer el movimiento
	 * @param cartaRepartida
	 */
	public void apilaCartaRepartida(C cartaRepartida);
	
	/**
	 * Deshace carta repartida
	 */
	public  void deshacerReparto();


	
	public C ultimaCartaRepartida();
}
