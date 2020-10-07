package juegos.cartas.cartas.mazos.modelos;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Mazo que tiene operaciones de insercion de cartas
 * Permite volver a introducir cartas en el mazo
 * @author victor
 *
 * @param <C>
 */
public interface MazoInsercion <C extends ICartaComparable> extends MazoCartasSimple<C>
{

	/**
	 * Mete una carta concreta en el mazo
	 * @return
	 */
	public void insertaCarta(C c);
	
	

	/**
	 * Mete varias carta concreta en el mazo
	 * @return
	 */
	
	public void insertaCartas(List<C> l);

}
