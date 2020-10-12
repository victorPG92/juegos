package juegos.cartas.cartas.mazos.modelos.suppliers;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

/**
 * Provee un nuevo mazo sabiendo un supplier de cartas y un dominio
 * @param s
 * @param domVP
 * @return
 */
public interface SupplierMazo <C extends ICartaNumeroPalo<N, P>,N,P>
{
	
	public MazoGenOptMatrizLista<C, N, P> creaMazo(SupplierNewCarta<C, N, P> s, DominioValorPalo<N, P, C> domVP);


}
