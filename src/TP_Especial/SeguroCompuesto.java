package TP_Especial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class SeguroCompuesto extends Seguro{
	private Vector <Seguro> asegurados;
	private double descuento;
	@Override
	public double getCosto() {
		double suma = 0;
		for (Seguro s: asegurados) {
			suma += s.getCosto();
		}
		return (suma - (suma*descuento/100));
	}
	public SeguroCompuesto(double descuento, int numPoliza) {
		asegurados = new Vector <>();
		this.descuento = descuento;
		this.numPoliza = numPoliza;
	}
	public Seguro getSeguro(int posicion) {
		return asegurados.elementAt(posicion);
	}
	public void addSeguro(Seguro seguro) {
		asegurados.addElement(seguro);
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
	
	@Override
	public ArrayList<Seguro> filtrar(Filtro actual) {
		ArrayList<Seguro> temporal = new ArrayList<>();
		ArrayList<Seguro> aux = new ArrayList<>();
		for(Seguro c:asegurados) {
			if(c.filtrar(actual)!=null)
				temporal=c.filtrar(actual);
			if (temporal.isEmpty()!=true){	
				aux.addAll(temporal);
			}
			temporal.clear();
		}
		return aux;
	}
	

}

