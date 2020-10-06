package juegos.cartas.cartas.mesas;

import java.util.ArrayList;
import java.util.List;

public class Mesa 
{
	List<Jugador> jugadores= new ArrayList<>();
	
	List<CeldaCartaMesa> cartasComunes= new ArrayList<>();
	
	
	
	

	public Mesa(List<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
	}

	public final List<Jugador> getJugadores() {
		return jugadores;
	}

	/*
	public final void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}*/

	public final List<CeldaCartaMesa> getCartasComunes() {
		return cartasComunes;
	}

	public final void setCartasComunes(List<CeldaCartaMesa> cartasComunes) {
		this.cartasComunes = cartasComunes;
	}
	
	
	
	

}
