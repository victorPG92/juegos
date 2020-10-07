package juegos.cartas.cartas.mesas;

import juegos.cartas.cartas.cartas.ICartaComparable;

/**
 * En una mesa, es el lugar donde va una carta
 * indica si la carta esta boca arriba o boca abajo
 * @author victor
 *
 */
public class CeldaCartaMesa <C extends ICartaComparable>
{
	
	private C carta;
	private boolean bocaArriba;
	
	public CeldaCartaMesa(C carta, boolean bocaArriba) {
		super();
		this.carta = carta;
		this.bocaArriba = bocaArriba;
	}

	public final C getCarta() {
		return carta;
	}

	public final void setCarta(C carta) {
		this.carta = carta;
	}

	public final boolean isBocaArriba() {
		return bocaArriba;
	}

	public final void setBocaArriba(boolean bocaArriba) {
		this.bocaArriba = bocaArriba;
	}
	
	
	

}
