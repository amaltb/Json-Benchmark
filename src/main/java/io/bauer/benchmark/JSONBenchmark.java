package io.bauer.benchmark;

import com.github.wnameless.json.flattener.JsonFlattener;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

/**
 *
 */

/**
 * @author amal
 */
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JSONBenchmark {
    private final static JacksonBenchmark jackson = new JacksonBenchmark();
    private final static JsonFlattenerBenchmark jsonflat = new JsonFlattenerBenchmark();


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(JSONBenchmark.class.getSimpleName())
                .forks(1)
                .warmupBatchSize(5)
                .warmupIterations(5)
                .measurementBatchSize(5)
                .measurementIterations(1)
                .mode(Mode.AverageTime)
                .measurementTime(TimeValue.seconds(20))
                .build();

        new Runner(options).run();
    }

    @Setup
    public void setup() {
		jackson.setup();
        jsonflat.setup();
    }

    @Benchmark
    public int jacksonObjectDeserialize() {
        return jackson.objectDeserializeTest();
    }

    @Benchmark
    public int jsonflatObjectDeserialize() {
        return jsonflat.objectDeserialize();
    }
}
