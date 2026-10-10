import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class LabRoom {
    private String roomId;
    private String roomName;
    private int capacity;
    private List<Device> devices;

    // Constructor
    public LabRoom(String roomId, String roomName, int capacity) {
        // Kiểm tra mã phòng
        if (roomId == null || roomId.isBlank()) {
            throw new IllegalArgumentException("Mã phòng không được rỗng");
        }

        // Kiểm tra tên phòng
        if (roomName == null || roomName.isBlank()) {
            throw new IllegalArgumentException("Tên phòng không hợp lệ");
        }

        // Kiểm tra sức chứa
        if (capacity < 0) {
            throw new IllegalArgumentException("Sức chứa không được âm");
        }

        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.devices = new ArrayList<>();
    }

    // Thêm thiết bị
    public void addDevice(Device device) {
        for (Device dev : this.devices) {
            if (dev.getDeviceId() == device.getDeviceId()) {
                throw new IllegalArgumentException("Mã thiết bị đã tồn tại");
            }
        }

        this.devices.add(device);
    }

    // Xóa thiết bị
    public boolean removeDevice(String deviceId) {
        for (Device device : this.devices) {
            if (device.getDeviceId().equals(deviceId)) {
                this.devices.remove(device);
                System.out.println("Đã xóa thiết bị thành công");
                return true;
            }
        }
        
        System.out.println("Thiết bị không tồn tại trong phòng");
        return false;
    }

    // Tìm thiết bị
    public Device findDevice(String deviceId) {
        for (Device device : this.devices) {
            if (device.getDeviceId().equals(deviceId)) {
                return device;
            }
        }

        System.out.println("Không tìm thấy thiết bị");
        return null;
    }
    
    // Tính chi phí bảo trì hàng năm
    public double calculateAnnualMaintenanceCost() {
        double cost = 0;
        for (Device device : this.devices) {
            cost += device.calculateMaintenanceCost();
        }
        return cost;
    }

    // Lấy danh sách thiết bị cần bảo trì
    public List<Device> getDevicesRequiringMaintenance() {
        List<Device> devicesRequiringMaintenance = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        for (Device device : this.devices) {
            if (device == null) continue; 

            int yearsInService = currentYear - device.getCommissioningYear();
            if (yearsInService > 5 || device.getDeviceStatus() == DeviceStatus.UNDER_MAINTENANCE) {
                devicesRequiringMaintenance.add(device);
            }
        }
        
        return devicesRequiringMaintenance;
    }
}
