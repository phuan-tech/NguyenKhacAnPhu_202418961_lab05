import java.time.LocalDate;

public abstract class Device {
    private String deviceId;
    private String deviceName;
    private int commissioningYear;
    private double purchasePrice;
    private DeviceStatus status;

    // Constructor
    public Device(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status) {
        // Kiểm tra mã thiết bị
        if (deviceId == null || deviceId.isBlank()) {
            throw new IllegalArgumentException("Mã thiết bị không được rỗng");
        }

        // Kiểm tra giá mua
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("Giá mua phải lớn hơn 0");
        }

        // Kiểm tra năm đưa vào sử dụng
        int currentYear = LocalDate.now().getYear();
        if (commissioningYear > currentYear) {
            throw new IllegalArgumentException("Năm đưa vào sử dụng không được lớn hơn năm hiện tại");
        }

        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.commissioningYear = commissioningYear;
        this.purchasePrice = purchasePrice;
        this.status = status;
    }

    // Tính chi phí bảo trì
    public abstract double calculateMaintenanceCost();

    // Trả về thông tin dưới dạng chuỗi
    public String displayInfo() {
        return "Mã thiết bị: " + this.deviceId
                + "\nTên thiết bị: " + this.deviceName
                + "\nNăm đưa vào sử dụng: " + this.commissioningYear
                + "\nGiá mua: " + this.purchasePrice
                + "\nTrạng thái: " + this.status;
    }

    // Lấy giá mua
    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    // Lấy năm đưa vào sử dụng
    public int getCommissioningYear() {
        return this.commissioningYear;
    }

    // Lấy mã thiết bị
    public String getDeviceId() {
        return this.deviceId;
    }

    // Lấy trạng thái hoạt động
    public DeviceStatus getDeviceStatus() {
        return this.status;
    }
}
