import java.net.*;
import java.io.*;

public class Cliente {
	
	Boton boton;
	
    Mensaje m;

    Socket client;
    ObjectOutputStream output;

    public Cliente(){
    	boton = new Boton();
        conectar();
    }

    public void conectar(){
        //String str;
        m = new Mensaje();
        //m.set("hola mundo", 4);
        //m.set(boton.activo);
        try{
            client = new Socket("127.0.0.1", 5555);
            output = new ObjectOutputStream(client.getOutputStream());
            //output.writeObject(str);
            while(true) {
            	
            	if(boton.activo != m.estado) {
            		//System.out.println("Envia: " + boton.activo);
            		m.set(boton.activo);
            		if(boton.activo) {
            			m.set("a", 0);
            		}
            		else {
            			m.set("b", 1);
            		}
            		//System.out.println("enviando msg:" + m.msj);
            		output.writeObject(m.msj);
                    output.flush();
            	}
            	//m.set(boton.activo);
                //output.writeObject(m);
                //output.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {   
                    e.printStackTrace();
                }
            }
            
            //output.close();
            //client.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
