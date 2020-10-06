package juegos.cartas.cartas.juego;

import juegos.cartas.cartas.mesas.Jugador;

/**
 * Realiza un turno de un jugador 
 * @author victor
 *
 */
public abstract class RealizadorTurno 
{
	
	protected Jugador jugador;
	protected JuegoCartas juegoCartas;
	
	public abstract void realizaTurno();
	

}
