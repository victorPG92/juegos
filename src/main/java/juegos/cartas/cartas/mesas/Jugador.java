package juegos.cartas.cartas.mesas;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.juego.Mano;

/**
 * Clase jugador que tiene un id unico
 * las cartas con las que juega
 * la mano la cual se obtiene despues de analizar
 * y unas fichas que puede apostar
 * 
 * @author victor
 *
 */
public class Jugador<C extends ICartaComparable>
{
	private String id;
	private List<C> cartas;	
	private Mano mano;	
	private int fichas;
	
	
	

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final List<C> getCartas() {
		return cartas;
	}

	public final void setCartas(List<C> cartas) {
		this.cartas = cartas;
	}

	public final Mano getMano() {
		return mano;
	}

	public final void setMano(Mano mano) {
		this.mano = mano;
	}

	public final int getFichas() {
		return fichas;
	}

	public final void setFichas(int fichas) {
		this.fichas = fichas;
	}
	
	
	

}
