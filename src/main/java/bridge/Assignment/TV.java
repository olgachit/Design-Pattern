package bridge.Assignment;

public class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    public boolean isEnabled() { return on; }

    public void enable() { on = true; }

    public void disable() { on = false; }

    public int getVolume() { return volume; }

    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
    }

    public int getChannel() { return channel; }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void printStatus() {
        System.out.println("TV is " + (on ? "ON" : "OFF"));
        System.out.println("Volume: " + volume);
        System.out.println("Channel: " + channel);
    }
}
