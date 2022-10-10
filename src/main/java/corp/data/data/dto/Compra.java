package corp.data.data.dto;

import java.sql.Date;

public class Compra {
    private int codigo_compra;
    private Date fecha_compra;
    private double total_compra;
    private int iden_cliente;

    public Compra() {
    }

    public int getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(int codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(double total_compra) {
        this.total_compra = total_compra;
    }

    public int getIden_cliente() {
        return iden_cliente;
    }

    public void setIden_cliente(int iden_cliente) {
        this.iden_cliente = iden_cliente;
    }
}
