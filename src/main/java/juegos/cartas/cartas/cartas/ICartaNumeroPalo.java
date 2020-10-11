package juegos.cartas.cartas.cartas;

/**
 * Carta con 2 caracteristicas, valor y palo
 * los cuales pueden son parametrizables
 * esta implementada la igualdad
 * ( primero se compara el palo y
 *  luego el numero 
 *  por suposicion que hay menos palos que numeros)
 * @author victor
 *
 * @param <N>
 * @param <P>
 */
public interface ICartaNumeroPalo<N,P> extends ICartaComparable
{

	

	public N getNumero();

	public P getPalo();
	
	
	public void setNumero(N numero) ;

	public void setPalo(P palo);

	
	
	
	
}
