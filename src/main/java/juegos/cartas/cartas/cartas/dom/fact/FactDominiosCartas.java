package juegos.cartas.cartas.cartas.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;

/**
 * Crea dominios concretos de valores y palos de las cartas espaniola y francesa
 * con palos tipo string
 * @author victor
 *
 */
public class FactDominiosCartas 
{
	
	public Dominio<Integer> getDominioNumericoCartasEspaniolas()
	{
		FactComparator<Integer> fComp= new FactComparator<>();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<8;i++)
			valores.add(i);
		
		for(int i=10;i<13;i++)
			valores.add(i);
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
	
	public Dominio<String> getDominioPalosCartasEspaniolas()
	{
		return new Dominio<>(Set.of("oros","copas","espadas","bastos"),
				new FactComparator<String>().creaComparadorDeComparable());
		
	}

	public Dominio<String> getDominioPalosCartasFrancesa() {
		return new Dominio<>(Set.of("diamantes","picas","corazones","treboles"),new FactComparator<String>().creaComparadorDeComparable());
		
	}

	public Dominio<Integer> getDominioNumericoCartasFrancesa() {
		FactComparator<Integer> fComp= new FactComparator<>();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<14;i++)
			valores.add(i);
		
		
			
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		dom.getGetterByAlias().cambiarAlias(11, "J");
		dom.getGetterByAlias().cambiarAlias(12, "Q");
		dom.getGetterByAlias().cambiarAlias(13, "K");

		
		
		return dom;
	}
	
	/*public GetterByAlias<Integer> getAliasFrances(Collection<> coll)
	{
		GetterByAlias<Integer> getter= new GetterByAliasSimpleMap<>(coll) 
	}*/
}
