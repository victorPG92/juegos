package juegos.cartas.cartas.cartas.dom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IndexerByPosition<T>  implements Indexer<T>{

	Map<T,Integer> indexes= new HashMap<>();
	
	public IndexerByPosition() {	}
	
	public IndexerByPosition(List<T> listT) {
		for(int i=0; i<listT.size();i++)
			indexes.put(listT.get(i), i);
	}
	
	

	public IndexerByPosition(Set<T> setT)
	{
		int i=0;
		for(T t: setT)
		{
			indexes.put(t, i);
			i++;
		}
		
		//setT.toArray()
		
		
		/*for(int i=0; i<setT.size();i++)
			indexes.put(setT.get(i), i);*/
	}
	
	@Override
	public int indexOf(T t) {
		
		return indexes.get(t);
	}

	
}
