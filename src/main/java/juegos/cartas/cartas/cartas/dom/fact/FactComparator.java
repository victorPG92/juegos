package juegos.cartas.cartas.cartas.dom.fact;

import java.util.Comparator;

import juegos.cartas.cartas.cartas.dom.dominios.Dominio;

/**
 * Crea comparadores
 * @author victor
 *
 * @param <V>
 */
public class FactComparator {

	
	public <V extends Comparable<V>> Comparator<V> creaComparadorDeComparable()
	{
		return  (V v1,V v2)->(v1.compareTo(v2));
	}
	public <V> Comparator<V> creaComparadorOrdenDominio(Dominio<V> dom)
	{
		return (V v1,V v2)->Integer.compare(dom.indexOf(v1),dom.indexOf(v2));
	}

	
}
