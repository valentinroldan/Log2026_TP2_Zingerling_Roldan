
/**
 * Write a description of class Prueba here.
 * 
 * @author (Zingerling, Roldan) 
 * @version (1.)
 */

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        
        // 1. Crear 5 instancias de la clase Contacto
        Contacto c1 = new Contacto("Valentín", "Santa Fe", "Centro 123", "0342-4111111");
        Contacto c2 = new Contacto("Nacho", "Santa Fe", "Instituto 9233", "0342-4222222");
        Contacto c3 = new Contacto("Natalia", "Santa Fe", "Boulevard 456", "0342-4333333");
        Contacto c4 = new Contacto("Carlos", "Rafaela", "Ruta 34", "03492-444444");
        Contacto c5 = new Contacto("Luis", "Sunchales", "Ruta 34 km 260", "03493-455555");
        
        // 2. Agregar 4 teléfonos a una de las instancias
        
        c1.agregarTelefono("0342", 1234567);
        c1.agregarTelefono("0342", 7654321);
        c1.agregarTelefono("0342", 2223334);
        c1.agregarTelefono("0342", 5556667);
        
        // Listar para verificar el resultado
        c1.listarTelefonos();
        
        // 3. Crear 4 instancias de la clase Nota y asignar a cada una un contacto diferente
        Nota n1 = new Nota();
        n1.setTitulo("Valentin");
        n1.setTexto("Informacion de valentin");
        n1.setMes(11);
        n1.setDia(6);
        n1.setContacto(c1);

        Nota n2 = new Nota();
        n2.setTitulo("Nacho");
        n2.setTexto("informacion de nacho");
        n2.setMes(11);
        n2.setDia(10);
        n2.setContacto(c2);

        Nota n3 = new Nota();
        n3.setTitulo("Natalia");
        n3.setTexto("informacion de natalia");
        n3.setMes(11);
        n3.setDia(15);
        n3.setContacto(c3);

        Nota n4 = new Nota();
        n4.setTitulo("Carlos");
        n4.setTexto("informacion de carlos");
        n4.setMes(11);
        n4.setDia(20);
        n4.setContacto(c4);
        
        // El quinto contacto (c5) queda sin notas como pide el punto 3

        // 4. Crear 1 instancia de la clase Agenda
        Agenda agenda = new Agenda("Agenda 2026");

        // 4.a) Registrar los 5 contactos
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);
        agenda.agregarContacto(c3);
        agenda.agregarContacto(c4);
        agenda.agregarContacto(c5);

        // 4.b) Agregar las 4 notas
        agenda.agregarNota(n1);
        agenda.agregarNota(n2);
        agenda.agregarNota(n3);
        agenda.agregarNota(n4);

        // 4.c) Listar las notas
        agenda.listarNotas();

        // 4.d) Listar los contactos
        agenda.listarContactos();
        agenda.listarContactosConNotas();
        agenda.listarContactosSinNotas();

        // 4.e) Intentar eliminar un contacto con notas y luego el contacto sin notas
        agenda.eliminarContacto(c1.getNombre());
        agenda.eliminarContacto(c5.getNombre());
        
        // Verificar los mensajes y el resultado con listarContactos()
        agenda.listarContactos();
        
        // Desafíos (Sección 6)
        
        // 1. Ejecutar buscarXcontacto
        agenda.buscarXcontacto("VALENTÍN");

        // 2. Ejecutar listarContactosAlfa
        agenda.listarContactosAlfa();

        // 3. Ejecutar buscarXtitulos (pidiendo el dato por teclado)
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el texto para buscar títulos de notas: ");
        String textoBuscado = teclado.nextLine();
        
        agenda.buscarXtitulos(textoBuscado);
    }
}