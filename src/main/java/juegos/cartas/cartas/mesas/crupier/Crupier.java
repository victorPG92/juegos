package juegos.cartas.cartas.mesas.crupier;

import java.util.List;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * Figura que reparte cartas
 * @author victor
 *
 */
public interface Crupier 
{
	/**
	 * reparte una carta
	 * @return
	 */
	public ICartaComparable reparteCarta();
	
	/**
	 * Reparte varias cartas seguidas
	 * @param numCartas
	 * @return
	 */
	public List<ICartaComparable> reparteNCartas(int numCartas);

	

	/**
	 * Descarta una carta
	 */
	public void quemarCarta();
	
	

}
