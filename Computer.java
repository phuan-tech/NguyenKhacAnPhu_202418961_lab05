public class Computer extends Device implements INetworkable {
    private int ramCapacity;
    private String processorType;
    private boolean hasDiscreteGpu;
    private String ipAddress;
    private boolean connected;

    // 2 constructor
    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType, boolean hasDiscreteGpu, String ipAddress, boolean connected) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status);
        this.ramCapacity = ramCapacity;
        this.processorType = processorType;
        this.hasDiscreteGpu = hasDiscreteGpu;
        this.ipAddress = ipAddress;
        this.connected = connected;
    }

    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType, String ipAddress, boolean connected) {
        this(deviceId, deviceName, commissioningYear, purchasePrice, status, ramCapacity, processorType, false, ipAddress, connected);
    }

    @Override
    public double calculateMaintenanceCost() {
        double cost =  * 5 / 100;

    }

    @Override 
    public String displayInfo() {
        return super.displayInfo()
                + "\nDung lượng ram: " + this.ramCapacity
                + "\nLoại bộ xử lý: " + this.processorType
                + "\nGPU rời: " + this.hasDiscreteGpu
                + "\nĐịa chỉ IP: " + this.ipAddress
                + "\nĐã kết nối mạng: " + this.connected;
    }
}
