package juegos.cartas.cartas.juego;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Realiza un turno de un jugador 
 * @author victor
 *
 */
public abstract class RealizadorTurno<C extends ICartaComparable,A extends AccionJuego> 
{
	
	protected Jugador<C> jugador;
	protected JuegoCartas juegoCartas;
	
	/**
	 * Realiza el turno de la manera que sea
	 */
	public abstract void realizaTurno();
	

	/**
	 * Indica que accion va a realizar el jugador
	 * @return
	 */
	public abstract A escogeAccion();
}
