package TP_Especial;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
	        SeguroSimple s1 = new SeguroSimple(1200, "Empleado" , 2324);
	        
	        s1.addAtributo("nombreyapellido","Lionel Messi");
	        s1.addAtributo("clubactual","Barcelona");
	        s1.addAtributo("puesto","Delantero");
	        s1.addAtributo("edad",30);

	        SeguroSimple s2 = new SeguroSimple(1000, "Empleado" , 2325);
	        
	        s2.addAtributo("nombreyapellido","Gonzalo Higuain");
	        s2.addAtributo("clubactual","Juventus");
	        s2.addAtributo("puesto","Delantero");
	        s2.addAtributo("edad",30);
	        

	        SeguroSimple s3 = new SeguroSimple(234, "Hogar" , 5632);
	        
	        s3.addAtributo("direccion","España 1234");
	        s3.addAtributo("edad",47);
	        s3.addAtributo("tipo","Casa");

	        
	        SeguroSimple s4 = new SeguroSimple(187,"Automotor",4564);
	        
	        s4.addAtributo("modelo","2014");
	        s4.addAtributo("edad",4);
	        s4.addAtributo("tipo","4 puertas");

	        
	        SeguroSimple s5 = new SeguroSimple(1100,"Empleado",2354);

	        s5.addAtributo("nombreyapellido","Sergio Agüero");
	        s5.addAtributo("clubactual","Manchester City");
	        s5.addAtributo("puesto","Delantero");
	        s5.addAtributo("edad",29);

	        SeguroSimple s6 = new SeguroSimple(350,"Empleado",5678);

	        s6.addAtributo("nombreyapellido","Jorge Sampaoli");
	        s6.addAtributo("puesto","Tecnico");
	        s6.addAtributo("edad",58);

	        SeguroSimple s7 = new SeguroSimple(450,"Empleado",1214);
	        
	        s7.addAtributo("nombreyapellido","Cristian Ansaldi");
	        s7.addAtributo("clubactual","Torino");
	        s7.addAtributo("puesto","defensor");
	        s7.addAtributo("edad",31);

	        SeguroSimple s8 = new SeguroSimple(194,"Automotor",2160);

	        s8.addAtributo("modelo","2008");
	        s8.addAtributo("edad",10);
	        s8.addAtributo("tipo","Coupe");

	        

	        SeguroCompuesto sIntegrador1 = new SeguroCompuesto(20,10);
	        
	        sIntegrador1.addSeguro(s8);
	        sIntegrador1.addSeguro(s4);
	       
	        SeguroCompuesto sIntegrador2 = new SeguroCompuesto(20,11);
	        
	        sIntegrador2.addSeguro(s1);
	        sIntegrador2.addSeguro(s2);
	        sIntegrador2.addSeguro(s7);
	        sIntegrador2.addSeguro(s5);
	        sIntegrador2.addSeguro(s6);

	        Date fechaInicio = new Date(2018,6,14);

	        Date fechaFin = new Date(2018, 7, 15);

	        SeguroEspecial viajero=new SeguroEspecial(sIntegrador2, fechaInicio, fechaFin, 20, 12);

	       

	        SeguroCompuesto sIntegrador3 = new SeguroCompuesto(17, 13);
	        
	        sIntegrador3.addSeguro(s3);
	        sIntegrador3.addSeguro(s6);
	        sIntegrador3.addSeguro(s8);
	        
	        // Se crea este vector generico para poder listar
	        ArrayList<Seguro> seguros = new ArrayList<>();	        
	        seguros.add(s1);
	        seguros.add(s2);
	        seguros.add(s3);
	        seguros.add(s4);
	        seguros.add(s5);
	        seguros.add(s6);
	        seguros.add(s7);
	        seguros.add(s8);
	        seguros.add(sIntegrador1);
	        seguros.add(sIntegrador2);
	        seguros.add(sIntegrador3);
	        seguros.add(viajero);


	        ArrayList<Seguro> segurosFiltrados = new ArrayList<>();
	        
	        double elprecio=600;
	        double elotroprecio=1100;

	        FiltroIgual a=new FiltroIgual("tipoSeguro","Automotor");
	        FiltroIgual b=new FiltroIgual("puesto","Delantero");
	        FiltroMayor c=new FiltroMayor("costo",elprecio);	        
	        FiltroMayor d=new FiltroMayor("costo",elotroprecio);
	        
	        
	        FiltroAND e=new FiltroAND(b,d);
	        
	        FiltroIgual f=new FiltroIgual("tipoSeguro","Empleado");
	        
	        FiltroAND g=new FiltroAND(f, e);
	        
	        
	        

	        for(Seguro aux : seguros) // a)
	        	if (aux.filtrar(a) != null)
	            	segurosFiltrados.addAll(aux.filtrar(a));
	        System.out.println("");
	        System.out.println("FILTRADOS POR SEGURO AUTOMOTOR");
	        for(Seguro aux: segurosFiltrados)
	            System.out.println(aux.getNumPoliza());

	        segurosFiltrados = new ArrayList<>();
	        for(Seguro aux : seguros) // b)
	        	if (aux.filtrar(b) != null)
	        		segurosFiltrados.addAll(aux.filtrar(b));
	        System.out.println("");
	        System.out.println("FILTRADOS POR PUESTO DELANTERO");
	        for(Seguro aux: segurosFiltrados)
	            System.out.println(aux.getNumPoliza());

	        segurosFiltrados = new ArrayList<>();
	        for(Seguro aux : seguros) // c)
	        	if (aux.filtrar(c) != null)
	        		segurosFiltrados.addAll(aux.filtrar(c));
	        
	        System.out.println("");
	        System.out.println("FILTRADOS POR COSTO > 600");
	        for(Seguro aux: segurosFiltrados)
	            System.out.println(aux.getNumPoliza());

	        segurosFiltrados = new ArrayList<>();
	        for(Seguro aux : seguros) // d)
	        	if (aux.filtrar(g) != null)
	        		segurosFiltrados.addAll(aux.filtrar(g));
	        
	        System.out.println("");
	        System.out.println("FILTRADOS POR EMPLEADO&&DELANTERO&&>1100");
	        for(Seguro aux: segurosFiltrados)
	            System.out.println(aux.getNumPoliza());

	        
	    }


	}


