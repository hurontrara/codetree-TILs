import java.io.*;
import java.util.*;

class Person {

    String name;
    int line;
    Person prev = null;
    Person next = null;

    Person(String name) {
        this.name = name;
    }

}   

public class Main {

    static int n, m, q; // n명의 사람, m개의 줄, q개의 연산

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Person> hashMap = new HashMap<>();

    static List<Person> headList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {

            Person leftPerson = new Person(st.nextToken()); leftPerson.line = i;
            headList.add(leftPerson);
            hashMap.put(leftPerson.name, leftPerson);

            for (int j = 1; j < n / m; j++) {

                Person persentPerson = new Person(st.nextToken());
                persentPerson.prev = leftPerson; leftPerson.next = persentPerson;
                persentPerson.line = i;
                hashMap.put(persentPerson.name, persentPerson);

                leftPerson = persentPerson;

            }


        }

        for (int l = 0; l < q; l++) {

            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {

                // a인 사람이 b인 사람 새치기
                // a가 제일 앞인 경우
                // b가 제일 앞인 경우
                Person a = hashMap.get(st.nextToken()); Person b = hashMap.get(st.nextToken());

                if (a.prev == null) {
                    headList.set(a.line, a.next);
                }

                if (b.prev == null) {
                    headList.set(b.line, a);
                }

                a.line = b.line;



                if (a.prev != null)
                    a.prev.next = a.next;
                if (a.next != null)
                    a.next.prev = a.prev;

                Person left = b.prev; Person mid = a; Person right = b;

                mid.prev = left; mid.next = b;
                if (left != null)
                    left.next = mid;
                right.prev = mid;




            }
            else if (order == 2) {

                Person a = hashMap.get(st.nextToken());

                // a가 제일 앞인 경우
                if (a.prev == null) {
                    headList.set(a.line, a.next);
                }

                Person left = a.prev; Person mid = a; Person right = a.next;

                if (left != null)
                    left.next = right;
                if (right != null)
                    right.prev = left;
                



            }
            else {

                Person a = hashMap.get(st.nextToken()); Person b = hashMap.get(st.nextToken()); Person c = hashMap.get(st.nextToken());

                // a가 가장 앞에 있을 때
                // c가 가장 앞에 있을 때
                if (a.prev == null) {

                    headList.set(a.line, b.next);

                }

                if (c.prev == null) {

                    headList.set(c.line, a);

                }

                Person nextPerson = a;
                while (true) {

                    nextPerson.line = c.line;

                    if (nextPerson == b)
                        break;
                    
                    nextPerson = nextPerson.next;

                }

                if (a.prev != null)
                    a.prev.next = b.next;
                if (b.next != null)
                    b.next.prev = a.prev;

                a.prev = null; b.next = null;

                Person left = c.prev;
                a.prev = left; b.next = c;
                if (left != null)
                    left.next = a;
                c.prev = b;




            }
            



        }

        for (Person person : headList) {

            if (person == null) {
                sb.append("-1 \n");
                continue;
            }

            while (true) {

                sb.append(person.name).append(" ");

                if (person.next == null)
                    break;

                person = person.next;

            }
            sb.append("\n");


        }

        System.out.print(sb);




    }


}