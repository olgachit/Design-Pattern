package bridge.Assignment;

public class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("Voice command received: " + command);

        switch (command.toLowerCase()) {
            case "power":
                power();
                break;
            case "volume up":
                volumeUp();
                break;
            case "volume down":
                volumeDown();
                break;
            case "channel up":
                channelUp();
                break;
            case "channel down":
                channelDown();
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}
