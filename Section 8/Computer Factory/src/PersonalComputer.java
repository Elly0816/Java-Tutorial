class PersonalComputer extends Product {
    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;

    public PersonalComputer(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public PersonalComputer(String model, String manufacturer, Monitor monitor, Motherboard motherboard,
            ComputerCase computercase) {
        this(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computercase;
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "Yellow");
    }

    public void powerUp() {
        computerCase.pressPowerButton();
        drawLogo();
        motherboard.loadProgram("Windows OS");

    }

    /// **
    // * @return the computerCase
    // */
    // public ComputerCase getComputerCase() {
    // return computerCase;
    // }

    // /**
    // * @return the monitor
    // */
    // public Monitor getMonitor() {
    // return monitor;
    // }

    // /**
    // * @return the motherboard
    // */
    // public Motherboard getMotherboard() {
    // return motherboard;
    // }

    // /**
    // * @param computerCase the computerCase to set
    // */
    // public void setComputerCase(ComputerCase computerCase) {
    // this.computerCase = computerCase;
    // }

    // /**
    // * @param monitor the monitor to set
    // */
    // public void setMonitor(Monitor monitor) {
    // this.monitor = monitor;
    // }

    // /**
    // * @param motherboard the motherboard to set
    // */
    // public void setMotherboard(Motherboard motherboard) {
    // this.motherboard = motherboard;
    // }

    // @Override
    // public String toString() {
    // return "{" +
    // " monitor='" + getMonitor() + "'" +
    // ", motherboard='" + getMotherboard() + "'" +
    // ", computerCase='" + getComputerCase() + "'" +
    // "}" + super.toString();
    // }

}