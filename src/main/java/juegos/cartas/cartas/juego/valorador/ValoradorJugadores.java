package juegos.cartas.cartas.juego.valorador;

import java.util.Collection;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Valora a los jugadores segun algun criterio por ejemplo, la mejor jugada
 * @author victor
 *
 * @param <C>
 * @param <J>
 */
public interface ValoradorJugadores <C extends ICartaComparable,J extends Jugador<C>>{

	public J encontrarMejorJugador(Collection<J> jugadores);
}
