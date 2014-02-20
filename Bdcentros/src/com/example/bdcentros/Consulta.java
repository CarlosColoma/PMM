package com.example.bdcentros;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Consulta extends Activity {

private Centros[] datos;
	
	class AdaptadorCentro extends ArrayAdapter<Centros> 
	{
		Activity a;
		AdaptadorCentro(Activity b) 
		{
			super(b, R.layout.activity_listacentro, datos);
			this.a = b;
		}
		public View getDropDownView (int position,View convertView,ViewGroup parent) {
			
			
			return getView (position, convertView, parent);
			}
		public View getView(int position,View convertView,ViewGroup parent) 
		{
		
			LayoutInflater inflater = a.getLayoutInflater();	
			View item = inflater.inflate(R.layout.activity_listacentro, null);
			 	 	 
			final TextView lblCodigo=(TextView)item.findViewById(R.id.codigo);
			final TextView lblNombre = (TextView)item.findViewById(R.id.nombre);
			final TextView lblDireccion = (TextView)item.findViewById(R.id.direccion);
			
			lblNombre.setText(datos[position].getNomCentro());
			lblCodigo.setText(datos[position].getCodCentro());
			lblDireccion.setText(datos[position].getDireccion());
			
			return(item);
		}
	}  
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulta);
		final Button boton=(Button)findViewById(R.id.boton);
		
		
		try 
		{
			
			String[] campos = new String[] {"cod_centro","nombre","direccion"};
			
			CreateBD base=new CreateBD(this,"dbase",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			Cursor rs=db.query("centros", campos, null,null,null,null,null);
			
			datos=new Centros[rs.getCount()+1];
			datos[0]= new Centros("Codigos","Nombres","Direccion");
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		String cod=rs.getString(0);
	                		String nom=rs.getString(1);
	                        String dir=rs.getString(2);
	                        
	                        datos[i]=new Centros(cod,nom,dir);
	                        i++;       
	                }
	                while (rs.moveToNext());
	        }
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		final Spinner spinner=(Spinner)findViewById(R.id.centros);
		AdaptadorCentro adaptador =new AdaptadorCentro(this); 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		
		boton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(Consulta.this,insertcentros.class);
				startActivity(intent);
			}
		});
		
		
		boton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(Consulta.this,insertcentros.class);
				startActivity(intent);
			}
		});
		

	Button verPersonal = (Button)findViewById(R.id.verpersonal);
	verPersonal.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Consulta.this, Personal.class);
				
			startActivity(intent);
			
		}
	});
	Button verprofes = (Button)findViewById(R.id.verprofes);
	verprofes.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Consulta.this, Profesores.class);
			startActivity(intent);
			
		}
	});
	 Button editcentros = (Button)findViewById(R.id.editcentro);
	 editcentros .setOnClickListener(new OnClickListener() {
	 
	 	@Override
	 	public void onClick(View v) {
	 		Intent intent = new Intent(Consulta.this, editarcentros.class);
	 		startActivity(intent);
		}
	});
	 
	 Button editpers = (Button)findViewById(R.id.editpersonal);
	 editpers.setOnClickListener(new OnClickListener() {
	 
	 	@Override
	 	public void onClick(View v) {
	 		Intent intent = new Intent(Consulta.this, editpersona.class);
	 		startActivity(intent);
		}
	});
	}
}