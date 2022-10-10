package corp.data.data.dto;

public class Cliente {
    private int identificacion_cliente;
    private String nombre_cliente;
    private String apellido1_cliente;
    private String apellido2_cliente;
    private String correo_cliente;
    private String direccion_cliente;

    public Cliente() {}

    public int getIdentificacion_cliente() {
        return identificacion_cliente;
    }

    public void setIdentificacion_cliente(int identificacion_cliente) {
        this.identificacion_cliente = identificacion_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido1_cliente() {
        return apellido1_cliente;
    }

    public void setApellido1_cliente(String apellido1_cliente) {
        this.apellido1_cliente = apellido1_cliente;
    }

    public String getApellido2_cliente() {
        return apellido2_cliente;
    }

    public void setApellido2_cliente(String apellido2_cliente) {
        this.apellido2_cliente = apellido2_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

}
