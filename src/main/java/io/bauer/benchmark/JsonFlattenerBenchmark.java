package io.bauer.benchmark;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wnameless.json.flattener.JsonFlattener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonFlattenerBenchmark extends Benchmark {

    public JsonFlattenerBenchmark() {
        this.setup();
    }

    public int objectDeserialize()
    {
        try{
            sourceList.forEach(line ->
            {
                Map<String, Object> map = JsonFlattener.flattenAsMap(line);
                try {
                    Map<String, Object> res = allFields.stream().filter(map::containsKey)
                            .collect(Collectors.toMap(Function.identity(), map::get));
//                    System.out.println(res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return 1;
    }

//    public static void main(String[] args) {
//        final JsonFlattenerBenchmark jackson = new JsonFlattenerBenchmark();
//
//        jackson.startTimer("start");
//        jackson.objectDeserialize();
//        jackson.stopTimer();
//    }
}
