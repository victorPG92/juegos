package juegos.cartas.cartas.mesas;

import java.util.ArrayList;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Clase jugador que tiene un id unico
 * las cartas con las que juega
 * la mano la cual se obtiene despues de analizar
 * y unas fichas que puede apostar
 * 
 * @author victor
 *
 */
public class Jugador
{
	private String id;
	private List<ICartaComparable> cartas;
	
	private Mano mano;
	
	private int fichas;
	

}
