import java.time.LocalDate;

public class Computer extends Device implements INetworkable {
    private int ramCapacity;
    private String processorType;
    private boolean hasDiscreteGpu;
    private String ipAddress;
    private boolean connected;

    // 2 constructor
    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType, boolean hasDiscreteGpu) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status);
        this.ramCapacity = ramCapacity;
        this.processorType = processorType;
        this.hasDiscreteGpu = hasDiscreteGpu;
    }

    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType) {
        this(deviceId, deviceName, commissioningYear, purchasePrice, status, ramCapacity, processorType, false);
    }

    // Tính chi phí bảo trì
    @Override
    public double calculateMaintenanceCost() {
        double cost = this.getPurchasePrice() * 5 / 100;
        int currentYear = LocalDate.now().getYear();

        if (this.hasDiscreteGpu) {
            cost += this.getPurchasePrice() * 2 / 100;
        }

        if (currentYear - this.getCommissioningYear() > 5) {
            cost += this.getPurchasePrice() * 1 / 100;
        }
        
        return cost;
    }

    // Thông tin
    @Override 
    public String displayInfo() {
        return super.displayInfo()
                + "\nDung lượng ram: " + this.ramCapacity
                + "\nLoại bộ xử lý: " + this.processorType
                + "\nGPU rời: " + this.hasDiscreteGpu
                + "\nĐịa chỉ IP: " + this.ipAddress
                + "\nĐã kết nối mạng: " + this.connected;
    }

    // Lấy địa chỉ IP
    @Override 
    public String getIpAddress() {
        return this.ipAddress;
    }

    // Kết nối
    @Override 
    public void connect(String ipAddress) {
        if (ipAddress.isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ IP không được rỗng");
        }

        if (this.connected) {
            throw new IllegalStateException("Thiết bị đã kết nối");
        }

        this.ipAddress = ipAddress;
        this.connected = true;
        System.out.println("Kết nối thành công");
    }

    // Ngắt kết nối
    @Override 
    public void disconnect() {
        if (!this.connected) {
            throw new IllegalStateException("Thiết bị hiện tại chưa kết nối");
        }
        this.connected = false;
        this.ipAddress = null;
    }

    // Kiểm tra kết nối
    @Override 
    public boolean isConnected() {
        return this.connected;
    }
}
