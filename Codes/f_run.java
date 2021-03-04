import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class f_run {
     public static void main(String[] args) throws IOException {
        int duration, intersections, streets, cars, points;
        Reader.init(System.in);
        duration = Reader.nextInt();
        intersections = Reader.nextInt();
        streets =
                Reader.nextInt();
        cars = Reader.nextInt();
        points = Reader.nextInt();
        int street_with_schl =0;
        int paths[][] = new int [intersections][intersections];
        for(int i=0; i<intersections;i++){
            for(int j=0; j<intersections; j++){
                paths[i][j] =-1;
            }
        }
        int num_street_intersection[] = new int[intersections];
        HashMap<String, Integer> street = new HashMap<>(streets);
        HashMap<Integer,String > streetnums = new HashMap<>(streets);
        int fre_cars[] = new int[streets];
        for( int i =0; i<streets; i++){
            int beg = Reader.nextInt();
            int end = Reader.nextInt();
            String name = Reader.next();
            int d = Reader.nextInt();
            street.put(name, i);
            streetnums.put(i, name);
            paths[beg][end] = i;
            if(num_street_intersection[end]==0){
                street_with_schl++;
            }
            num_street_intersection[end]++;
        }
        for(int i =0; i<cars;i++){
            int hh = Reader.nextInt();
            for(int j=0; j<hh ; j++){
                String str = Reader.next();
                fre_cars[street.get(str)]++;

            }
        }
        int number_of_str =0;

        for( int i =0; i<intersections; i++){
            if(num_street_intersection[i]>0){

                
                int counter =0;
                //System.out.println(num_street_intersection[i]);

                for(int j=0; j<intersections;j++){
                    if(paths[j][i]!=-1 && fre_cars[paths[j][i]]>0)
                        counter++;



                }
                if(counter==0){
                    continue;
                }
                number_of_str++;
                // System.out.println(i);
                // System.out.println(counter);


            }
        }
        //System.out.println(street_with_schl);
        System.out.println(number_of_str);
        for( int i =0; i<intersections; i++){
            if(num_street_intersection[i]>0){

                
                int counter =0;
                //System.out.println(num_street_intersection[i]);

                for(int j=0; j<intersections;j++){
                    if(paths[j][i]!=-1 && fre_cars[paths[j][i]]>0)
                        counter++;



                }
                if(counter==0){
                    continue;
                }
                System.out.println(i);
                System.out.println(counter);




                for(int j=0; j<intersections;j++){
                    if(paths[j][i]!=-1)
                        if(fre_cars[paths[j][i]]>10){
                            System.out.println(streetnums.get(paths[j][i])+ " "+ 5);
                        }
                        // else if(fre_cars[paths[j][i]]>5){
                        //     System.out.println(streetnums.get(paths[j][i])+ " "+ 3);
                        // }
                    else if (fre_cars[paths[j][i]]>0)
                        System.out.println(streetnums.get(paths[j][i])+ " "+ 1);



                }
            }
        }

        //System.out.println(street_with_schl);
        

    }
}


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static public BufferedReader getInstance(){
        return reader;
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
