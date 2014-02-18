package com.example.examencarloscoloma;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int opcion;
	private int dinero;
	private int zona;
	private String textoRadioB;
	private String zonaElegida;
	private double resultadoTotal;
	private int zonaFinal;
	private String[] datos =
             new String[]{
			    new String("Zona A - Asia y Oceania"),
			    new String("Zona B - America y Africa"),
			    new String("Zona C - Europa")};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Spinner cmbOpciones = (Spinner)findViewById(R.id.spinner1);
		final Button botonCalculos = (Button)findViewById(R.id.button1);
		final RadioGroup grupoRadio =(RadioGroup)findViewById(R.id.radioGroup1);
		final EditText peso =(EditText)findViewById(R.id.editText1);

		
		

		 ArrayAdapter<String> adaptador =
		            new ArrayAdapter<String>(this,
		                android.R.layout.simple_spinner_item,datos);
		        
		        adaptador.setDropDownViewResource(
		                android.R.layout.simple_spinner_dropdown_item);
		         
		        cmbOpciones.setAdapter(adaptador);
	     

	        cmbOpciones.setOnItemSelectedListener(
	        	new AdapterView.OnItemSelectedListener() {
	                public void onItemSelected(AdapterView<?> parent,
	                    android.view.View v, int position, long id) {
	                	
	                	zonaFinal = position;
	                	zonaElegida = cmbOpciones.getItemAtPosition(position).toString();
	                      
	                }
	         
	                public void onNothingSelected(AdapterView<?> parent) {

	                }
	        });
	        
	        grupoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
		        public void onCheckedChanged(RadioGroup group, int seleccion) {

		        	int radioButtonID = grupoRadio.getCheckedRadioButtonId();
		        	
		        	View radioButton = grupoRadio.findViewById(radioButtonID);

		        	
		        	opcion = grupoRadio.indexOfChild(radioButton);
		        	
		        	
		        	RadioButton rb =(RadioButton)grupoRadio.getChildAt(opcion);
		        	textoRadioB =(String) rb.getText();

		        }
	        });
	        
	        
	        
	        peso.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v){
	        		peso.setText("");
	        	}
	        });
	        

	        
	        botonCalculos.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v){
	        		int id = peso.getId();
	        		String pesoIntroducido =peso.getText().toString();
	        		
	        		int numero = Integer.parseInt(pesoIntroducido);
	        		
	        		if(zonaFinal == 0){
	        			zona = 30;
	        		}else if(zonaFinal == 1){
	        			zona = 20;
	        		}else{
	        			zona = 10;
	        		}
	        		
	        		if(numero <= 5){
	        			resultadoTotal = 1 * numero * zona;
	        		}else if(numero <= 10 || numero >= 6){
	        			resultadoTotal = 1.5 * numero * zona;
	        		}else{
	        			resultadoTotal = 2 * numero * zona;
	        		}
	        		
	        		if(opcion == 0){
	        			
	        		}else{
	        			
	        		}


	        		Intent intent = new Intent(MainActivity.this,resultado.class);
	        		Bundle b = new Bundle();
	        		b.putString("VALOR", zonaElegida);
	        		b.putString("TARIFA", textoRadioB);
	        		b.putDouble("PESO", resultadoTotal);
	        		
	        		intent.putExtras(b);

					startActivity(intent);
	        	}
	        });
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.acercade:
        	Intent intent1 = new Intent(this,acercaDe.class);
        	startActivity(intent1);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}
