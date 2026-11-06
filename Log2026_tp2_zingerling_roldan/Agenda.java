
/**
 * Write a description of class Agenda here.
 * 
 * @author (Zingerling, Roldan) 
 * @version (1.0)
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Agenda {

    private String nombre;
    private ArrayList<Nota> notas;
    private HashMap<String, Contacto> contactos;

    //Constructor
    public Agenda(String nombre) {
        this.nombre = nombre;
        notas = new ArrayList<Nota>();
        contactos = new HashMap<String, Contacto>();
    }

    //Agregar una nota
    public void agregarNota(Nota nota) {
        notas.add(nota);
        
        String nombreContacto = nota.getContacto().getNombre();
        if (!contactos.containsKey(nombreContacto)) {
            agregarContacto(nota.getContacto());
        }
    }

    //Listar todas las notas
    public void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("La agenda no tiene notas");
        } else {
            for (Nota nota : notas) {
                System.out.println("***************");
                System.out.println("Nombre: " + this.nombre);
                System.out.println("Título: " + nota.getTitulo() + " Texto: " + nota.getTexto() + " Mes: " + nota.getMes() + " Día: " + nota.getDia());
                
                Contacto c = nota.getContacto();
                System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Dirección: " + c.getDireccion());
                System.out.println("Teléfonos:");
                c.listarTelefonos();
                System.out.println("***************");
            }
        }
    }

    //Agregar un contacto
    public void agregarContacto(Contacto contacto) {
        String nombreContacto = contacto.getNombre();

        if (contactos.containsKey(nombreContacto)) {
            System.out.println("El contacto " + nombreContacto + " ya existe en la agenda");
        } else {
            contactos.put(nombreContacto, contacto);
        }
    }

    //Eliminar un contacto
    public void eliminarContacto(String nombre) {
        String nombreClave = nombre.toUpperCase();

        if (!contactos.containsKey(nombreClave)) {
            System.out.println("El contacto " + nombre + " no se encuentra");
        } else {
            Contacto contacto = contactos.get(nombreClave);

            if (tieneNotas(contacto)) {
                System.out.println("El contacto " + nombre + " tiene notas asociadas y no se puede eliminar");
            } else {
                contactos.remove(nombreClave);
            }
        }
    }

    //Listar todos los contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda no tiene contactos");
        } else {
            for (Contacto contacto : contactos.values()) {
                System.out.println("Contacto: " + contacto.getNombre() + " Localidad: " + contacto.getLocalidad() + " Dirección: " + contacto.getDireccion());
                System.out.println("Teléfonos:");
                contacto.listarTelefonos();
            }
        }
    }

    //Listar contactos que tienen notas
    public void listarContactosConNotas() {
        boolean hay = false;
        for (Contacto contacto : contactos.values()) {
            if (tieneNotas(contacto)) {
                hay = true;
                System.out.println("Contacto: " + contacto.getNombre() + " Localidad: " + contacto.getLocalidad() + " Dirección: " + contacto.getDireccion());
                System.out.println("Teléfonos:");
                contacto.listarTelefonos();
            }
        }
        
        if (hay == false) {
            System.out.println("No hay contactos con notas");
        }
    }

    //Listar contactos que no tienen notas
    public void listarContactosSinNotas() {
        boolean hay = false;
        for (Contacto contacto : contactos.values()) {
            if (!tieneNotas(contacto)) {
                hay = true;
                System.out.println("Contacto: " + contacto.getNombre() + " Localidad: " + contacto.getLocalidad() + " Dirección: " + contacto.getDireccion());
                System.out.println("Teléfonos:");
                contacto.listarTelefonos();
            }
        }
        
        if (hay == false) {
            System.out.println("No hay contactos sin notas");
        }
    }

    //Comprobar si un contacto tiene notas
    private boolean tieneNotas(Contacto contacto) {
        for (Nota nota : notas) {
            if (nota.getContacto() == contacto) {
                return true;
            }
        }
        return false;
    }

    //DESAFIO: Buscar notas de un contacto.
    public void buscarXcontacto(String nombre) {
        String nombreClave = nombre.toUpperCase();

        if (!contactos.containsKey(nombreClave)) {
            System.out.println("El contacto " + nombre + " no se encuentra");
        } else {
            Contacto contacto = contactos.get(nombreClave);
            int cantidad = 0;

            if (!tieneNotas(contacto)) {
                System.out.println("El contacto " + nombre + " no tiene notas");
                return;
            }

            System.out.println("************");
            for (Nota nota : notas) {
                if (nota.getContacto() == contacto) {
                    System.out.println("Título: " + nota.getTitulo() + " Texto: " + nota.getTexto());
                    cantidad++;
                }
            }
            System.out.println("************");
            System.out.println("Total de notas: " + cantidad);
        }
    }

    //DESAFIO: Listar contactos en orden alfabético.
    public void listarContactosAlfa() {
        ArrayList<String> nombres = new ArrayList<String>(contactos.keySet());
        Collections.sort(nombres);

        for (String nombre : nombres) {
            System.out.println(contactos.get(nombre).getNombre());
        }
    }

    //DESAFIO: Buscar notas por el comienzo del título.
    public void buscarXtitulos(String inicio) {
        String inicioClave = inicio.toUpperCase();
        int cantidad = 0;

        for (Nota nota : notas) {
            if (nota.getTitulo().toUpperCase().startsWith(inicioClave)) {
                Contacto c = nota.getContacto();
                System.out.println(nota.getTitulo() + " " + nota.getTexto() + " " + c.getNombre() + " " + c.getLocalidad());
                c.listarTelefonos();
                cantidad++;
            }
        }

        if (cantidad == 0) {
            System.out.println("No hay notas cuyo título comience con " + inicio);
        }
    }
}