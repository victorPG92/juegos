package juegos.cartas.cartas.cartas.dom.alias;

import java.util.ArrayList;
import java.util.List;

/**
  * Obtiene los alias de los valores del dominio y su representacion en string

 * Obtiene los alias a traves de varios getters ordenados
 * @author victor
 *
 * @param <T>
 */
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

	@Override
	public void cambiarAlias(T t, String s) {
		if(!getters.isEmpty())
			getters.get(0).cambiarAlias(t, s);		
	}

	
}
