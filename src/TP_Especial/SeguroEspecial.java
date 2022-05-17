package TP_Especial;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class SeguroEspecial extends Seguro {
	private Seguro asegurado;
    private Date inicio;
    private Date fin;
    private double montoExtra;
    private static final int valorDiscernible = 0;

    public SeguroEspecial(Seguro asegurado, Date inicio, Date fin, double montoExtra, int numPoliza) {
        this.asegurado = asegurado;
        this.inicio = inicio;
        this.fin = fin;
        this.montoExtra=montoExtra;
        this.numPoliza = numPoliza;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public double getMontoExtra() {
        return montoExtra;
    }

    public void setMontoExtra(double montoExtra) {
        this.montoExtra = montoExtra;
    }

    public boolean estaEnFecha(Date actual){
        if ((actual.compareTo(fin) == 1) && (actual.compareTo(inicio) == -1))
    		return true;
        else 
        	return false;
    }

    @Override
    public double getCosto() {
        Date actual=new Date();
        if(estaEnFecha(actual))
            return asegurado.getCosto()+(asegurado.getCosto()*montoExtra/100);
       else
            return valorDiscernible; 
    }

	@Override
	public ArrayList<Seguro> filtrar(Filtro actual) {
		Date ahora=new Date();
		if(estaEnFecha(ahora)) 
			return asegurado.filtrar(actual);
		else 
			return null;
	}
    
    
}
