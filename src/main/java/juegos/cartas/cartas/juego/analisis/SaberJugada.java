package juegos.cartas.cartas.juego.analisis;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Mano;

public interface SaberJugada 
{
	
	public Mano dameMano(List<? extends ICartaComparable> cartas);

}
