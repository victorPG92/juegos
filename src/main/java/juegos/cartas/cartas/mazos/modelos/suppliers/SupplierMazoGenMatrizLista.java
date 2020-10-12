package juegos.cartas.cartas.mazos.modelos.suppliers;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

public class SupplierMazoGenMatrizLista<C extends ICartaNumeroPalo<N,P>,N,P>
implements SupplierMazo<C, N, P>

{

	
	public MazoGenOptMatrizLista<C, N, P> creaMazo(SupplierNewCarta<C, N, P> s, DominioValorPalo<N, P, C> domVP)
	{
		return new MazoGenOptMatrizLista<C,N,P>(s,domVP);
	}
}
