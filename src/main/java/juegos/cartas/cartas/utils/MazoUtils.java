package juegos.cartas.cartas.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.MazoConsulta;

/**
 * Clase utilidad
 * @author victor
 *
 */
public class MazoUtils
{
	/**
	 * Transforma una coleccion en una lista
	 * @param <T>
	 * @param coll
	 * @return
	 */
	public static <T> List<T> toList(Collection<T> coll)
	{
		List<T> list= new ArrayList<>();
		list.addAll(coll);
		
		return list;
	}
	/*
	public static String vaciartoString(MazoCartasSimple mazo)
	{
		while(mazo.isEmpty())
		{
			
		}
	}*/

}
