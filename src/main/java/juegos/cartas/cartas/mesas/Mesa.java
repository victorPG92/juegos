package juegos.cartas.cartas.mesas;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Mesa que contiene los jugadores que juegan y las cartas comunes
 * @author victor
 *
 * @param <C>
 */
public class Mesa<C extends ICartaComparable, J extends Jugador<C>> 
{
	List<J> jugadores= new ArrayList<>();
	
	List<CeldaCartaMesa<C>> cartasComunes= new ArrayList<>();
	
	
	
	

	public Mesa(List<J> jugadores) {
		super();
		this.jugadores = jugadores;
	}

	public final List<J> getJugadores() {
		return jugadores;
	}

	/*
	public final void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}*/

	public final List<CeldaCartaMesa<C>> getCartasComunes() {
		return cartasComunes;
	}

	
	public final void setCartasComunes(List<CeldaCartaMesa<C>> cartasComunes) {
		this.cartasComunes = cartasComunes;
	}
	

	/**
	 * Inserta una lista de cartas como cartas comunes;
	 * En unas estructuras celdas, para indicar si estran dadas la vuelta o no
	 * @param cartasComunes
	 */
	public final void insertaCartasComunes(List<C> cartasComunes)
	{
		
		for (C carta : cartasComunes) {
			CeldaCartaMesa<C> celda= new CeldaCartaMesa<>(carta, true);
			this.cartasComunes.add(celda);
		}
		
	}
	
	
	

}
