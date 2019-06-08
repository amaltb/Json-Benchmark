/**
 *
 */
package io.bauer.benchmark;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;

import io.bauer.benchmark.models.User;


/**
 * @author amal
 */
public abstract class Benchmark {
    public ArrayList<String> sourceList = new ArrayList<>();
	public Set<String> allFields = new HashSet<>();
    public long startTime = 0l;
    public String phase = null;

    public void startTimer(String phase) {
        this.phase = phase;
        this.startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        final long totalTime = System.currentTimeMillis() - this.startTime;
        System.out.println("Completed [" + this.phase + "] in " + Duration.ofMillis(totalTime));
    }

    public void setup() {
        this.loadResources();
    }

    public void loadResources() {
        try {
            String path = "/Users/ambabu/Documents/Office/projects/doppler/Investigations/Flight-discount report data";
            Scanner s = new Scanner(new File(path));
            while (s.hasNextLine()){
                sourceList.add(s.nextLine());
            }
            s.close();
            allFields.addAll(Arrays.asList("messageContext.tpid", "messageContext.eapid",
                            "flightOffers.transactionDetail.discountAmount.amount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
