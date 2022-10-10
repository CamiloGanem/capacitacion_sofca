package corp.data.data.dto;

public class Mascota {
    private int codigo_masco;
    private String nombre_masco;

    public Mascota() {
    }

    public int getCodigo_masco() {
        return codigo_masco;
    }

    public void setCodigo_masco(int codigo_masco) {
        this.codigo_masco = codigo_masco;
    }

    public String getNombre_masco() {
        return nombre_masco;
    }

    public void setNombre_masco(String nombre_masco) {
        this.nombre_masco = nombre_masco;
    }
}
