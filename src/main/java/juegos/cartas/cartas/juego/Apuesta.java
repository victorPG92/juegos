package juegos.cartas.cartas.juego;

/**
 * Accion en la que se apuesta(puede apostar):
 * se tiene la accion a realizar y la cantidad de fichas
 * @author victor
 *
 */
public class Apuesta <A extends AccionJuego> implements AccionJuego
{
	A accion;
	int fichas=0;//apuesta inicial es 0
	
	
	
	public Apuesta(A accion) {
		super();
		this.accion = accion;
	}

	public Apuesta(A accion, int fichas) {
		super();
		this.accion = accion;
		this.fichas = fichas;
	}

	public A getAccion() {
		return accion;
	}

	public void setAccion(A accion) {
		this.accion = accion;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	
	@Override
	public String toString() {
		return accion.toString()+(fichas>0?"("+fichas+")":"");
	}
	
	

}
