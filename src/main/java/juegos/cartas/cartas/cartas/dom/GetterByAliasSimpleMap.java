package juegos.cartas.cartas.cartas.dom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GetterByAliasSimpleMap<T> implements GetterByAlias<T> {

	Map<String,T> mapAlias= new HashMap<>();
	Map<T,String> mapString= new HashMap<>();

	public GetterByAliasSimpleMap(Collection<T> coll)
	{
		for(T t: coll)
		{
			if(t!=null)
			{
				String toS=t.toString();
				mapAlias.put(toS,t);
				mapString.put(t,toS);

			}
		}
	}
	
	@Override
	public T getByAlias(String alias) {
		
		return mapAlias.get(alias);
	}

	@Override
	public boolean existsAlias(String alias) {
		return mapAlias.containsKey(alias);
		//return getByAlias(alias)!=null;
	}

	@Override
	public String toString(T t) {
		return mapString.get(t);
	}
	
	

}
