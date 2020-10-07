package juegos.cartas.cartas.mesas.crupier;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

public interface CrupierMesa<C extends ICartaComparable> extends Crupier<C>
{
	
	

	public List<C>  reparteCartasJugador();
	
	public List<C>  reparteCartasMesa();
	
	
	
	

}
