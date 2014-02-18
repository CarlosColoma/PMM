package com.example.examencarloscoloma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultado extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		
		TextView txtnombre = (TextView)findViewById(R.id.textView1);

		Bundle bundle = getIntent().getExtras();
		
		txtnombre.setText(bundle.getString("VALOR")+"\n"+(bundle.getString("TARIFA"))
				+"\nPrecio: "+(bundle.getDouble("PESO")));
		
		//obtener precio
		final double precio = bundle.getDouble("PESO");
		
		//Dinero:
		final EditText dinero =(EditText)findViewById(R.id.cash);
		
		dinero.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		dinero.setText("");
        	}
        });
		final double dineros = bundle.getDouble("cash");
		
		
		//Boton con función
		final Button calc = (Button)findViewById(R.id.button2);
		
		
		calc.setOnClickListener(new OnClickListener(){
			TextView camb = (TextView)findViewById(R.id.cambit);
			Bundle bundle = getIntent().getExtras();
			
        	public void onClick(View v){
        		double cambio;
        		double quinien;
        		double doscien;
        		double cien;
        		double cinc;
        		double veint;
        		double diez;
        		double five;
        		cambio = precio - dineros;
        		
        		quinien = cambio / 500;
        		cambio = cambio % 500;
        		
        		doscien = cambio / 200;
        		cambio = cambio % 200;
        		
        		cien = cambio / 100;
        		cambio = cambio % 100;
        		
        		cinc = cambio / 50;
        		cinc = cambio % 50;
        		
        		veint = cambio / 20;
        		cambio = cambio % 20;
        		
        		diez = cambio / 10;
        		cambio = cambio % 10;
        		
        		five = cambio / 5;
        		cambio = cambio % 5;
        		
        		
        		camb.setText("El cambio a percibir es: "+quinien+" Billetes de 500 \n"
        				+doscien+" Billetes de 200 \n "+cien+" Billetes de 100 \n"
        				+cinc+" Billetes de 50 \n"+veint+" Billetes de 20 \n"
        				+diez+" Billetes de 10 \n "+five+" Billetes de 5 \n y "+cambio+" En monedas");
        	}
        });

	}
}
