package TP_Especial;

public class FiltroOR extends FiltroLogico{

	public FiltroOR(Filtro filtro1, Filtro filtro2) {
		super(filtro1, filtro2);
	}
	@Override
	public boolean Operacion(SeguroSimple comparado) {
		return (this.filtro1.Cumple(comparado) || this.filtro2.Cumple(comparado));
	}
}
