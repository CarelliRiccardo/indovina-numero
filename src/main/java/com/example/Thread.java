package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Thread {
    Socket s;
    public Thread(Socket s)
    {
        this.s=s;
    }
    public void run()
    {
        try
        {
            int rand=(int) (Math.random()*100)+1;
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));//crea il modo per ascoltare
            DataOutputStream out= new DataOutputStream(s.getOutputStream());//crea il modo per rispondere
            String stringaRicevuta=in.readLine();//riceve il messaggio dal client
            int num=0;
            int n=0;
            do{
                n++;
                num=Integer.parseInt(in.readLine());
                System.out.println("il numero ricevuto è "+ stringaRicevuta);
                if (num>rand)
                {
                    System.out.println("1");
                    out.writeBytes("1"+"\n");
                }
                else if(num<rand)
                {
                    System.out.println("2");
                    out.writeBytes("2"+"\n");
                }
                else if(num>100 || num<1)
                {
                    System.out.println("3");
                    out.writeBytes("3"+"\n");
                }

            }while(num!=rand);
            System.out.println("4");
            out.writeBytes("4"+"\n");
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            System.out.println("errore nella creazione del server");
            System.exit(1);
        }
 
    }
    
}
