public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.duplex = duplex;
        this.tonerLevel = tonerLevel;
        if (tonerLevel < 0) {
            this.tonerLevel = 0;
        }
        if (tonerLevel > 100) {
            this.tonerLevel = 100;
        }
    }

    public int addToner(int tonerAmount) {
        int tempAmount = this.tonerLevel + tonerAmount;
        if (tempAmount < 0 || tempAmount > 100) {
            return -1;
        }
        this.tonerLevel += tonerAmount;
        return this.tonerLevel;
    }

    public int printPages(int pages) {
        int pagesPrinted = this.duplex ? (pages / 2) + (pages % 2) : pages;
        this.pagesPrinted += pagesPrinted;
        System.out.println("This is " + (this.duplex ? "" : "not") + " a duplex printer");

        return pagesPrinted;
    }

    public int pagesPrinted() {
        return this.pagesPrinted;
    }
}