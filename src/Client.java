import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {
    private PlanetCollection planetCollection = new PlanetCollection();
    static String link;

    public void begin(){
        Thread t = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Server closed.");
            try{
                save();
                t.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }));
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //Client.link= System.getenv("lab5");
            Client.link= "/Users/nbiryulin/Desktop/test.xml";
            System.out.println(Client.link);
            XMLParser.parseFromFile( Client.link,planetCollection.hashMap);
            String thisLine;
            while(!((thisLine=br.readLine())).trim().equals("stop")){
                planetCollection.doItCommand(thisLine);
            }
            save();



        }catch (IOException e){
        }
    }

    public void save(){
        XMLParser.parseToFile(link, planetCollection.hashMap);
        System.out.println("AAaaaaaa");
    }

}
