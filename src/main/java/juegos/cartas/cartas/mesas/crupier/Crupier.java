package juegos.cartas.cartas.mesas.crupier;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Figura que reparte cartas
 * @author victor
 *
 */
public interface Crupier<C extends ICartaComparable>
{
	/**
	 * reparte una carta
	 * @return
	 */
	public C reparteCarta();
	
	/**
	 * Reparte varias cartas seguidas
	 * @param numCartas
	 * @return
	 */
	public List<C> reparteNCartas(int numCartas);

	

	/**
	 * Descarta una carta
	 */
	public void quemarCarta();
	
	

}
