package juegos.cartas.cartas.cartas.dom;

import java.util.Comparator;

/**
 * Crea comparadores
 * @author victor
 *
 * @param <V>
 */
public class FactComparator<V> {

	
	public Comparator<V> creaComparadorDeComparable()
	{
		return  (V v1,V v2)->((Comparable<V>)v1).compareTo(v2);
	}
	public Comparator<V> creaComparadorOrdenDominio(Dominio<V> dom)
	{
		return (V v1,V v2)->Integer.compare(dom.indexOf(v1),dom.indexOf(v2));
	}

	
}
