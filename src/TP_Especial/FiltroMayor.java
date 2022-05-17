package TP_Especial;

public class FiltroMayor extends FiltroCaracteristica {

	public FiltroMayor(String key, Comparable actual) {
		super(key, actual);
	}
	@Override
	public boolean Operacion(SeguroSimple comparado) {
		if (comparado.getAtributo(key)!=null) {
			double aux = comparado.getAtributo(key).compareTo(umbral);
			if (aux > 0) return true;
			else return false;
		}
		else
			return false;
	}
	
}
