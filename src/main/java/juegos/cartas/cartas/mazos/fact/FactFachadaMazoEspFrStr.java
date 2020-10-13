package juegos.cartas.cartas.mazos.fact;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEnumFr;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasEsp;
import juegos.cartas.cartas.cartas.dom.fact.FactDominiosCartasFr;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazo;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazoGenMatrizLista;

/**mas flexible que su padre porque permite acceder a las estructuras 
 * y clave mediante String en vez de enum que es as restrictiva 
 * 
 * Fachada de factoria de mazos clasicos ya implementados
 * Ofrece tantos los mazos en si ya construidos
 * como las piezas con las que se contruyen
 * como suppliers de cartas y mazos, dominios, 

 * 
 * @author victor
 *
 */
public class FactFachadaMazoEspFrStr  extends FactFachadaMazoEspFr
{
	
	
	
	Map<String,Map<String,SupplierNewCarta>> 
	suppliersCarta= new HashMap<>();
	
	
	
	Map<String,Map<String,FactDominioDobleVP>> 
	factsDom= new HashMap<>();
	
	Map<String,Map<String,DominioValorPalo>> 
	dominiosVP= new HashMap<>();
	
	SupplierMazo supplierMazoML= new SupplierMazoGenMatrizLista<>();
	EnumMap<TipoImplementacionMazo,SupplierMazo> suppliersMazo= new EnumMap<>(TipoImplementacionMazo.class);
	
	/*
	SupplierMazo<ICartaNumeroPalo<N,P>, N, P> supplierMazoListaMatriz=
			new SupplierMazoGenMatrizLista<>();
	
	*/
	
	private FactFachadaMazoEspFrStr()
	{
		super();
		for(TipoClasico tipoClasico: TipoClasico.values())
		{
			dominiosVP.put(tipoClasico.toString(), new HashMap<>());

		}
		
		inicializaFactDom();
		inicializaSuppliersCarta();
		
		suppliersMazo.put(TipoImplementacionMazo.listaMatriz,supplierMazoML);
		
		
		
		
		
		/*dominiosVP.put(TipoClasico.Espaniola, new EnumMap<>(TipoParametrizacion.class));
		dominiosVP.put(TipoClasico.Francesa, new EnumMap<>(TipoParametrizacion.class));*/
		
	}
	
	private void inicializaFactDom()
	{
		Map<String,FactDominioDobleVP> mapaFr= new HashMap<>();
		mapaFr.put(TipoParametrizacion.Int_Enum.toString(), fDomFr_FR_IE);
		mapaFr.put(TipoParametrizacion.Int_String.toString(), fDomFr_FR_IS);
		factsDom.put(TipoClasico.Francesa.toString(), mapaFr);
		
		
		Map<String,FactDominioDobleVP> mapaEs= new HashMap<>();
		mapaEs.put(TipoParametrizacion.Int_Enum.toString(), fDomFr_ES_IE);
		mapaEs.put(TipoParametrizacion.Int_String.toString(), fDomFr_ES_IS);
		factsDom.put(TipoClasico.Espaniola.toString(), mapaEs);
		
	}
	
	private void inicializaSuppliersCarta()
	{
		Map<String,SupplierNewCarta> mapaFr= new HashMap<>();
		mapaFr.put(TipoParametrizacion.Int_Enum.toString(), supplierCartaFR_IE);
		mapaFr.put(TipoParametrizacion.Int_String.toString(), supplierCartaFR_IS);
		suppliersCarta.put(TipoClasico.Francesa.toString(), mapaFr);
		
		
		Map<String,SupplierNewCarta> mapaEs= new HashMap<>();
		mapaEs.put(TipoParametrizacion.Int_Enum.toString(), supplierCartaES_IE);
		mapaEs.put(TipoParametrizacion.Int_String.toString(), supplierCartaES_IS);
		suppliersCarta.put(TipoClasico.Espaniola.toString(), mapaEs);
		
	}
	
		
	
	public MazoGen crearBaraja(String tipoClasico,String tipoParam, TipoImplementacionMazo tipoImplMazo)
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
	 
	
	public DominioValorPalo/*<V, P, C extends ICartaNumeroPalo<V,P>>*/ dameDominio(String tipoClasico,String tipoParam )
	{
		
		Map<String, DominioValorPalo> mapaCl = dominiosVP.get(tipoClasico);//todos los tipos son insertados, no debe ser null
		if(mapaCl.containsKey(tipoParam))
		{
			return mapaCl.get(tipoParam);
		}
		else
		{
			DominioValorPalo dom = dameFactDom(tipoClasico, tipoParam).creaDominioVP();
			mapaCl.put(tipoParam.toString(),dom);
			
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
	
	
	public FactDominioDobleVP dameFactDom(String tipoClasico,String tipoParam)
	{
		return factsDom.get(tipoClasico).get(tipoParam);
	}
	
	public SupplierNewCarta dameSuplierCarta(String tipoClasico,String tipoParam)
	{
		return suppliersCarta.get(tipoClasico).get(tipoParam);
	}
	
	private static FactFachadaMazoEspFrStr inst= new FactFachadaMazoEspFrStr();

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

	
	public Map<String, Map<String, SupplierNewCarta>> getSuppliersCarta() {
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

	public Map<String, Map<String, FactDominioDobleVP>> getFactsDom() {
		return factsDom;
	}

	public Map<String, Map<String, DominioValorPalo>> getDominiosVP() {
		return dominiosVP;
	}

	public SupplierMazo getSupplierMazoML() {
		return supplierMazoML;
	}

	public EnumMap<TipoImplementacionMazo, SupplierMazo> getSuppliersMazo() {
		return suppliersMazo;
	}

	public static FactFachadaMazoEspFrStr getInst() {
		return inst;
	}
	
	

}
