import com.liyi.train.Father;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-10 19:36
 */
public class Children extends Father {
    public Children () {
        System.out.println("children 构造器");
    }

    @Override
    protected void test() {
        super.test();
    }

    static void a() {
        System.out.println("children A");
    }

    static {
        System.out.println("children 静态代码块");
    }
    {
        System.out.println("children 代码块");
    }
}
