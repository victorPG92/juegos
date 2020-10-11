package juegos.cartas.cartas.mazos.fact;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

/**
 * Crea un mazo generico, creando baraja francesa y baraja espaniola
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public interface FactBarajasClasicas <C extends ICartaNumeroPalo<N,P>, N, P>
{

	public MazoGen<C, N,P> crearBarajaEspaniola();
	public MazoGen<C, N,P> crearBarajaFrancesa();
}
