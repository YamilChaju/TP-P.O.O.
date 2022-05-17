package TP_Especial;

import java.util.ArrayList;


public abstract class Seguro {
	int numPoliza;
	
	public abstract double getCosto();
	
	public int getNumPoliza() {
		return numPoliza;
	}
	
	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}
	
	public abstract ArrayList<Seguro> filtrar(Filtro actual);
}
