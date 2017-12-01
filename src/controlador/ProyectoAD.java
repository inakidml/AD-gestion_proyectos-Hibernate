package controlador;

import modelo.utils.InterfaceHibernate;
import vista.VPrincipal;

public class ProyectoAD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceHibernate ih = new InterfaceHibernate();
		VPrincipal vp = new VPrincipal();
		vp.setVisible(true);
	}

}
