package bridge.Assignment;

public class Main {
    public static void main(String[] args) {

        // SmartTV + SmartRemote
        Device smartTv = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartRemote.voiceControl("volume down");

        ((SmartTV) smartTv).browseInternet();
        smartTv.printStatus();

        // TV + AdvancedRemote
        Device tv = new TV();
        AdvancedRemote remote = new AdvancedRemote(tv);

        remote.power();
        remote.mute();
        tv.printStatus();
    }
}