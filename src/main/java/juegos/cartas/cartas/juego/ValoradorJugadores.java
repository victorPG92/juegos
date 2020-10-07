package juegos.cartas.cartas.juego;

import java.util.Collection;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

public interface ValoradorJugadores <C extends ICartaComparable>{

	public Jugador<C> encontrarMejorJugada(Collection<Jugador<C>> jugadores);
}
