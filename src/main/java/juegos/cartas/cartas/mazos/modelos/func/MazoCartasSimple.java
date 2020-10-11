package juegos.cartas.cartas.mazos.modelos.func;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Mazo que tiene operaciones basicas:
 * extraccion de cartas aleatorias
 * consulta del numero de cartas y si esta vacio
 * @author victor
 *
 * @param <C>
 */
public interface MazoCartasSimple <C extends ICartaComparable> //extends MazoCartasExtraccionConcreta<C>{
{
	/**
	 * Devuelve una carta aleatoria
	 * @return
	 */
	public C dameCartaAleatoria();
	
	/**
	 * Devuelve n cartas aleatoria
	 * @return
	 */
	public List<C> dameNCartasAleatoria(int n);
	
	
	
	/**
	 * devuelve el tam del mazo, es decir, el numero de cartas(activas)
	 * @return
	 */
	public int size();
	
	
	/**
	 * Devuelve si el mazo esta vacio.
	 * @return
	 */
	public boolean isEmpty();
	
}
