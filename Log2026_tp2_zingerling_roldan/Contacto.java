
/**
 * Write a description of class Contacto here.
 * 
 * @author (Zingerling, Roldan) 
 * @version (1.0)
 */
public class Contacto{
    
    private String nombre;
    private String localidad;
    private String direccion;
    private String[] telefono;
    
    
    public Contacto (String nombre, String localidad, String direccion, String telefono){
    
    
    //this.telefono = new telefono []
    //this.nombre = nombre.toUpperCase();
    //this.localidad = localidad.toUpperCase();
    //this.direccion = direccion.toUpperCase()
    
    //solucion 2
    setNombre(nombre);
    setLocalidad(localidad);
    setDireccion(direccion);
    
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
         this.nombre = nombre.toUpperCase();  
    }
    
        public String getLocalidad(){
            
        return this.localidad;
    }
        
    public void setLocalidad (String localidad){
        
         this.localidad = localidad.toUpperCase();  
    }
    
        public String getDireccion(){
            
        return this.direccion;
    }
        
    public void setDireccion (String direccion){
        
         this.direccion = direccion.toUpperCase();  
    }
    
        public String[] getTelefono(){
            
        return this.telefono;
    }
        
    public void setTelefono (String telefono){
        
         this.telefono = new String [5];  
    }
}