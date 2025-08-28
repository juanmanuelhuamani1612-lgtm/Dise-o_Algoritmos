package utp;
import modelo.Estudiante;
public class UTP 
{
    public static void main(String[] args) 
    {
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

        quickSort(estudiantes, 0, estudiantes.length - 1);

        System.out.println("\n Lista ordenada por código:");
        mostrarEstudiantes(estudiantes);
    }

    // implementamos el metodovQuickSort
    public static void quickSort(Estudiante[] estudiantes, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(estudiantes, inicio, fin);

            // Ordenamos las dos mitades
            quickSort(estudiantes, inicio, indicePivote - 1);
            quickSort(estudiantes, indicePivote + 1, fin);
        }
    }

    // partición del arreglo
    public static int particion(Estudiante[] estudiantes, int inicio, int fin) {
        Estudiante pivote = estudiantes[fin]; // Último como pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (estudiantes[j].getCodigo() <= pivote.getCodigo()) {
                i++;
                // Intercambiamos
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[j];
                estudiantes[j] = temp;
            }
        }

        // Colocamos el pivote en su lugar correcto
        Estudiante temp = estudiantes[i + 1];
        estudiantes[i + 1] = estudiantes[fin];
        estudiantes[fin] = temp;

        return i + 1;
    }

    // mostrar lista
    public static void mostrarEstudiantes(Estudiante[] estudiantes) {
        for (Estudiante estu : estudiantes) {
            System.out.println(estu);
        }
    }
    
}
