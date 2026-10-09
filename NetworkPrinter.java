public class NetworkPrinter extends Printer implements INetworkable {
    private String ipAddress;
    private boolean connected;

    // 2 constructor
    public NetworkPrinter(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, PrinterType printerType, int pagesPrinted, boolean isColorPrinter, String ipAddress) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status, printerType, pagesPrinted);

        // Kiểm tra địa chỉ IP
        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("Địa chỉ IP không được rỗng");
        }
        this.ipAddress = ipAddress;
    }

    public NetworkPrinter(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, PrinterType printerType, int pagesPrinted, String ipAddress) {
        this(deviceId, deviceName, commissioningYear, purchasePrice, status, printerType, pagesPrinted, false, ipAddress);
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

    // Hiển thị thông tin
    @Override 
    public String displayInfo() {
        return super.displayInfo()
                + "\nMáy in có khả năng kết nối mạng";
    }
}
