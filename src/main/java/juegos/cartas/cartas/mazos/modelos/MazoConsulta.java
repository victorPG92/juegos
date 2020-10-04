package juegos.cartas.cartas.mazos.modelos;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Mazo que tiene operaciones de consulta de cartas
 * @author victor
 *
 * @param <C>
 */
public interface MazoConsulta <C extends ICartaComparable>
{


	/**
	 * Devuelve si la carta pertenece al mazo
	 * @param c
	 * @return
	 */
	public boolean perteneceCartaAMazo(C c);
	
}
