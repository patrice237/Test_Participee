//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package basic;

import io.vavr.control.Option;
import java.util.function.BiFunction;

public class BasicTest {
    public BasicTest() {
    }

    public static Option<Integer> power(Integer i, Integer n) {
        try {
            if (i != null && n != null && n >= 0) {
                BiFunction<Integer, Integer, Integer> powerLambda = BasicTest::recursivitePower;
                return Option.some((Integer)powerLambda.apply(i, n));
            } else {
                return Option.none();
            }
        } catch (Exception var3) {
            System.out.println(var3.getMessage());
            return Option.none();
        }
    }

    private static int recursivitePower(int base, int exposant) {
        return exposant == 0 ? 1 : base * recursivitePower(base, exposant - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 6));
        System.out.println(power(5, 0));
        System.out.println(power(2, -1));
        System.out.println(power((Integer)null, 3));
        System.out.println(power(2, (Integer)null));
    }
}
