package BusquedaEstudiantesUTP;
import java.util.*;

public class BusquedaEstudiantesUTP {
    
    static class Estudiante {
        String nombre;
        String apellido;
        
        public Estudiante(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }
        
        public String getNombreCompleto() {
            return nombre + " " + apellido;
        }
    }
    
    private List<Estudiante> estudiantes;
    private Map<Character, List<Estudiante>> indiceApellido;
    private Scanner scanner;
    
    public BusquedaEstudiantesUTP() {
        this.estudiantes = new ArrayList<>();
        this.indiceApellido = new HashMap<>();
        this.scanner = new Scanner(System.in);
        cargarDatos();
        generarIndice();
    }
    
    private void cargarDatos() {
        // Estudiantes de ejemplo UTP - solo nombres y apellidos
        estudiantes.add(new Estudiante("Ana", "Garcia"));
        estudiantes.add(new Estudiante("Manuel", "Garcia"));
        estudiantes.add(new Estudiante("Antonio", "Garcia"));
        estudiantes.add(new Estudiante("Carlos", "Rodriguez"));
        estudiantes.add(new Estudiante("María", "Lopez"));
        estudiantes.add(new Estudiante("Juan", "Perez"));
        estudiantes.add(new Estudiante("Laura", "Martinez"));
        estudiantes.add(new Estudiante("Diego", "Gonzalez"));
        estudiantes.add(new Estudiante("Sofía", "Hernandez"));
        estudiantes.add(new Estudiante("Pedro", "Diaz"));
        estudiantes.add(new Estudiante("Elena", "Torres"));
        estudiantes.add(new Estudiante("Miguel", "Sanchez"));
        estudiantes.add(new Estudiante("Carmen", "Ramirez"));
        estudiantes.add(new Estudiante("Javier", "Flores"));
        estudiantes.add(new Estudiante("Isabel", "Vargas"));
        estudiantes.add(new Estudiante("Ricardo", "Castro"));
        estudiantes.add(new Estudiante("Patricia", "Romero"));
    }
    
    private void generarIndice() {
        for (Estudiante estudiante : estudiantes) {
            char primeraLetra = estudiante.apellido.charAt(0);
            
            if (!indiceApellido.containsKey(primeraLetra)) {
                indiceApellido.put(primeraLetra, new ArrayList<>());
            }
            indiceApellido.get(primeraLetra).add(estudiante);
        }
    }
    
    public List<Estudiante> buscarPorApellido(String apellido) {
        List<Estudiante> resultados = new ArrayList<>();
        
        if (apellido == null || apellido.isEmpty()) {
            return resultados;
        }
        
        char primeraLetra = apellido.charAt(0);
        
        if (indiceApellido.containsKey(primeraLetra)) {
            System.out.println("Buscando en apellidos que empiezan con: " + primeraLetra);
            
            for (Estudiante estudiante : indiceApellido.get(primeraLetra)) {
                if (estudiante.apellido.equalsIgnoreCase(apellido)) {
                    resultados.add(estudiante);
                }
            }
        }
        
        return resultados;
    }
    
    public void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("  BÚSQUEDA DE ESTUDIANTES UTP");
        System.out.println("==================================");
        System.out.println("1. Buscar por apellido");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Mostrar índice de apellidos");
        System.out.println("4. Salir");
        System.out.println("==================================");
        System.out.print("Seleccione una opción (1-4): ");
    }
    
    public void buscarApellido() {
        System.out.print("Ingrese el apellido a buscar: ");
        String apellido = scanner.nextLine().trim();
        
        List<Estudiante> resultados = buscarPorApellido(apellido);
        
        if (!resultados.isEmpty()) {
            System.out.println("\n✓ ESTUDIANTES ENCONTRADOS:");
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + resultados.get(i).getNombreCompleto());
            }
            System.out.println("Total: " + resultados.size() + " estudiante(s)");
        } else {
            System.out.println("\n✗ No se encontraron estudiantes con apellido: " + apellido);
        }
    }
    
    public void mostrarTodos() {
        System.out.println("\n=== TODOS LOS ESTUDIANTES ===");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).getNombreCompleto());
        }
        System.out.println("Total: " + estudiantes.size() + " estudiantes");
    }
    
    public void mostrarIndice() {
        System.out.println("\n=== ÍNDICE DE APELLIDOS ===");
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            if (indiceApellido.containsKey(letra)) {
                System.out.println(letra + ": " + indiceApellido.get(letra).size() + " estudiante(s)");
            }
        }
    }
    
    public void iniciar() {
        System.out.println("¡Bienvenido al Sistema de Búsqueda UTP!");
        System.out.println("Base de datos: " + estudiantes.size() + " estudiantes cargados\n");
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();
            
            switch (opcion) {
                case "1":
                    System.out.println("\n--- BÚSQUEDA POR APELLIDO ---");
                    buscarApellido();
                    break;
                    
                case "2":
                    mostrarTodos();
                    break;
                    
                case "3":
                    mostrarIndice();
                    break;
                    
                case "4":
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema! ¡Hasta pronto!");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor seleccione 1-4.");
                    break;
            }
            
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        BusquedaEstudiantesUTP sistema = new BusquedaEstudiantesUTP();
        sistema.iniciar();
    }
}