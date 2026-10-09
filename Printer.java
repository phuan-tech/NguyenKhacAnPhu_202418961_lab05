public class Printer extends Device {
    private PrinterType printerType;
    private int pagesPrinted;
    private boolean isColorPrinter;

    public Printer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, PrinterType printerType, int pagesPrinted, boolean isColorPrinter) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status);

        // Kiểm tra số trang đã in
        if (pagesPrinted < 0) {
            throw new IllegalArgumentException("Số trang đã in không được âm");
        }

        this.printerType = printerType;
        this.pagesPrinted = pagesPrinted;
        this.isColorPrinter = isColorPrinter;
    }

    public Printer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, PrinterType printerType, int pagesPrinted) {
        this(deviceId, deviceName, commissioningYear, purchasePrice, status, printerType, pagesPrinted, false);
    }

    // Tính chi phí bảo trì
    @Override 
    public double calculateMaintenanceCost() {
        double cost = this.getPurchasePrice() * 4 / 100;

        if (pagesPrinted > 100000) {
            cost += 500000;
        }

        if (this.isColorPrinter) {
            cost += 300000;
        }

        return cost;
    }

    // Thông tin thiết bị
    @Override 
    public String displayInfo() {
        return this.displayInfo()
                + "\nLoại máy in: " + this.printerType
                + "\nSố trang đã in: " + this.pagesPrinted
                + "\nMáy in màu: " + this.isColorPrinter;
    }
} 