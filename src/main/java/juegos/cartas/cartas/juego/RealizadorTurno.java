package juegos.cartas.cartas.juego;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Realiza un turno de un jugador 
 * @author victor
 *
 */
public abstract class RealizadorTurno<C extends ICartaComparable,A extends AccionJuego,J extends JuegoCartas<F>,Jug extends Jugador<C>, F extends FaseJuego<F>> 
{
	
	protected Jug jugador;
	protected J juegoCartas;
	
	
	
	public RealizadorTurno(Jug jugador, J juegoCartas) {
		super();
		this.jugador = jugador;
		this.juegoCartas = juegoCartas;
	}


	/**
	 * Realiza el turno de la manera que sea
	 */
	public abstract void realizaTurno();
	

	/**
	 * Indica que accion va a realizar el jugador
	 * @return
	 */
	public abstract A escogeAccion();
	//public abstract Apuesta<AccionJuego> escogeAccion();


	public Jugador<C> getJugador() {
		return jugador;
	}


	public void setJugador(Jug jugador) {
		this.jugador = jugador;
	}


	public J getJuegoCartas() {
		return juegoCartas;
	}


	public void setJuegoCartas(J juegoCartas) {
		this.juegoCartas = juegoCartas;
	}

	
	
	
}
