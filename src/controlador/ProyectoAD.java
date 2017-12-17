package controlador;

import modelo.utils.InterfaceHibernate;
import vista.VPrincipal;

public class ProyectoAD {

	public static void main(String[] args) {
		// El proyecto debe arrancar desde aquí
		
		//Instanciamos el interfaceHibernate para conseguir un sessionfactory
		InterfaceHibernate ih = new InterfaceHibernate();
		
		//abrimos la ventana principal
		VPrincipal vp = new VPrincipal();
		vp.setVisible(true);
	}

}
