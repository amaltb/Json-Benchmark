package io.bauer.benchmark;

import com.jsoniter.DecodingMode;
import com.jsoniter.JsonIterator;
import com.jsoniter.annotation.JsoniterAnnotationSupport;
import com.jsoniter.any.Any;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.JsonStream;

import java.util.*;

public class JsoniterBenchmark extends Benchmark {
    static {
        JsonIterator.setMode(DecodingMode.DYNAMIC_MODE_AND_MATCH_FIELD_WITH_HASH);
        JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
        JsoniterAnnotationSupport.enable();
    }

    public JsoniterBenchmark() {
        this.setup();
    }


    public int de_serializationTest() {
        final Map<String, String> result = new HashMap<>();
        try {
            Any root = JsonIterator.deserialize(sourceData);
            traverseJsonTree(root, "", allFields, result);
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;

    }

    private void traverseJsonTree(Any rootNode, String currentPath, Set<String> allFields, Map<String, String> result) {
        if (rootNode == null) {
            if (allFields.contains(currentPath)) {
                result.put(currentPath, "");
            }
        } else {
            // object
            if (rootNode.valueType().toString().toLowerCase(Locale.ENGLISH).equals("object")) {
                Any.EntryIterator iter = rootNode.entries();
                while (iter.next()) {
                    traverseJsonTree(iter.value(),
                            Objects.equals(currentPath, "") ? iter.key() : currentPath + "." + iter.key(),
                            allFields, result);
                }

            }
            // array
            else if (rootNode.valueType().toString().toLowerCase(Locale.ENGLISH).equals("array")) {
                traverseJsonTree(rootNode.get(0), currentPath, allFields, result);
            }
            // invalid node
            else if (rootNode.valueType().toString().toLowerCase(Locale.ENGLISH).equals("invalid")) {
                // TODO log this message
            }
            // value node
            else {
                if (rootNode.valueType().toString().equals("NULL")) {
                    if (allFields.contains(currentPath)) {
                        result.put(currentPath, "");
                    }
                } else if (allFields.contains(currentPath)) {
                    result.put(currentPath, rootNode.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        final JsoniterBenchmark jackson = new JsoniterBenchmark();

        jackson.setup();
        jackson.startTimer("start");
        jackson.de_serializationTest();
        jackson.stopTimer();
    }
}
