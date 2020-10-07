package juegos.cartas.cartas.mesas.crupier;

import java.util.Queue;

import juegos.cartas.cartas.cartas.ICartaComparable;
import juegos.cartas.cartas.mazos.modelos.MazoCartasDeshacer;
import juegos.cartas.cartas.mazos.modelos.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.MazoInsercion;

/**
 * Crupier que saca las cartas que se le indican
 * @author victor
 *
 * @param <C>
 */
public class CrupierTramposo<C extends ICartaComparable> extends CrupierMazo<C> implements Crupier<C>
{
	

	MazoCartasExtraccionConcreta<C> mazoExtr;

	Queue<C> cartasQueSaldran;

	public CrupierTramposo(MazoCartasExtraccionConcreta<C> mazo,Queue<C> cartas) {
		super(mazo);
		mazoExtr= mazo;
		cartasQueSaldran=cartas;
	}

	@Override
	public C reparteCarta() 
	{
		C carta;
		if(cartasQueSaldran.isEmpty())
			carta= mazoExtr.dameCartaAleatoria();
		else 
			carta = mazoExtr.dameCartaConcreta(cartasQueSaldran.poll());
		
		return carta;
	}
	
	@Override
	public void quemarCarta() {
		
		
		C carta= mazoExtr.dameCartaAleatoria();
		
		while(cartasQueSaldran.contains(carta))
		{
			try {
				MazoCartasDeshacer<C> mazoIns= (MazoCartasDeshacer<C>) mazo;
				mazoIns.deshacerReparto();
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			carta= mazoExtr.dameCartaAleatoria();
		}
	}

}
