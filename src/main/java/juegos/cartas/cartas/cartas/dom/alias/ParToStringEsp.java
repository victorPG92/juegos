package juegos.cartas.cartas.cartas.dom.alias;

//@Deprecated
/**
 * Obtiene la traduccion de un valor de un dominio, 
 * ahora se realiza con el alias GetterByAlias
 * @author victor
 *
 * @param <T>
 */
public class ParToStringEsp implements ParToString//<V,P> 
{
	
	String prep=" de ";
	public String toString(String num, String palo)
	{
		return num + prep + palo; 
	}

}
