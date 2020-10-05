package juegos.cartas.cartas.cartas.dom.dominios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import juegos.cartas.cartas.cartas.dom.alias.GetterByAlias;
import juegos.cartas.cartas.cartas.dom.alias.GetterByAliasSimpleMap;
import juegos.cartas.cartas.cartas.dom.indexer.Indexer;
import juegos.cartas.cartas.cartas.dom.indexer.IndexerByPosition;
import juegos.cartas.cartas.utils.MazoUtils;

/**
 * Dominio de un tipo V
 * Contiene los valores posibles para una entidad
 * Se debe definir, la forma de indexar los elementos
 * acceder a los elementos a través de un alias
 * un comparador 
 * @author victor
 *
 * @param <V>
 */
public class Dominio<V> implements Iterable<V>
{

	protected List<V> values= new ArrayList<>();
	
	protected Indexer<V> indexer;
		
	protected GetterByAlias<V> getterByAlias;
	
	protected Comparator<V> comparator ;
	
	
	/*
	public DominioComp(List<V> values, Indexer<V> indexer, GetterByAlias<V> getterByAlias, Comparator<V> comparator) {
		super();
		this.values = values;
		this.indexer = indexer;
		this.getterByAlias = getterByAlias;
		this.comparator = comparator;
	}*/

	/*
	public DominioComp(Set<V> valoresDiferentes,Comparator<V> comp)
	{
		
		values.addAll(valoresDiferentes);
		
		comparator=comp;
		
		/*
		for(int i=0;i<values.size();i++)
		{
			V value=values.get(i);
			
		//	indexes.put(value, i);
		//	aliasesId.put(value.toString(), value);
			
				
			
		}*/
	/*
		V value=values.get(0);
		
		/*
		if(value instanceof Comparable<?>)
		{
		
			/*
			comparator= new Comparator<V>()
			{
				public int compare(V v1,V v2)
				{
					return ((Comparable<V>)v1).compareTo(v2);
				}
			};
			*/
		/*	comparator= (V v1,V v2)->((Comparable<V>)v1).compareTo(v2);
		}
		else
		{
			comparator= (V v1,V v2)->Integer.compare(indexOf(v1),indexOf(v2));
		}*/
	
	
		
		
		
		
		
	public Dominio(List<V> values, Indexer<V> indexer, GetterByAlias<V> getterByAlias, Comparator<V> comparator) {
		super();
		this.values = values;
		this.indexer = indexer;
		this.getterByAlias = getterByAlias;
		this.comparator = comparator;
	

	}
	
	
	public Dominio(Set<V> of, Comparator<V> comp)
	{		
		this(MazoUtils.toList(of),comp);
	}
	
	public Dominio(List<V> of, Comparator<V> comp)
	{	
	
		values=of;
		indexer= new IndexerByPosition<>(values);
		getterByAlias= new GetterByAliasSimpleMap<>(values);		
		comparator=comp;
		
	}


	public V get(int i)
	{
		return values.get(i);
	}
	
	public V get(String alias)
	{
		return getterByAlias.getByAlias(alias);
	}
	
	public int indexOf(V v)
	{
		return indexer.indexOf(v);
	}
	
	public int size()
	{
		return values.size();
	}
	
	
	public final Comparator<V> getComparator() {
		return comparator;
	}


	public final void setComparator(Comparator<V> comparator) {
		this.comparator = comparator;
	}


	public final List<V> getValues() {
		return values;
	}

	public final void setValues(List<V> values) {
		this.values = values;
	}

	@Override
	public Iterator<V> iterator() {
		
		return values.iterator();
	}


	public final Indexer<V> getIndexer() {
		return indexer;
	}


	public final void setIndexer(Indexer<V> indexer) {
		this.indexer = indexer;
	}


	public final GetterByAlias<V> getGetterByAlias() {
		return getterByAlias;
	}


	public final void setGetterByAlias(GetterByAlias<V> getterByAlias) {
		this.getterByAlias = getterByAlias;
	}
	
	
	
	
	
}
