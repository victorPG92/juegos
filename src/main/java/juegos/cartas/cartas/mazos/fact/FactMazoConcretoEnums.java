package juegos.cartas.cartas.mazos.fact;

import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.PaloFrances;
import juegos.cartas.cartas.cartas.dom.Dominio;
import juegos.cartas.cartas.cartas.dom.FactDominiosCartas;
import juegos.cartas.cartas.cartas.dom.FactDominiosCartasEnum;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerPaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerString;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

public class FactMazoConcretoEnums 
{
	public MazoGen crearBarajaEspaniola()
	{
		MazoGen<CartaNumeroPalo<Integer, String>, Integer, String> mazo;
		FactDominiosCartas fDom= new FactDominiosCartas();
		
		Dominio<String> domP = fDom.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,String>, Integer, String> supplier= new SupplierNewCartaIntegerString();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, String>, Integer, String>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen crearBarajaFrancesa()
	{
		MazoGen<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances> mazo;
		FactDominiosCartasEnum fDom= new FactDominiosCartasEnum();
		
		Dominio<PaloFrances> domP = fDom.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDom.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<CartaNumeroPalo<Integer,PaloFrances>, Integer, PaloFrances> supplier= new SupplierNewCartaIntegerPaloFrances();
		mazo= new MazoGenOptMatrizLista<CartaNumeroPalo<Integer, PaloFrances>, Integer, PaloFrances>(supplier, domP, domV);		
		
		return mazo;
	}

}
