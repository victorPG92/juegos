package juegos.cartas.cartas.cartas.dom;

@Deprecated
/**
 * Obtiene la traduccion de un valor de un dominio, 
 * ahora se realiza con el alias GetterByAlias
 * @author victor
 *
 * @param <T>
 */
public interface ToString<T> 
{
	String toString(T t);

}
