package juegos.cartas.cartas.cartas.dom.alias;

/**
 * Obtiene el objeto a traves de su alias
  * Obtiene los alias de los valores del dominio y su representacion en string

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
	
	/**
	 * Cambia el alias de manera bidireccional
	 * @param t
	 * @param s
	 */
	public void cambiarAlias(T t, String s);

}
