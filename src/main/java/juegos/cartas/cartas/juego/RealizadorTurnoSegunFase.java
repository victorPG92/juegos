package juegos.cartas.cartas.juego;

import java.util.HashMap;
import java.util.Map;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Almacena  realizadores necesarios para cada fase
 * Delega eleccion de la accion en ellos
 */
public class RealizadorTurnoSegunFase
<C extends ICartaComparable,
A extends AccionJuego, 
J extends JuegoCartas<F>,
Jug extends Jugador<C>,
F extends FaseJuego<F>
>
extends RealizadorTurno<C,A,J,Jug,F>
{
	public RealizadorTurnoSegunFase(Jug jugador, J juegoCartas) {
		super(jugador, juegoCartas);
	}

	Map<F, RealizadorTurno<C,A,J,Jug,F>> realizadoresSegunFase= new HashMap<>();

	/**
	 * Disponiendo de todos los realizadores necesarios para cada fase
	 * delega la funcion en ellos
	 */
	@Override
	public A escogeAccion() 
	{
	
		RealizadorTurno<C,A,J,Jug,F> realizadorFaseActual= realizadoresSegunFase.get(juegoCartas.getFase());

		if(realizadorFaseActual!=null)
			return realizadorFaseActual.escogeAccion();
		else
			return null;
	}

	@Override
	public void realizaTurno() {
		escogeAccion();		
	}
	
	/**
	 * Establece el realizador para la fase
	 * @param realizador
	 * @param fase
	 */
	public void setRealizadorFase(RealizadorTurno<C,A,J,Jug,F> realizador, F fase)
	{
		realizadoresSegunFase.put(fase, realizador);
	}

}
