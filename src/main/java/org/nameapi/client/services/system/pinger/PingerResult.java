package org.nameapi.client.services.system.pinger;

/**
 */
public final class PingerResult {

    private final String pong;

    public PingerResult(String pong) {
        this.pong = pong;
    }

    public String getPong() {
        return pong;
    }
}
