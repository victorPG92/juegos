package juegos.cartas.cartas.cartas.dom;

import java.util.ArrayList;
import java.util.List;

public class GetterByAliasComp<T> implements GetterByAlias<T>
{
	List<GetterByAlias<T>> getters= new ArrayList<>();

	@Override
	public T getByAlias(String alias) 
	{
		//el orden importa
		for (GetterByAlias<T> getterByAlias : getters) {
			if(getterByAlias.existsAlias(alias))
				return getterByAlias.getByAlias(alias);
		}
		return null;
	}

	@Override
	public boolean existsAlias(String alias) {
	
		return getters.stream().anyMatch(g->g.existsAlias(alias));
	}

	@Override
	public String toString(T t) {
		for (GetterByAlias<T> getterByAlias : getters)
		{
			String s=getterByAlias.toString(t);
			if(s!=null)
				return s;
		}
		return "";
	}

	
}
