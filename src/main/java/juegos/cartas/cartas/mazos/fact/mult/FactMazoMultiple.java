package juegos.cartas.cartas.mazos.fact.mult;

import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.modelos.CartaFrancesa;
import juegos.cartas.cartas.cartas.modelos.imp.fr.CartaFrancesaImpI;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.fact.FactFachadaMazoEspFr;
import juegos.cartas.cartas.mazos.fact.TipoClasico;
import juegos.cartas.cartas.mazos.fact.TipoParametrizacion;
import juegos.cartas.cartas.mazos.impl.gen.mult.MazoMultipleGenOptMatrizLista;
import juegos.cartas.cartas.mazos.modelos.func.MazoMultiple;

public class FactMazoMultiple<C extends CartaFrancesaImpI<Integer, P>,P>
{
	
	FactFachadaMazoEspFr fach= new FactFachadaMazoEspFr();
	/*
	SupplierNewCarta<C, N, P> supplier;
	FactD
	*/
	public MazoMultiple<C> creaMazoMult(int numMazos, TipoParametrizacion tipoParam)
	{
		TipoClasico fr= TipoClasico.Francesa;
		
		SupplierNewCarta<C, Integer, P> supplier = fach.dameSuplierCarta(fr, tipoParam);
		
		DominioValorPalo<Integer, P, C> dom= fach.dameDominio(fr, tipoParam);
		return 
				new MazoMultipleGenOptMatrizLista<>(supplier, dom,numMazos);
		
	}

}
