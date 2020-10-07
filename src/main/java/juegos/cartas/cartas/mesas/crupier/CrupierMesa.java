package juegos.cartas.cartas.mesas.crupier;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Crupier que reparte cartas tanto a la mesa como a los jugadores
 * @author victor
 *
 * @param <C>
 */
public interface CrupierMesa<C extends ICartaComparable> extends Crupier<C>
{
	
	

	public List<C>  reparteCartasJugador();
	
	public List<C>  reparteCartasMesa();
	
	
	
	

}
