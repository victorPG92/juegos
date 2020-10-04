package juegos.cartas.cartas.cartas.supplier;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Provee una nueva carta con numero y palo
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public interface SupplierNewCarta <C extends CartaNumeroPalo<N, P>,N,P>
{

	public C creaNuevaCarta(N numero, P palo);

	public C[][] creaMatriz(N numero, P palo);

	
	public C[][] creaMatriz(int numero, int palo);

	
}
