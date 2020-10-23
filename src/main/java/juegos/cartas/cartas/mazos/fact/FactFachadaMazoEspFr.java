package juegos.cartas.cartas.mazos.fact;

import java.util.EnumMap;

import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumFr;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasFr;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.palos.PaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazo;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazoGenMatrizLista;

/**
 * Fachada de factoria de mazos clasicos ya implementados
 * Ofrece tantos los mazos en si ya construidos
 * como las piezas con las que se contruyen
 * como suppliers de cartas y mazos, dominios, 

 * 
 * @author victor
 *
 */
public class FactFachadaMazoEspFr 
{
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, String>,
	Integer,String> supplierCartaES_IS;
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, PaloEspaniol>,
	Integer,PaloEspaniol> supplierCartaES_IE;
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, String>,
	Integer,String> supplierCartaFR_IS;
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, PaloEspaniol>,
	Integer,PaloEspaniol> supplierCartaFR_IE;
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,SupplierNewCarta>> 
	suppliersCarta= new EnumMap<>(TipoClasico.class);
	
	
	FactDominiosCartasFr fDomFr_FR_IS= new FactDominiosCartasFr();
	FactDominiosCartasEnumFr fDomFr_FR_IE= new FactDominiosCartasEnumFr();
	FactDominiosCartasEsp fDomFr_ES_IS= new FactDominiosCartasEsp();
	FactDominiosCartasEnumEsp fDomFr_ES_IE= new FactDominiosCartasEnumEsp();
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,FactDominioDobleVP>> 
	factsDom= new EnumMap<>(TipoClasico.class);
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,DominioValorPalo>> 
	dominiosVP= new EnumMap<>(TipoClasico.class);
	
	SupplierMazo supplierMazoML= new SupplierMazoGenMatrizLista<>();
	EnumMap<TipoImplementacionMazo,SupplierMazo> suppliersMazo= new EnumMap<>(TipoImplementacionMazo.class);
	
	/*
	SupplierMazo<ICartaNumeroPalo<N,P>, N, P> supplierMazoListaMatriz=
			new SupplierMazoGenMatrizLista<>();
	
	*/
	
	protected FactFachadaMazoEspFr()
	{
		for(TipoClasico tipoClasico: TipoClasico.values())
		{
			dominiosVP.put(tipoClasico, new EnumMap<>(TipoParametrizacion.class));

		}
		
		inicializaFactDom();
		inicializaSuppliersCarta();
		
		suppliersMazo.put(TipoImplementacionMazo.listaMatriz,supplierMazoML);
		
		
		
		
		
		/*dominiosVP.put(TipoClasico.Espaniola, new EnumMap<>(TipoParametrizacion.class));
		dominiosVP.put(TipoClasico.Francesa, new EnumMap<>(TipoParametrizacion.class));*/
		
	}
	
	private void inicializaFactDom()
	{
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, fDomFr_FR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, fDomFr_FR_IS);
		factsDom.put(TipoClasico.Francesa, mapaFr);
		
		
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, fDomFr_ES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, fDomFr_ES_IS);
		factsDom.put(TipoClasico.Espaniola, mapaEs);
		
	}
	
	private void inicializaSuppliersCarta()
	{
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, supplierCartaFR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, supplierCartaFR_IS);
		suppliersCarta.put(TipoClasico.Francesa, mapaFr);
		
		
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, supplierCartaES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, supplierCartaES_IS);
		suppliersCarta.put(TipoClasico.Espaniola, mapaEs);
		
	}
	
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaEspaniolaIS()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniolaIE()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloFrancesa<Integer, String>, Integer, String> crearBarajaFrancesaIS()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	public MazoGen<ICartaNumeroPaloFrancesa<Integer, PaloFrances>, Integer, PaloFrances> crearBarajaFrancesaIE()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	
	public MazoGen crearBaraja(TipoClasico tipoClasico,TipoParametrizacion tipoParam, TipoImplementacionMazo tipoImplMazo)
	{
		BuilderMazoClasicoComp<Integer, String, ICartaNumeroPaloEspaniola<Integer,String>> bMazo= 
				new
		BuilderMazoClasicoComp<>(
				dameDominio(tipoClasico, tipoParam),
				dameSuplierCarta(tipoClasico, tipoParam),
				dameSupplierMazo(tipoImplMazo)
				);
		
		return bMazo.crearBaraja();
	}
	 
	
	public DominioValorPalo/*<V, P, C extends ICartaNumeroPalo<V,P>>*/ dameDominio(TipoClasico tipoClasico,TipoParametrizacion tipoParam )
	{
		
		EnumMap<TipoParametrizacion, DominioValorPalo> mapaCl = dominiosVP.get(tipoClasico);//todos los tipos son insertados, no debe ser null
		if(mapaCl.containsKey(tipoParam))
		{
			return mapaCl.get(tipoParam);
		}
		else
		{
			DominioValorPalo dom = dameFactDom(tipoClasico, tipoParam).creaDominioVP();
			mapaCl.put(tipoParam,dom);
			
			return dom;
		}
	}
	
	public SupplierMazo/*<C extends ICartaNumeroPalo<N,P>, N, P>*/ dameSupplierMazo(TipoImplementacionMazo tipoImpl)
	{
		//if(TipoImplementacionMazo.lista.equals(tipoImpl))
			return new SupplierMazoGenMatrizLista();
		
		
		/*else
			return null;*/
			
	}
	
	public FactDominioDobleVP dameFactDom(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		return factsDom.get(tipoClasico).get(tipoParam);
	}
	
	public SupplierNewCarta dameSuplierCarta(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		return suppliersCarta.get(tipoClasico).get(tipoParam);
	}
	
	private static FactFachadaMazoEspFr inst= new FactFachadaMazoEspFr();

	/*
	public SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> getSupplierCartaES_IS() {
		return supplierCartaES_IS;
	}

	public SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> getSupplierCartaES_IE() {
		return supplierCartaES_IE;
	}

	public SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, String>, Integer, String> getSupplierCartaFR_IS() {
		return supplierCartaFR_IS;
	}

	public SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, PaloEspaniol>, Integer, PaloEspaniol> getSupplierCartaFR_IE() {
		return supplierCartaFR_IE;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, SupplierNewCarta>> getSuppliersCarta() {
		return suppliersCarta;
	}

	public FactDominiosCartasFr getfDomFr_FR_IS() {
		return fDomFr_FR_IS;
	}

	public FactDominiosCartasEnumFr getfDomFr_FR_IE() {
		return fDomFr_FR_IE;
	}

	public FactDominiosCartasEsp getfDomFr_ES_IS() {
		return fDomFr_ES_IS;
	}

	public FactDominiosCartasEnumEsp getfDomFr_ES_IE() {
		return fDomFr_ES_IE;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, FactDominioDobleVP>> getFactsDom() {
		return factsDom;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, DominioValorPalo>> getDominiosVP() {
		return dominiosVP;
	}

	public SupplierMazo getSupplierMazoML() {
		return supplierMazoML;
	}

	public EnumMap<TipoImplementacionMazo, SupplierMazo> getSuppliersMazo() {
		return suppliersMazo;
	}
*/
	public static FactFachadaMazoEspFr getInst() {
		return inst;
	}
	
	

}
