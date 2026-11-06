
/**
 * Write a description of class Contacto here.
 * 
 * @author (Zingerling, Roldan) 
 * @version (1.0)
 */


import java.util.Scanner;

public class Contacto{
    
    private String nombre;
    private String localidad;
    private String direccion;
    private String[] telefono;
    
    
    public Contacto (String nombre, String localidad, String direccion, String telefono){
    
    this.telefono = new String[5];
    
    setNombre(nombre);
    setLocalidad(localidad);
    setDireccion(direccion);
    
    if (telefono == null || telefono.trim().isEmpty()) {
        agregarTelefono();
    } 
    else {
        this.telefono[0] = telefono;
    }
    }
    
    public String getNombre(){
            
        return this.nombre;
    }
        
    public void setNombre (String nombre){
        if (nombre != null){
        
            if(!(nombre.trim().isEmpty())){
            
            this.nombre = nombre.toUpperCase();
            }
            else {
            this.nombre = "S/D";
            
            }
        }
            else{
            this.nombre = "S/D";
            
            }
    }
    
        public String getLocalidad(){
            
        return this.localidad;
    }
        
    public void setLocalidad (String localidad){
        if (localidad != null){
        
            if(!(localidad.trim().isEmpty())){
            
            this.localidad = localidad.toUpperCase();
            }
            else {
            this.localidad = "S/D";
        
            }
        }
            else{
            this.localidad = "S/D";
            
            }
    }
    
        public String getDireccion(){
    
        return this.direccion;
    }
        
    public void setDireccion (String direccion){
        if (direccion != null){
        
            if(!(direccion.trim().isEmpty())){
            
            this.direccion = direccion.toUpperCase();
            }
            else {
            this.direccion = "S/D";
            
            }
        }
            else{
            this.direccion = "S/D";
            
            }
    }
    
        public String[] getTelefono(){
            
        return this.telefono;
    }
    
    public void agregarTelefono() {
        // 1. Verificar si hay lugar libre
        int posicion = elementoVacio();
        if (posicion == -1) {
            System.out.println("No existe más lugar para agregar números telefónicos");
            return;
        }

        Scanner teclado = new Scanner(System.in);
        String caracteristica = "";
        boolean caracValida = false;

        // 2. Pedir y validar característica
        while (caracValida == false) {
            System.out.print("Ingrese la característica telefónica: ");
            caracteristica = teclado.next();
            
            if (validarCaracteristica(caracteristica) == true) {
                caracValida = true; // Salimos del ciclo
            } else {
                System.out.println("Característica incorrecta. Debe empezar con 0 y tener entre 3 y 5 números.");
            }
        }

        int numero = 0;
        boolean numValido = false;

        // 3. Pedir y validar número
        while (numValido == false) {
            System.out.print("Ingrese el número de teléfono: ");
            numero = teclado.nextInt();
            
            if (validarNumero(numero) == true) {
                numValido = true; // Salimos del ciclo
            } else {
                System.out.println("Número incorrecto. Debe tener entre 5 y 7 dígitos.");
            }
        }

        // 4. Guardar en la posición vacía
        this.telefono[posicion] = caracteristica + "-" + numero;
        System.out.println("Teléfono agregado con éxito.");
    }

    public int elementoVacio() {
        for (int i = 0; i < this.telefono.length; i++) {
            if (this.telefono[i] == null || this.telefono[i].trim().isEmpty()) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean validarCaracteristica(String c) {
        // 1. Verificamos que no sea nula
        if (c == null) {
            return false;
        }
        // 2. Verificamos que la longitud sea entre 3 y 5
        if (c.length() < 3 || c.length() > 5) {
            return false;
        }
        // 3. Verificamos que empiece con cero
        if (!c.startsWith("0")) {
            return false;
        }
        // 4. Verificamos que todos los caracteres sean dígitos (0 al 9)
        for (int i = 0; i < c.length(); i++) {
            char digito = c.charAt(i);
            if (digito < '0' || digito > '9') {
                return false; 
            }
        }
        
        return true; // Si pasó todas las pruebas, es válida
    }

    public boolean validarNumero(int n) {
        // Un número de 5 a 7 dígitos está entre 10000 y 9999999
        if (n >= 10000 && n <= 9999999) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarPosicion(int p) {
        // 1. Verificamos que la posición ingresada esté entre 1 y 5
        if (p >= 1 && p <= 5) {
            
            // 2. Calculamos el índice real del arreglo (la posición 1 es el índice 0)
            int indice = p - 1;
            
            // 3. Verificamos que ese lugar no esté vacío (ni nulo ni en blanco)
            if (this.telefono[indice] != null && !this.telefono[indice].trim().isEmpty()) {
                return true; // La posición es válida y tiene un teléfono
            }
        }
        
        return false; // Si no cumple alguna de las condiciones, es inválida
    }
    
    public void listarTelefonos() {
        boolean hayTelefonos = false;
        
        for (int i = 0; i < this.telefono.length; i++) {
            // Si la posicion no es nula y no esta vacia, mostramos el telefono
            if (this.telefono[i] != null && !this.telefono[i].trim().isEmpty()) {
                hayTelefonos = true;
                System.out.println((i + 1) + ") " + this.telefono[i]);
            }
        }
        
        // Si termino el for y nunca cambio la variable, es porque esta vacio
        if (hayTelefonos == false) {
            System.out.println("No existen números de teléfonos en la lista");
        }
    }
    
    public void agregarTelefono(String caracteristica, int numero) {
        // Desafío: Validar la característica y el número antes de guardar
        if (!validarCaracteristica(caracteristica) || !validarNumero(numero)) {
            System.out.println("El número ingresado es erróneo");
            return; // Termina la ejecución del método aquí y no guarda nada
        }

        // 1. Verificar que haya un elemento vacío
        int posicion = elementoVacio();
        
        if (posicion == -1) {
            System.out.println("No existe más lugar para agregar números telefónicos");
            return; // Termina la ejecución del método aquí
        }

        // Si es válido y hay lugar, se guarda con el formato requerido
        this.telefono[posicion] = caracteristica + "-" + numero;
    }
    
    public void eliminarTelefono() {
        // 1. Verificar si hay al menos un teléfono cargado
        boolean hayTelefonos = false;
        for (int i = 0; i < this.telefono.length; i++) {
            if (this.telefono[i] != null && !this.telefono[i].trim().isEmpty()) {
                hayTelefonos = true;
            }
        }
        
        if (hayTelefonos == false) {
            System.out.println("No existen números de teléfonos en la lista");
            return; // Termina el método aquí
        }

        // 2. Mostrar los teléfonos disponibles
        listarTelefonos();

        // 3. Pedir la posición por teclado y validarla
        Scanner teclado = new Scanner(System.in);
        int posicion = 0;
        boolean posicionValida = false;

        while (posicionValida == false) {
            System.out.print("Ingrese la posición del teléfono a eliminar: ");
            posicion = teclado.nextInt();
            
            if (validarPosicion(posicion) == true) {
                posicionValida = true; // Salimos del ciclo
            } else {
                System.out.println("Posición incorrecta. Intente de nuevo.");
            }
        }

        // 4. Eliminar el teléfono asignando una cadena vacía
        int indice = posicion - 1;
        this.telefono[indice] = "";
        System.out.println("Teléfono eliminado con éxito.");
    }
    
    public void modificarTelefono() {
        // 1. Verificar si hay al menos un teléfono cargado
        boolean hayTelefonos = false;
        for (int i = 0; i < this.telefono.length; i++) {
            if (this.telefono[i] != null && !this.telefono[i].trim().isEmpty()) {
                hayTelefonos = true;
            }
        }
        
        if (hayTelefonos == false) {
            System.out.println("No existen números de teléfonos en la lista para modificar");
            return; // Termina el método aquí
        }

        // 2. Mostrar los teléfonos disponibles
        listarTelefonos();

        Scanner teclado = new Scanner(System.in);
        
        // 3. Pedir la posición y validarla
        int posicion = 0;
        boolean posicionValida = false;
        while (posicionValida == false) {
            System.out.print("Ingrese la posición del teléfono a modificar: ");
            posicion = teclado.nextInt();
            
            if (validarPosicion(posicion) == true) {
                posicionValida = true;
            } else {
                System.out.println("Posición incorrecta. Intente de nuevo.");
            }
        }

        // 4. Pedir la nueva característica y validarla
        String caracteristica = "";
        boolean caracValida = false;
        while (caracValida == false) {
            System.out.print("Ingrese la NUEVA característica telefónica: ");
            caracteristica = teclado.next();
            
            if (validarCaracteristica(caracteristica) == true) {
                caracValida = true;
            } else {
                System.out.println("Característica incorrecta. Debe empezar con 0 y tener entre 3 y 5 números.");
            }
        }

        // Pedir el nuevo número y validarlo
        int numero = 0;
        boolean numValido = false;
        while (numValido == false) {
            System.out.print("Ingrese el NUEVO número de teléfono: ");
            numero = teclado.nextInt();
            
            if (validarNumero(numero) == true) {
                numValido = true;
            } else {
                System.out.println("Número incorrecto. Debe tener entre 5 y 7 dígitos.");
            }
        }

        // 5. Reemplazar el teléfono viejo por el nuevo
        int indice = posicion - 1;
        this.telefono[indice] = caracteristica + "-" + numero;
        System.out.println("Teléfono modificado con éxito.");
    }
    
} 
