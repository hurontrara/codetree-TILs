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

        Node leftNode = new Node(0); hashMap.put(0, leftNode);
        for (int i = 1; i <= size + 1; i++) {

            Node presentNode = new Node(i);

            presentNode.prev = leftNode; leftNode.next = presentNode;

            hashMap.put(i, presentNode);

            leftNode = presentNode;

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());

            // a < c 를 보장 
            if (a > c) {
                int tmp1 = a; a = c; c = tmp1;
                int tmp2 = b; b = d; d = tmp2;
            }

            Node left;
            Node right;
            Node aNode = hashMap.get(a); Node bNode = hashMap.get(b); Node cNode = hashMap.get(c); Node dNode = hashMap.get(d);
            Node leftTotem = aNode.prev; Node rightTotem = dNode.next;

            // aNode ~ bNode 연산
            left = aNode.prev; right = bNode.next;

            if (left != null)
                left.next = right;
            if (right != null)
                right.prev = left;
            
            left = rightTotem.prev;
            right = rightTotem;

            aNode.prev = left; bNode.next = right;

            if (left != null)
                left.next = aNode;
            if (right != null)
                right.prev = bNode;

            // cNode ~ dNode 연산
            left = cNode.prev; right = dNode.next;

            if (left != null)
                left.next = right;
            if (right != null)
                right.prev = left;

            left = leftTotem; right = leftTotem.next;

            cNode.prev = left; dNode.next = right;

            if (left != null)
                left.next = cNode;
            if (right != null)
                right.prev = dNode;
            


        }

        Node printNode = hashMap.get(0);
        while (true) {

            if (!(printNode.num == 0 || printNode.num == size + 1)) {
                sb.append(printNode.num).append(" ");
            }

            if (printNode.num == size + 1)
                break;
            
            printNode = printNode.next;


        }

        System.out.print(sb);



        
    }


}