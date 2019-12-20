package com.ipartek.formacion.endika.model;

public class Libro {
	
	private int id;
	private String nombre; // Minimo 2 letras, maximo 150 
	private String autor;
	private String imagen;
	private float precio; // Mayor que 0 y con dos decimales
	private int descuento; // Entre 0 y 100
	
	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.autor = "Anonimo";
		this.imagen = "https://cdn.pixabay.com/photo/2016/09/09/14/29/help-1657279_960_720.png";
		this.precio = 0;
		this.descuento = 0;
	}
	
	public Libro(int id, String nombre, String autor, String imagen, float precio, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.imagen = imagen;
		this.precio = precio;
		this.descuento = descuento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	// Metodo que calcula el precio aplicando el descuento
	
	public float calcularPrecioDescuento() {
		
		float precioDescuento = 0;
		
		precioDescuento = (precio - ((precio*descuento)/100));
		
		return precioDescuento;
	}
	
	// Metodo qu se encarga de formatear el precio
	// Cambia los "." del float por ","
	// En caso de que el precio sea mayor de 999, se pondran los "." necesarios para indicar el valor correctmanete, ej: 1000 -> 1.000
	
	public String precioFormateado() {
		
		String numFormat = null;
		
		if(Float.toString(this.precio).contains("."))
		{
	
			String[] numPartes = Float.toString(this.precio).split("\\.");
			
			if (numPartes[0].length() <= 3) {
				
				numFormat = numPartes[0] + "," + numPartes[1];
				
			}
			
			if(numPartes[0].length() == 4 || (numPartes[0].length() >=4 && numPartes[0].length() <=6)) {

				String cadenaAntesPunto = numPartes[0].substring(0, numPartes[0].length()-3);		
				String cadenaDespuesPunto = numPartes[0].substring(numPartes[0].length()-3, numPartes[0].length());	
				
				numFormat = cadenaAntesPunto + "." + cadenaDespuesPunto + "," + numPartes[1];	
					
			}
			
			if (numPartes[0].length() >= 7){
				
				String cadenaAntesPrimerPunto = numPartes[0].substring(0, numPartes[0].length()-6);						
				String cadenaAntesSegundoPunto = numPartes[0].substring(numPartes[0].length()-6, numPartes[0].length()-3);		
				String cadenaDespuesSegundoPunto = numPartes[0].substring(numPartes[0].length()-3, numPartes[0].length());					
				
				numFormat = cadenaAntesPrimerPunto + "." + cadenaAntesSegundoPunto + "." + cadenaDespuesSegundoPunto + "," + numPartes[1];
				
			} 
			
		} else {
			
			if(Float.toString(this.precio).length() >= 4 && Float.toString(this.precio).length() <=6 ) {
				
				String cadenaAntesPunto = Float.toString(this.precio).substring(0, Float.toString(this.precio).length()-3);		
				String cadenaDespuesPunto = Float.toString(this.precio).substring(Float.toString(this.precio).length()-3, Float.toString(this.precio).length());	
				
				numFormat = cadenaAntesPunto + "." + cadenaDespuesPunto;
				
			} 
			
		}
		
		return numFormat;
		
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", imagen=" + imagen + ", precio="
				+ precio + ", descuento=" + descuento + "]";
	}

}
