class Main {

    public static void main(String[] args) {
        String manufacturer = "Ark";

        // Computer case
        ComputerCase computerCase = new ComputerCase("H", manufacturer, "350");
        computerCase.setPowerSupply("350");

        // Monitor
        Monitor monitor = new Monitor("B", manufacturer);
        monitor.setResolution("3640 x 2160");
        monitor.setSize(25);
        monitor.setHeight(15);
        monitor.setWidth(20);
        monitor.setDepth(2);

        // Motherboard
        Motherboard motherboard = new Motherboard("X", manufacturer);
        motherboard.setBios("Dominion");
        motherboard.setCardSlots(5);
        motherboard.setRamSlots(8);

        // Personal computer
        PersonalComputer thisPC = new PersonalComputer("Colossus", manufacturer, monitor, motherboard, computerCase);
        // thisPC.setComputerCase(computerCase);
        // thisPC.setMonitor(monitor);
        // thisPC.setMotherboard(motherboard);
        System.out.println(thisPC);

        thisPC.powerUp();

        // thisPC.getComputerCase().pressPowerButton();
        // thisPC.getMonitor().drawPixelAt(thisPC.getMonitor().getWidth() / 2,
        // thisPC.getMonitor().getHeight() / 2, "Gold");
        // thisPC.getMotherboard().loadProgram("Windos OS");

    }
}