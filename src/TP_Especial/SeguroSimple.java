package TP_Especial;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public class SeguroSimple extends Seguro {
	private static final String AUX = "costo";
	private static final String AUX1 = "tipoSeguro";
	private static final String AUX2 = "numPoliza";
	private Hashtable<String, Comparable> atributos;
	@Override
	public double getCosto() {
		return (double) this.getAtributo(AUX);
	}
	
	public SeguroSimple (double Costo, String Tipo, int NumPoliza) {
		atributos = new Hashtable<>();
		atributos.put(AUX, Costo);
		atributos.put(AUX1, Tipo);
		atributos.put(AUX2, NumPoliza);
		this.numPoliza = NumPoliza;
	}
	public void addAtributo(String key, Comparable value) {
		if (atributos.containsKey(key)){
			atributos.remove(key);
			atributos.put(key, value);
		}else
			atributos.put(key, value);
	}
	public Comparable getAtributo(String key) {
		if (atributos.containsKey(key))
			return atributos.get(key);
		else
			return null;
	}
	
	public Seguro getCopia() {
		SeguroSimple copiado = new SeguroSimple(this.getCosto(),(String)this.getAtributo(AUX1),this.getNumPoliza());
		Set<String> llaves=atributos.keySet();
		for(String k:llaves)
		{
			copiado.addAtributo(k, this.getAtributo(k));
		}
		return copiado;
	}
	
	public ArrayList<Seguro> filtrar(Filtro actual){
		ArrayList<Seguro> temporal = new ArrayList<>();
		if(actual.Cumple(this)) {
			temporal.add(this.getCopia());
			return temporal;
		}else
			return null;
	}
	
}
