package juegos.cartas.cartas.mesas;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

public class Mesa<C extends ICartaComparable> 
{
	List<Jugador<C>> jugadores= new ArrayList<>();
	
	List<CeldaCartaMesa<C>> cartasComunes= new ArrayList<>();
	
	
	
	

	public Mesa(List<Jugador<C>> jugadores) {
		super();
		this.jugadores = jugadores;
	}

	public final List<Jugador<C>> getJugadores() {
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
	
	
	
	

}
