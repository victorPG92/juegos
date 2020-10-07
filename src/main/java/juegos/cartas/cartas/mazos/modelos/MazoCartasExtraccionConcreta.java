package juegos.cartas.cartas.mazos.modelos;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Mazo de cartas que permite extraer concretas
 * 
 * @author victor
 *
 */
public interface MazoCartasExtraccionConcreta<C extends ICartaComparable> extends MazoCartasSimple<C>
{
	
	/**
	 * Devuelve una carta concreta
	 * @return
	 */
	public C dameCartaConcreta(C cartaConcreta);
	
	/**
	 * Devuelve varias carta concreta
	 * @return
	 */
	public List<C> dameNCartasConcretas(List<C> cartasConcretas);
	
	
		
	
	

}
