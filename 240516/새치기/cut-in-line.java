import java.io.*;
import java.util.*;

class Person {

    int num;
    int line;
    Person prev = null;
    Person next = null;

    Person(int num, int line) {
        this.num = num;
        this.line = line;
    }

}


public class Main {

    static int n, m, q; // n명의 사람, m개의 줄, q개의 오더

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Person> hashMap = new HashMap<>();

    static List<Person> headList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        // 해시맵에 등록 및 연결
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int lineSize = Integer.parseInt(st.nextToken());
            if (lineSize == -1) {
                headList.add(null);
                continue;
            }

            Person leftPerson = new Person(Integer.parseInt(st.nextToken()), i);
            hashMap.put(leftPerson.num, leftPerson);
            headList.add(leftPerson);
            for (int __ = 1; __ < lineSize; __++) {

                Person presentPerson = new Person(Integer.parseInt(st.nextToken()), i);
                hashMap.put(presentPerson.num, presentPerson);

                leftPerson.next = presentPerson; presentPerson.prev = leftPerson;
                leftPerson = presentPerson;

            }
            


        }

        for (int _ = 0; _ < q; _++) {

            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {

                int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

                Person right = hashMap.get(b); Person left = right.prev; Person mid = hashMap.get(a);

                int line = right.line;
                if (left == null)
                    headList.set(line, mid);

                if (mid.prev != null)
                    mid.prev.next = mid.next;
                if (mid.next != null)
                    mid.next.prev = mid.prev;

                mid.prev = left; mid.next = right;

                if (mid.prev != null)
                    mid.prev.next = mid;
                if (mid.next != null)
                    mid.next.prev = mid;


            } 
            else if (order == 2) {

                Person person = hashMap.get(Integer.parseInt(st.nextToken()));

                if (person.prev == null) 
                    headList.set(person.line, person.next);
                
 
                if (person.prev != null) {
                    person.prev.next = person.next;
                }

                if (person.next != null)
                    person.next.prev = person.prev;

            }
            else {

                int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            
                Person localHead = hashMap.get(a); Person localTail = hashMap.get(b);
                Person tail = hashMap.get(c); Person head = tail.prev;

                if (head == null)
                    headList.set(tail.line, localHead);


                if (localHead.prev != null)
                    localHead.prev.next = localTail.next;
                if (localTail.next != null)
                    localTail.next.prev = localHead.prev;

                localHead.prev = head; localTail.next = tail;
                if (head != null)
                    head.next = localHead;
                if (tail != null)
                    tail.prev = localTail;


            }

        }

        for (int i = 0; i < m; i++) {

            Person head = headList.get(i);

            if (head == null) {
                sb.append("-1 \n");
                continue;
            }

            while (true) {

                sb.append(head.num).append(" ");

                if (head.next == null)
                    break;
                
                head = head.next;

            }
            sb.append("\n");
            


        }
        System.out.print(sb);




    }




}