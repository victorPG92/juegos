package juegos.cartas.cartas.cartas;

/**
 * La marca se hace en la carta, asi se puede acceder con una matriz de forma constante, 
 * y para la lista, se comprueba si está marcada para poder usarla
 * @author vpenit
 *
 */
public interface ICartaMarcada
{

	
	public void setMarcada(boolean marcada);
	public boolean isMarcada();
}
