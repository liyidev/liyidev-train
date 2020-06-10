import com.liyi.train.Father;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-10 19:30
 */
public class App {
    private static AtomicStampedReference<Integer> money =
            new AtomicStampedReference<Integer>(19, 0);
    public static void main (String[] args) {
//        ArrayList list = new ArrayList();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        int s = list.size();
//        ArrayList result = new ArrayList(s);
//        for (int i = 0; i < s; i++) {
//            result.set(i, list.get(s-1-i));
//        }
        //test5
        //test4
        //test3
        //testMerge
        System.out.println(new Random().nextInt(10));
    }
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList<>();
//        while (listNode != null) {
//            list.add(listNode.val);
//        }
//        int s = list.size();
//        ArrayList<Integer> result = new ArrayList<Integer>(s);
//        for (int i = 0; i < s; i++) {
//            result.set(i, list.get(s-1-i));
//        }
//        return result;
//    }

    @Test
    public void contact () {
        String s1 = "a";
        String s2 = "a";
        String s3 = "a" + "a";
        String s5 = "aa";
        System.out.println(s3 == s5);
    }

    public class ASS {

    }
}
