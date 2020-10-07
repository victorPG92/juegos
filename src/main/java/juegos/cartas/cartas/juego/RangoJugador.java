package juegos.cartas.cartas.juego;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Rango de manos que un jugador se atreve a jugar.
 * @author victor
 *
 */
public interface RangoJugador<C extends ICartaComparable>
{
	/**
	 * Indica si el jugador juega dicha mano
	 * @param cartas
	 * @return
	 */
	public boolean isJuega(List<C> cartas);

}
