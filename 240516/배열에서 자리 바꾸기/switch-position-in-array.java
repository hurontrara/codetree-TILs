import java.io.*;
import java.util.*;

class Node {

    int num;
    Node prev;
    Node next;

    Node(int num) {
        this.num = num;
    }

}


public class Main {

    static int size, q;  // size개의 배열, q개의 연산

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Node> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());
        q = Integer.parseInt(br.readLine());

        Node leftNode = new Node(1); hashMap.put(1, leftNode);
        for (int i = 2; i <= size; i++) {

            Node presentNode = new Node(i);

            presentNode.prev = leftNode; leftNode.next = presentNode;

            hashMap.put(i, presentNode);

            leftNode = presentNode;

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());

            Node aNode = hashMap.get(a); Node bNode = hashMap.get(b); Node cNode = hashMap.get(c); Node dNode = hashMap.get(d);

            if (bNode.next == cNode) {

                cNode.prev = aNode.prev;

                if (cNode.prev != null)
                    cNode.prev.next = cNode;

                bNode.next = dNode.next;
                if (bNode.next != null)
                    bNode.next.prev = bNode;

                dNode.next = aNode;
                aNode.prev = dNode;


            }
            else if (dNode.next == aNode) {

                aNode.prev = cNode.prev;
                if (aNode.prev != null)
                    aNode.prev.next = aNode;

                dNode.next = bNode.next;
                if (dNode.next != null)
                    dNode.next.prev = dNode;

                bNode.next = cNode;
                cNode.prev = bNode;


            }
            else {

                Node aSave = aNode.prev; Node bSave = bNode.next;

                aNode.prev = cNode.prev;
                bNode.next = dNode.next;

                if (aNode.prev != null)
                    aNode.prev.next = aNode;
                if (bNode.next != null) {
                    bNode.next.prev = bNode;
                }

                cNode.prev = aSave; dNode.next = bSave;

                if (cNode.prev != null)
                    cNode.prev.next = cNode;
                if (dNode.next != null)
                    dNode.next.prev = dNode;


            }


        }

        Node printNode = hashMap.get(1);
        while (true) {

            if (printNode.prev == null)
                break;

            printNode = printNode.prev;


        }

        while (true) {

            sb.append(printNode.num).append(" ");

            if (printNode.next == null)
                break;

            printNode = printNode.next;

        }


        System.out.print(sb);




    }



}