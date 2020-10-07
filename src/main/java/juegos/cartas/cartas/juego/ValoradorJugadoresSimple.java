package juegos.cartas.cartas.juego;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mesas.Jugador;

public class ValoradorJugadoresSimple <C extends ICartaComparable>
implements ValoradorJugadores<C>
{
	
	public Jugador<C> encontrarMejorJugada(Collection<Jugador<C>> jugadores)
	{
		Mano manoMejor= null;
		Jugador jugadorMejor=null;
		for(Jugador jugador: jugadores)
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
		SortedSet<Jugador<C>> marcador=new TreeSet<Jugador<C>>((j1,j2)-> j1.getMano().compareTo(j2.getMano()));
		marcador.addAll(jugadores);
		return marcador;//.first();//last();
	}

}
