package corp.data.data.dto;

public class Producto_compra {
    private int id_prod_compra;
    private int cod_producto;
    private int cod_compra;
    private int cantidad_prod_compra;

    public Producto_compra() {
    }

    public int getId_prod_compra() {
        return id_prod_compra;
    }

    public void setId_prod_compra(int id_prod_compra) {
        this.id_prod_compra = id_prod_compra;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCod_compra() {
        return cod_compra;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public int getCantidad_prod_compra() {
        return cantidad_prod_compra;
    }

    public void setCantidad_prod_compra(int cantidad_prod_compra) {
        this.cantidad_prod_compra = cantidad_prod_compra;
    }
}
