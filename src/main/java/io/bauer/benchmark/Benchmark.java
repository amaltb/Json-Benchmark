/**
 *
 */
package io.bauer.benchmark;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;


/**
 * @author amal
 */
public abstract class Benchmark {
    public byte[] sourceData = null;
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
            String path = "/Users/ambabu/Documents/Office/projects/doppler/Investigations/Flight-discount report data-dummy";
            sourceData = IOUtils.toByteArray(new FileInputStream(new File(path)));
            allFields.addAll(Arrays.asList("messageContext.tpid", "messageContext.eapid",
                            "flightOffers.transactionDetail.discountAmount.amount",
                    "flightDetailMetaData.totalOriginalPrice.amount",
                    "messageContext.clientInfo.clientIP"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
