package juegos.cartas.cartas.cartas.dom;

/**
 * Obtiene el objeto a traves de su alias
 * @author victor
 *
 * @param <T>
 */
public interface GetterByAlias<T>
{
	
	/**
	 *  * Obtiene el objeto a traves de su alias

	 * @param alias
	 * @return
	 */
	public T getByAlias(String alias);
	
	/**
	 *  Comprueba si existe un objeto para ese alias

	 * @param alias
	 * @return
	 */
	public boolean existsAlias(String alias);
	
	
	/**
	 * Transforma en String un elemento
	 * @param t
	 * @return
	 */
	public String toString(T t); 

}
