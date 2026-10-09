import java.time.LocalDate;

public class Computer extends Device implements INetworkable {
    private int ramCapacity;
    private String processorType;
    private boolean hasDiscreteGpu;
    private String ipAddress;
    private boolean connected = false;

    // 2 constructor
    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType, boolean hasDiscreteGpu, String ipAddress) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status);

        // Kiểm tra dung lượng ram
        if (ramCapacity <= 0) {
            throw new IllegalArgumentException("Dung lượng ram phải lớn hơn 0");
        }

        // Kiểm tra địa chỉ IP
        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("Địa chỉ IP không được rỗng");
        }

        this.ramCapacity = ramCapacity;
        this.processorType = processorType;
        this.hasDiscreteGpu = hasDiscreteGpu;
        this.ipAddress = ipAddress;
    }

    public Computer(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, 
    int ramCapacity, String processorType, String ipAddress) {
        this(deviceId, deviceName, commissioningYear, purchasePrice, status, ramCapacity, processorType, false, ipAddress);
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
        System.out.println("Đang kết nối ...");

        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("Địa chỉ IP không được rỗng");
        }

        if (this.connected) {
            throw new IllegalStateException("Thiết bị đã kết nối, không thể thực hiện yêu cầu");
        }

        this.ipAddress = ipAddress;
        this.connected = true;
        System.out.println("Kết nối thành công");
    }

    // Ngắt kết nối
    @Override 
    public void disconnect() {
        if (!this.connected) {
            throw new IllegalStateException("Thiết bị hiện tại chưa kết nối, không thể thực hiện yêu cầu");
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
