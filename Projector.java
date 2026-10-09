public class Projector extends Device {
    public int brightness;
    public double lampHoursUsed;

    // Constructor
    public Projector(String deviceId, String deviceName, int commissioningYear, double purchasePrice, DeviceStatus status, int brightness, double lampHoursUsed) {
        super(deviceId, deviceName, commissioningYear, purchasePrice, status);

        // Kiểm tra độ sáng
        if (brightness < 0) {
            throw new IllegalArgumentException("Độ sáng không được âm");
        }

        // Kiểm tra số giờ sử dụng đèn
        if (lampHoursUsed < 0) {
            throw new IllegalArgumentException("Số giờ sử dụng của bóng đèn không được âm");
        }

        this.brightness = brightness;
        this.lampHoursUsed = lampHoursUsed;
    }

    // Tính chi phí bảo trì
    @Override 
    public double calculateMaintenanceCost() {
        double cost = this.getPurchasePrice() * 3 / 100;
        if (this.lampHoursUsed > 3000) {
            cost += 1_500_000;
        }
        return cost;
    }

    // Thông tin thiết bị
    @Override 
    public String displayInfo() {
        return this.displayInfo()
                + "\nĐộ sáng: " + this.brightness
                + "\nSố giờ đã sử dụng bóng đèn: " + this.lampHoursUsed;
    }
}
