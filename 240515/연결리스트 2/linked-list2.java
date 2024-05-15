import java.io.*;
import java.util.*;

class Node {

    Node prev = null;
    Node next = null;
    int number;

    Node(int number) {
        this.number = number;
    }


}


public class Main {

    static int nodeNum, qNum;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Node> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        nodeNum = Integer.parseInt(br.readLine()); qNum = Integer.parseInt(br.readLine());

        for (int i = 1; i <= nodeNum; i++) {

            Node node = new Node(i);

            hashMap.put(i, node);

        }

        for (int k = 0; k < qNum; k++) {

            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            Node leftNode;
            Node presentNode;
            Node rightNode;
            int i = Integer.parseInt(st.nextToken());
            int j;
            switch (order) {

                case 1:
                    presentNode = hashMap.get(i);
                    if (presentNode.prev != null)
                        presentNode.prev.next = presentNode.next;
                    if (presentNode.next != null)
                        presentNode.next.prev = presentNode.prev;

                    presentNode.prev = null; presentNode.next = null;
                    break;
                
                case 2:
                    j = Integer.parseInt(st.nextToken());
                    presentNode = hashMap.get(j);
                    leftNode = hashMap.get(i).prev;
                    rightNode = hashMap.get(i);

                    presentNode.prev = leftNode; presentNode.next = rightNode;
                    if (leftNode != null)
                        presentNode.prev.next = presentNode;
                    if (rightNode != null)
                        presentNode.next.prev = presentNode;

                    break;

                case 3:
                    j = Integer.parseInt(st.nextToken());
                    presentNode = hashMap.get(j);
                    leftNode = hashMap.get(i);
                    rightNode = hashMap.get(i).next;

                    presentNode.prev = leftNode; presentNode.next = rightNode;

                    if (leftNode != null)
                        presentNode.prev.next = presentNode;
                    if (rightNode != null)
                        presentNode.next.prev = presentNode;

                    break;

                case 4:

                    presentNode = hashMap.get(i);
                    sb.append(presentNode.prev != null ? presentNode.prev.number : 0).append(" ").append(presentNode.next != null ? presentNode.next.number : 0).append("\n");


            }
            

        }

        for (int i = 1; i <= nodeNum; i++) {

            Node node = hashMap.get(i);

            sb.append(node.next != null ? node.next.number : 0).append(" ");

        }

        System.out.print(sb);




    }



}