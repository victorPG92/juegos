package juegos.cartas.cartas.juego.valorador;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.juego.Mano;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Valora jugadores segun la mano y los ordena de ese modo
 * @author victor
 *
 * @param <C>
 * @param <J>
 */
public class ValoradorJugadoresPorMano <C extends ICartaComparable,J extends Jugador<C>>
implements ValoradorJugadores<C,J>
{
	
	public J encontrarMejorJugador(Collection<J> jugadores)
	{
		Mano manoMejor= null;
		J jugadorMejor=null;
		for(J jugador: jugadores)
		{
			if(manoMejor==null || jugador.getMano().compareTo(manoMejor)>=1)
			{
				manoMejor= jugador.getMano();
				jugadorMejor= jugador;
			}
					
		}
		
		return jugadorMejor;
	}
	
	public SortedSet<Jugador<C>> valorarJugadores(Collection<Jugador<C>> jugadores)
	{
		SortedSet<Jugador<C>> marcador=new TreeSet<>((j1,j2)-> j1.getMano().compareTo(j2.getMano()));
		marcador.addAll(jugadores);
		return marcador;//.first();//last();
	}

}
