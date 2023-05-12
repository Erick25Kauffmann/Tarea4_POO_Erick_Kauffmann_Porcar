import java.net.*;
import java.awt.Color;
import java.io.*;

public class Servidor {
	
	Etiqueta etiqueta;
	
	Mensaje m;

    Socket client;
    ServerSocket server;
    ObjectInputStream input;

	public Servidor(){
		etiqueta = new Etiqueta();
		Thread thread = new Thread(etiqueta);
		thread.start();
		abrirConexion();
		//thread.start();
    }
	
	public void abrirConexion(){
		System.out.println(" Esperando cliente... ");
        try{
            server = new ServerSocket(5555);
            client = server.accept();
            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());
            //str = (String)input.readObject();
            while(true) {
            	//m = (Mensaje)input.readObject();
            	String s = (String)input.readObject();
            	m = new Mensaje();
            	m.set(s,0);
            	if (s.compareTo("a") == 0) {
            		m.set(true);
            		//System.out.println("Seteando en true");
            		etiqueta.activo = true;
            	}
            	else {
            		m.set(false);
            		//System.out.println("Seteando en false");
            		etiqueta.activo = false;
            	}
            	
            	//System.out.println("Recibe: " + m.estado);
            	//System.out.println("Recibe: " + m.msj);
                //etiqueta.activo = m.estado;
                imprimir(m);
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {   
                    e.printStackTrace();
                }*/
            }
            
            //input.close();
            //client.close();
            //server.close();
            
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void imprimir(){
        //System.out.println(str);
        System.out.println(m);
    }
    
    private void imprimir(Mensaje m) {
    	if(m.estado) {
    		System.out.println("activado");
    	}
    	else {
    		System.out.println("desactivado");
    	}
    }
}
