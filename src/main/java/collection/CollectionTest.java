//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package collection;

import java.util.List;
import java.util.stream.Collectors;

class CollectionTest {
    CollectionTest() {
    }

    public static List<Double> compute1(List<Integer> input) {
        return (List)input.stream().map((x) -> {
            return Math.pow((double)(x * 2 + 3), 5.0);
        }).collect(Collectors.toList());
    }

    public static List<String> compute2(List<String> input) {
        return (List)input.stream().map((s) -> {
            String var10000 = s.substring(0, 1).toUpperCase();
            return var10000 + s.substring(1) + s;
        }).collect(Collectors.toList());
    }
}
