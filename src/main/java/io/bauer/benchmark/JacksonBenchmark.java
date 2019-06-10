

package io.bauer.benchmark;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import java.io.IOException;
import java.util.*;

/****
 * @author jbauer
 *
 */
public class JacksonBenchmark extends Benchmark {
    public static ObjectMapper mapper = new ObjectMapper();

    static {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.registerModule(new AfterburnerModule());
    }

    public JacksonBenchmark() {
        this.setup();
    }

    public int de_serializationTest() {
        final Map<String, String> result = new HashMap<>();
        try {
            final JsonNode rootNode;
            rootNode = mapper.readTree(sourceData);
            traverseJsonTree(rootNode, "", allFields, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    private void traverseJsonTree(JsonNode rootNode, String currentPath, Set<String> allFields, Map<String, String> result) {
        if (rootNode == null) {
            if (allFields.contains(currentPath)) {
                result.put(currentPath, "");
            }
        } else {
            if (rootNode.isValueNode()) {
                if (rootNode.isNull()) {
                    if (allFields.contains(currentPath)) {
                        result.put(currentPath, "");
                    }
                } else {
                    if (allFields.contains(currentPath)) {
                        result.put(currentPath, rootNode.asText());
                    }
                }
            } else if (rootNode.isObject()) {
                final Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
                while (fieldsIterator.hasNext()) {
                    final Map.Entry<String, JsonNode> field = fieldsIterator.next();
                    traverseJsonTree(field.getValue(), Objects.equals(currentPath, "") ? field.getKey() : currentPath + "." + field.getKey(), allFields, result);
                }
            } else if (rootNode.isArray()) {
                traverseJsonTree(rootNode.get(0), currentPath, allFields, result);
            } else {
                System.out.println("error while parsing the input message " + currentPath);
            }
        }
    }

//    public static void main(String[] args) {
//        final JacksonBenchmark jackson = new JacksonBenchmark();
//
//        jackson.setup();
//        jackson.startTimer("start");
//        jackson.de_serializationTest();
//        jackson.stopTimer();
//    }
}
