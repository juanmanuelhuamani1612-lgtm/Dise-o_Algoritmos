package utp;
import modelo.Estudiante;
public class UTP 
{
    public static void main(String[] args) 
    {
        // Creamos algunos estudiantes con códigos desordenados
        Estudiante[] estudiantes = 
        {
            new Estudiante("Carlos", 404),
            new Estudiante("Ana", 101),
            new Estudiante("Sofia", 505),
            new Estudiante("Luis", 202),
            new Estudiante("Maria", 303)
        };

        System.out.println("Lista original:");
        mostrarEstudiantes(estudiantes);

        ordenamientoPorInsercion(estudiantes);

        System.out.println("\n Lista ordenada por código:");
        mostrarEstudiantes(estudiantes);
    }

    // Algoritmo de ordenamiento por inserción
    public static void ordenamientoPorInsercion(Estudiante[] estudiante) 
    {
        for (int i = 1; i < estudiante.length; i++) {
            Estudiante actual = estudiante[i];
            int j = i - 1;

            // Desplazamos a la derecha los elementos mayores al "actual"
            while (j >= 0 && estudiante[j].getCodigo() > actual.getCodigo()) 
            {
                estudiante[j + 1] = estudiante[j];
                j--;
            }

            estudiante[j + 1] = actual;
        }
    }

    public static void mostrarEstudiantes(Estudiante[] estudiante) {
        for (Estudiante e : estudiante) {
            System.out.println(e);
        }
    }
    
}
