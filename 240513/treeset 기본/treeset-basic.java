import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            int value;
            switch (order) {

                case ("add"):
                    treeSet.add(Integer.parseInt(st.nextToken()));
                    break;
                
                case ("remove"):
                    treeSet.remove(Integer.parseInt(st.nextToken()));
                    break;
                
                case ("find"):
                    sb.append(treeSet.contains(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                
                case ("lower_bound"):

                    value = Integer.parseInt(st.nextToken());

                    if (treeSet.ceiling(value) != null)
                        sb.append(treeSet.ceiling(value)).append("\n");
                    else
                        sb.append("None \n");

                    break; 

                case ("upper_bound"):

                    value = Integer.parseInt(st.nextToken());

                    if (treeSet.higher(value) != null)
                        sb.append(treeSet.higher(value) + "\n");
                    else
                        sb.append("None \n");

                    break; 

                case ("largest"): 

                    if (treeSet.isEmpty())
                        sb.append("None \n");
                    else
                        sb.append(treeSet.last()).append("\n");
                    
                    break;

                case ("smallest"):

                    if (treeSet.isEmpty())
                        sb.append("None").append("\n");
                    else
                        sb.append(treeSet.first()).append("\n");
                    
                    break;

            
            }



        }
        System.out.print(sb);


    }




}