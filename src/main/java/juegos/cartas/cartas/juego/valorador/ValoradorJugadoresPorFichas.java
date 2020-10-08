package juegos.cartas.cartas.juego.valorador;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

/**
 * Valora jugadores segun el numero de fichas y los ordena de ese modo
 * usado por ejemplo, al acabar un torneo, clasificar burbuja
 * @author victor
 *
 * @param <C>
 * @param <J>
 */
public class ValoradorJugadoresPorFichas <C extends ICartaComparable,J extends Jugador<C>>
implements ValoradorJugadores<C,J>
{
	
	public J encontrarMejorJugador(Collection<J> jugadores)
	{
		int mayorFichas= 0;
		J jugadorMejor=null;
		for(J jugador: jugadores)
		{
			if(mayorFichas==0 || Integer.compare(jugador.getFichas(),mayorFichas)>=1)
			{
				mayorFichas= jugador.getFichas();
				jugadorMejor= jugador;
			}
					
		}
		
		return jugadorMejor;
	}
	
	public SortedSet<Jugador<C>> valorarJugadores(Collection<Jugador<C>> jugadores)
	{
		SortedSet<Jugador<C>> marcador=new TreeSet<>((j1,j2)-> Integer.compare(j1.getFichas(),j2.getFichas()));
		marcador.addAll(jugadores);
		return marcador;//.first();//last();
	}

}
