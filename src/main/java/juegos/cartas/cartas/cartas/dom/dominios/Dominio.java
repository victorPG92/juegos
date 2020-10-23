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
	
	/** para evitar un list.indexOf() : flexible, puede ser mapa, o esa funcion, etc*/
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


	/**
	 * Devuelve el elemento en la posicion i
	 * @param i
	 * @return
	 */
	public V get(int i)
	{
		return values.get(i);
	}
	
	/**
	 * Devuelve el elemento con el posible alias 
	 * @param i
	 * @return
	 */
	public V get(String alias)
	{
		return getterByAlias.getByAlias(alias);
	}
	
	/**
	 * Convierte a string el elemento v
	 * @param v
	 * @return
	 */
	public String toString(V v)
	{
		return getterByAlias.toString(v);
	}
	
	/**
	 * Devuelve la posicion en la que se encuentra el elemento v
	 * @param v
	 * @return
	 */
	public int indexOf(V v)
	{
		return indexer.indexOf(v);
	}
	
	/**
	 * Devuelve el numero de elementos del dominio
	 * @return
	 */
	public int size()
	{
		return values.size();
	}
	
	
	

	/**
	 * Indica la diferencia de posiciones entre los elementos
	 * (sig-v1)
	 * @param v1
	 * @param sig
	 * @return
	 */
	public Integer dif(V v1, V sig)
	{
		int i1=indexOf(v1);
		if(i1==-1)
			return null;
		int i2= indexOf(sig);
		if(i2==-1)
			return null;
		return i2-i1; 
		//throw new Unsupported
	}
	
	/**
	 * Indica si sig es elemento siguiente a v1
	 * @param v1
	 * @param sig
	 * @return
	 */
	public boolean esSig(V v1, V sig)
	{
		Integer diff= dif(v1,sig);
		
		return diff!=null && diff==1;
	}
	
	/**
	 * Indica si ant es elemento siguiente a v1
	 * @param v1
	 * @param ant
	 * @return
	 */
	public boolean esAnt(V v1, V ant)
	{
		Integer diff= dif(v1,ant);
		
		return diff!=null && diff==-1;
					
	}
	
	/**
	 * Desde el elemento v1, avanza pos posiciones en el dominio
	 * @param v1
	 * @param pos
	 * @return
	 */
	public V avanzaPos(V v1,int pos)
	{
		int i1=indexOf(v1);
		int iSig=i1+pos;
		if(iSig==values.size())
			return null;
		else
			return values.get(iSig);
		
		
	}
	
	/**
	 * Devuelve el elemento siguiente
	 * @param v1
	 * @return
	 */
	public V sig(V v1)
	{return avanzaPos(v1, 1);}
	
	/**
	 * Devuelve el elemento anterior
	 * @param v1
	 * @return
	 */
	public V ant(V v1)
	{return avanzaPos(v1, -1);}
	
	
	/**
	 * Devuelve el primer elemento del dominio
	 * @param v1
	 * @return
	 */
	public V first()
	{
		if(values.isEmpty())
			return null;
		return values.get(0);
	}
	
	/**
	 * Devuelve el ultimo elemento del dominio
	 * @param v1
	 * @return
	 */
	public V last()
	{
		if(values.isEmpty())
			return null;
		return values.get(values.size()-1);
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
	
	
	
	
}
