public abstract class Device {
    private String deviceId;
    private String deviceName;
    private int commissioningYear;
    private double purchasePrice;
    private DeviceStatus status;

    // Constructor
    public Device(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status) {
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
}
