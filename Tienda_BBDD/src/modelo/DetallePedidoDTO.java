package modelo;

public class DetallePedidoDTO {

	private int idProducto;
	private int cantidad;
	private double precioUnitario;

	public DetallePedidoDTO(int idProducto, int cantidad) {
		this.idProducto = idProducto;
		this.cantidad = cantidad;

	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
