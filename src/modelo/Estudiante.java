package modelo;

public class Estudiante 
{
    private String nombre;
    private int codigo;

    public Estudiante(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " | Código: " + codigo;     
    }
}