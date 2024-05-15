import java.io.*;
import java.util.*;

class Node {

    String data;
    Node prev = null;
    Node next = null;

    Node(String data) {
        this.data = data;
    }

}


public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        Node cur = new Node(br.readLine());

        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken()); 
            Node newNode;

            switch (order) {

                case 1:

                    newNode = new Node(st.nextToken());
                    newNode.prev = cur.prev;
                    newNode.next = cur;

                    if (newNode.prev != null)
                        newNode.prev.next = newNode;
                    
                    newNode.next.prev = newNode;

                    break;

                case 2:

                    newNode = new Node(st.nextToken());
                    newNode.prev = cur;
                    newNode.next = cur.next;

                    if (newNode.next != null)
                        newNode.next.prev = newNode;
                    
                    newNode.prev.next = newNode;

                    break;
                
                case 3:

                    if (cur.prev != null)
                        cur = cur.prev;
                    
                    break;

                case 4:

                    if (cur.next != null)
                        cur = cur.next;
                    
                    break;


            }

            sb.append(cur.prev != null ? cur.prev.data : "(Null)").append(" ").append(cur.data).append(" ").append(cur.next != null ? cur.next.data : "(Null)").append("\n");



        }

        System.out.print(sb);

    

    }


}