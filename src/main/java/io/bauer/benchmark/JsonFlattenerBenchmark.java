package io.bauer.benchmark;

import com.github.wnameless.json.flattener.JsonFlattener;

import java.util.HashMap;
import java.util.Map;

public class JsonFlattenerBenchmark extends Benchmark {

    public JsonFlattenerBenchmark() {
        this.setup();
    }

    public int de_serializationTest() {
        try {
            Map<String, Object> map = JsonFlattener.flattenAsMap(new String(sourceData));
            Map<String, Object> res = allFields.stream().filter(map::containsKey)
                    .collect(HashMap::new, (m,v)->m.put(v, map.get(v)), HashMap::putAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

//    public static void main(String[] args) {
//        final JsonFlattenerBenchmark jackson = new JsonFlattenerBenchmark();
//
//        jackson.startTimer("start");
//        jackson.de_serializationTest();
//        jackson.stopTimer();
//    }
}
