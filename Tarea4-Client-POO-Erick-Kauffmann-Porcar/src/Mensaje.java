import java.io.Serializable;

public class Mensaje implements Serializable{
    String msj;
    int dato;
	boolean estado;

    public Mensaje(){

    }

    public void set(String m, int d){
        msj = m;
        dato = d;

    }
    
    public void set(boolean e) {
    	estado = e;
    }

    public String toString(){
        return msj + " " + dato;
    }
}
