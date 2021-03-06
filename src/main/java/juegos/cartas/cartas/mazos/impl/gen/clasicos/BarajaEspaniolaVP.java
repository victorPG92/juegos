package juegos.cartas.cartas.mazos.impl.gen.clasicos;

import juegos.cartas.cartas.cartas.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasDeshacer;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;

public interface BarajaEspaniolaVP <C extends ICartaNumeroPaloEspaniola<N, P>,N,P> 
extends 
MazoCartasSimple<C>,
MazoCartasExtraccionConcreta<C>, 
MazoConsulta<C>,
MazoInsercion<C>,
MazoCartasDeshacer<C>
{
	
}
