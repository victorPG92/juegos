package juegos.cartas.cartas.mesas.crupier;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

public interface CrupierMesa extends Crupier
{
	
	

	public List<ICartaComparable>  reparteCartasJugador();
	
	public List<ICartaComparable>  reparteCartasMesa();
	
	
	
	

}
