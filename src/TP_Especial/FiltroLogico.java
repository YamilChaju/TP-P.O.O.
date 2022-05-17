package TP_Especial;

public abstract class FiltroLogico implements Filtro {
	Filtro filtro1;
	Filtro  filtro2;
	public FiltroLogico(Filtro filtro1, Filtro filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	public void setFiltro1(Filtro filtro1) {
		this.filtro1 = filtro1;
	}
	public void setFiltro2(Filtro filtro2) {
		this.filtro2 = filtro2;
	}
	public abstract boolean Operacion(SeguroSimple comparado);
	public boolean Cumple(SeguroSimple comparado){
		return Operacion(comparado);
	}
}
