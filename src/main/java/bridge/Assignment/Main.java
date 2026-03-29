package bridge.Assignment;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Gaming Computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingPC = gamingBuilder.getComputer();
        gamingPC.showSpecs();

        // Office Computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officePC = officeBuilder.getComputer();
        officePC.showSpecs();
    }
}