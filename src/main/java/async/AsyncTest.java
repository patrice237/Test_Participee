//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package async;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AsyncTest {
    private static List<Enterprise> enterprises = List.of(new Enterprise[]{new Enterprise("ent_1", "Google", "ceo_2"), new Enterprise("ent_2", "Facebook", "ceo_1")});
    private static List<Ceo> ceos = List.of(new Ceo[]{new Ceo("ceo_1", "Mark"), new Ceo("ceo_2", "Sundar"), new Ceo("ceo_3", "Bill")});
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    AsyncTest() {
    }

    public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> {
            return ceos.find((ceo) -> {
                return ceo.getId().equals(ceo_id);
            });
        }, executor);
    }

    public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> {
            return enterprises.find((enterprise) -> {
                return enterprise.getCeo_id().equals(ceo_id);
            });
        }, executor);
    }

    public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
        CompletableFuture<Option<Ceo>> ceo = getCeoById(ceo_id);
        CompletableFuture<Option<Enterprise>> entreprise = getEnterpriseByCeoId(ceo_id);
        return ceo.thenCombine(entreprise, Tuple::of);
    }
}
