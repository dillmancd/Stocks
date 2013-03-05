import java.io.*;
import java.util.*;

public class MakeStocks {
    public static void main(String[] args) throws Exception {
        final int MAX_RECORDS = 1000;
        Random r = new Random();       
        PrintWriter out = new PrintWriter(new BufferedWriter(
        new FileWriter(new File("stocks.sql"))));

       String[] modelArray = {"Chevy", "Ford", "Honda", "BMW", "Audi", "Mercedes", "Caddy"};

          for(int i=0; i<MAX_RECORDS; i++) {
            String q = "insert into auto values (null"
                + ", '" + modelArray[r.nextInt(modelArray.length)] 
                + "', '" + (r.nextInt(113) + 1900) 
                + "', " + (r.nextInt(100000) + 5000)
                + ");";
               out.println(q);
                                       }
           out.close();
                                                                                                                                                                            }
}
