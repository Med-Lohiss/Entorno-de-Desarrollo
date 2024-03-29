package es.iessoterohernandez.daw.endes.CuentaTarjeta;

import java.util.Date;

public class Debito extends Tarjeta {
	
	public Object mMovimientos;

	public Debito(String numero, String titular, Date fechaCaducidad) {
		super(numero, titular, fechaCaducidad);
	}

	public void retirar(double x) throws Exception {
		this.mCuentaAsociada.retirar("Retirada en cajero automático", x);
	}

	public void ingresar(double x) throws Exception {
		this.mCuentaAsociada.retirar("Ingreso en cajero automático", x);
	}

	public void pagoEnEstablecimiento(String datos, double x) throws Exception {
		this.mCuentaAsociada.retirar("Compra en :" + datos, x);
	}

	public double getSaldo() {
		return mCuentaAsociada.getSaldo();
	}
}