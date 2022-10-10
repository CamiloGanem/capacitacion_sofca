package corp.data.data.dto;

public class Producto {
    private int codigo_prod;
    private String nombre_prod;
    private String descripcion_prod;
    private String imagen_prod;
    private double precio_prod;
    private int cantidad_prod;
    private int cod_marca;
    private int tipo_masco;

    public Producto() {
    }

    public int getCodigo_prod() {
        return codigo_prod;
    }

    public void setCodigo_prod(int codigo_prod) {
        this.codigo_prod = codigo_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public String getImagen_prod() {
        return imagen_prod;
    }

    public void setImagen_prod(String imagen_prod) {
        this.imagen_prod = imagen_prod;
    }

    public double getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(double precio_prod) {
        this.precio_prod = precio_prod;
    }

    public int getCantidad_prod() {
        return cantidad_prod;
    }

    public void setCantidad_prod(int cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public int getTipo_masco() {
        return tipo_masco;
    }

    public void setTipo_masco(int tipo_masco) {
        this.tipo_masco = tipo_masco;
    }
}
