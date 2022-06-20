package Parte2;

import java.util.Comparator;

public class ComparadorEtiqueta implements Comparator<Arco> {

	@Override
	public int compare(Arco a1, Arco a2) {
		return (a1.getEtiqueta() - a2.getEtiqueta());
	}

}
