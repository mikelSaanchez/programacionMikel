package modelo;

public class ProductoDTO {

	private int id;
	private String nombre;
	private double precio;
	private int stock;
	private int idCategoria;
	private String categoria; // NUEVO ATRIBUTO

	public ProductoDTO(int id, String nombre, double precio, int stock, int idCategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
	}

	public ProductoDTO(int id, String nombre, double precio, int stock, int idCategoria, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}
	
	public ProductoDTO(String nombre, double precio, int stock, int idCategoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
