package TP_Especial;

public abstract class FiltroCaracteristica implements Filtro {
	Comparable umbral; 
	String key;
	public FiltroCaracteristica(String key,Comparable actual) {// key umbral y seguro
		this.umbral = actual;
		this.key=key;
	}
	public void setUmbral(Comparable caracteristica) {
		this.umbral = caracteristica;
	}
	
	public abstract boolean Operacion(SeguroSimple comparado);
	public boolean Cumple(SeguroSimple comparado) {
		return Operacion(comparado);
	}
} 