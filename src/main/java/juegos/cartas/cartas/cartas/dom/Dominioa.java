package juegos.cartas.cartas.cartas.dom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
public class Dominio<V> implements Iterable<V>
{

	protected List<V> values= new ArrayList<>();
	
	protected Map<V,Integer> indexes= new HashMap<>();
	
	protected Map<String,V> aliasesId= new HashMap<>();

	protected Comparator<V> comparator ;
	
	public Dominio(Set<V> valoresDiferentes,Comparator<V> comp)
	{
		
		values.addAll(valoresDiferentes);
		
		comparator=comp;
		
		
		for(int i=0;i<values.size();i++)
		{
			V value=values.get(i);
			
			indexes.put(value, i);
			aliasesId.put(value.toString(), value);
			
				
			
		}
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
	
	
		
		
		
		/*
		
	}
	
	
	public V get(int i)
	{
		return values.get(i);
	}
	
	public V get(String alias)
	{
		return aliasesId.get(alias);
	}
	
	public int indexOf(V v)
	{
		System.out.println("buscando indice de " +v+indexes.get(v));
		return indexes.get(v);
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

	public final Map<V, Integer> getIndexes() {
		return indexes;
	}

	public final void setIndexes(Map<V, Integer> indexes) {
		this.indexes = indexes;
	}

	public final Map<String, V> getAliasesId() {
		return aliasesId;
	}

	public final void setAliasesId(Map<String, V> aliasesId) {
		this.aliasesId = aliasesId;
	}

	@Override
	public Iterator<V> iterator() {
		
		return values.iterator();
	}
	
	
	
	
	
}*/
