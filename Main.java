// Nguyễn Khắc An Phú 202418961

import java.util.List;

public class Main {
    public static void main (String[] args) {
        Computer computer1 = new Computer("PC001",
                                          "Dell OptiPlex",
                                          2024, 
                                          15_000_000, 
                                          DeviceStatus.ACTIVE, 
                                          16, 
                                          "Intel Core i5-13400", 
                                          true, 
                                          "192.168.1.101");
        Computer computer2 = new Computer("PC002",
                                          "MacBook Air M2", 
                                          2023, 
                                          22_000_000, 
                                          DeviceStatus.UNDER_MAINTENANCE, 
                                          8, 
                                          "Apple M2", 
                                          "192.168.1.102");
        Computer computerA = new Computer("PC002",
                                          "Acer Nitro 5", 
                                          2020, 
                                          20_000_000, 
                                          DeviceStatus.ACTIVE, 
                                          16, 
                                          "Intel Core i5-10300H", 
                                          "192.168.1.102");
        
        System.out.println("------Khởi tạo Computer với những điều kiện không hợp lệ------");
        // Khởi tạo Computer có dung lượng ram <= 0 hoặc địa chỉ IP rỗng
        try {
            Computer computer3 = new Computer("PC003",
                                          "MacBook Air M2", 
                                          2023, 
                                          22_000_000, 
                                          DeviceStatus.UNDER_MAINTENANCE, 
                                          -10, 
                                          "Apple M2", 
                                          "192.168.1.102");
            System.out.println("Đã khởi tạo computer3 thành công");
        } catch (IllegalArgumentException e) {
            System.out.println("Khởi tạo computer3 không thành công");
        }

        // Năm đưa vào sử dụng lớn hơn năm hiện tại
        try {
            Computer computer = new Computer("PC003",
                                            "MacBook Air M2", 
                                            2030, 
                                            22_000_000, 
                                            DeviceStatus.UNDER_MAINTENANCE, 
                                            10, 
                                            "Apple M2", 
                                            "");
            System.out.println("Khởi tạo thiết bị thành công");
        } catch (IllegalArgumentException e) {
            System.out.println("Khởi tạo thiết bị không thành công, năm đưa vào sử dụng không được lớn hơn năm hiện tại");
        }

        Printer printer1 = new Printer("PR001",
                                       "HP LaserJet Pro", 
                                       2022, 
                                       8_500_000, 
                                       DeviceStatus.ACTIVE, 
                                       PrinterType.LASER, 
                                       125000);
        Printer printer2 = new Printer("PR002",
                                       "Canon PIXMA G3010", 
                                       2024, 
                                       4_500_000, 
                                       DeviceStatus.ACTIVE, 
                                       PrinterType.INKJET, 
                                       25000, 
                                       true);

        System.out.println("------Khởi tạo Printer với những điều kiện không hợp lệ------");
        // Khởi tạo printer3 với số trang đã in âm                               
        try {
            Printer printer3 = new Printer("PR003",
                                       "Canon PIXMA G3010", 
                                       2024, 
                                       4_500_000, 
                                       DeviceStatus.ACTIVE, 
                                       PrinterType.INKJET, 
                                       -100, 
                                       true);
            
            System.out.println("Khởi tạo thiết bị thành công");                           
        } catch (IllegalArgumentException e) {
            System.out.println("Không thể khởi tạo thiết bị vì không hợp lệ");
        }                               

        NetworkPrinter networkPrinter = new NetworkPrinter("NPR001",
                                                            "HP LaserJet Pro M404dn", 
                                                            2023, 
                                                            9_500_000, 
                                                            DeviceStatus.ACTIVE, 
                                                            PrinterType.LASER, 
                                                            120000, 
                                                            "192.168.1.103");

        Projector projector = new Projector("PJ001", 
                                            "Epson EB-X06", 
                                            2023, 
                                            12_000_000, 
                                            DeviceStatus.ACTIVE, 
                                            3600, 
                                            3500.5);

        System.out.println("------Khởi tạo Projector với những điều kiện không hợp lệ------");                                    
        try {
            Projector projector1 = new Projector("PJ002", 
                                            "Epson EB-X06", 
                                            2023, 
                                            12_000_000, 
                                            DeviceStatus.ACTIVE, 
                                            -1000, 
                                            3500.5);
            System.out.println("Khởi tạo thiết bị thành công");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi! Khởi tạo thiết bị không thành công");
        }

        LabRoom labRoom1 = new LabRoom("LR001", "Phòng thực hành 1", 30);
        LabRoom labRoom2 = new LabRoom("LR002", "Phòng thực hành 2", 50);

        System.out.println("------Khởi tạo LabRoom với những điều kiện không hợp lệ------");
        try {
            LabRoom labRoom3 = new LabRoom("", "Phòng thực hành 3", 50);
            System.out.println("Khởi tạo phòng thực hành thành công");
        } catch (Exception e) {
            System.out.println("Lỗi! Không thể khởi tạo ");
        }    

        // Tính chi phí bảo trì Computer
        System.out.print("------Tính chi phí bảo trì Computer------");
        System.out.printf("\nChi phí bảo trì computer1: %.2f VNĐ%n", computer1.calculateMaintenanceCost());
        System.out.printf("Chi phí bảo trì computer2: %.2f VNĐ%n", computer2.calculateMaintenanceCost());

        // Tính chi phí bảo trì Printer
        System.out.print("\n------Tính chi phí bảo trì Printer------");
        System.out.printf("\nChi phí bảo trì printer1: %.2f VNĐ%n", printer1.calculateMaintenanceCost());
        System.out.printf("Chi phí bảo trì printer2: %.2f VNĐ%n", printer2.calculateMaintenanceCost());

        // Tính chi phí bảo trì NetworkPrinter
        System.out.print("\n------Tính chi phí bảo trì NetworkPrinter------");
        System.out.printf("\nChi phí bảo trì networkPrinter: %.2f VNĐ%n", networkPrinter.calculateMaintenanceCost());

        // Tính chi phí bảo trì Projector
        System.out.print("\n------Tính chi phí bảo trì Projector------");
        System.out.printf("\nChi phí bảo trì projector: %.2f VNĐ%n", projector.calculateMaintenanceCost());
        

        // Thêm thiết bị vào phòng
        System.out.println("\n------Thêm thiết bị vào phòng thực hành------");
        labRoom1.addDevice(computer1);
        labRoom1.addDevice(projector);
        labRoom1.addDevice(printer2);
        labRoom1.addDevice(computer2);
        labRoom2.addDevice(computerA);
        labRoom2.addDevice(printer1);
        labRoom2.addDevice(networkPrinter);

        // Thêm thiết bị trùng mã 
        System.out.println("------Thêm thiết bị trùng mã------");
        try {
            labRoom1.addDevice(computerA);
            System.out.println("Thêm thiết bị thành công");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi! Không thể thêm thiết bị trùng mã");
        }

        // In danh sách các thiết bị trong phòng
        System.out.println("------Các thiết bị trong labRoom1------");
        List<Device> devices1 = labRoom1.getDevices();
        for (Device device : devices1) {
            System.out.print(device.displayInfo());
            System.out.println("\n----------------------------");
        }
        System.out.println("------Các thiết bị trong labRoom2------");
        List<Device> devices2 = labRoom2.getDevices();
        for (Device device : devices2) {
            System.out.print(device.displayInfo());
            System.out.println("\n----------------------------");
        }

        // Tính tổng chi phí bảo trì dự kiến của mỗi phòng
        System.out.println("------Chi phí bảo trì dự kiến của labRoom1------");
        System.out.printf("Chi phí bảo trì dự kiến là: %.2f VNĐ%n", labRoom1.calculateAnnualMaintenanceCost());
        System.out.println("------Chi phí bảo trì dự kiến của labRoom2------");
        System.out.printf("Chi phí bảo trì dự kiến là: %.2f VNĐ%n", labRoom2.calculateAnnualMaintenanceCost());

        // Liệt kê các thiết bị cần bảo trì
        System.out.println("------Liệt kê các thiết bị cần bảo trì trong labRoom1------");
        List<Device> devicesRequiringMaintenance1 = labRoom1.getDevicesRequiringMaintenance();
        for (Device device : devicesRequiringMaintenance1) {
            System.out.print(device.displayInfo());
            System.out.println("\n----------------------------");
        }
        System.out.println("------Liệt kê các thiết bị cần bảo trì trong labRoom2------");
        List<Device> devicesRequiringMaintenance2 = labRoom1.getDevicesRequiringMaintenance();
        for (Device device : devicesRequiringMaintenance2) {
            System.out.print(device.displayInfo());
            System.out.println("\n----------------------------");
        }

        // Kết nối mạng cho các đối tượng thực thi INetworkable
        System.out.println("------Kết nối mạng------");
        System.out.println("Kết nối mạng cho computer1");
        computer1.connect("192.168.1.102");
        System.out.println("Kết nối mạng cho networkPrinter");
        networkPrinter.connect("192.168.1.101");
        System.out.println("------Kiểm tra khi kết nối computer1 trong khi đã kết nối------");
        try {
            computer1.connect("1.1.1.1");
        } catch (IllegalStateException e) {
            System.out.printf("Lỗi!" + e.getMessage());
            System.out.println();
        }
        System.out.println("Ngắt kết nối computer1");
        computer1.disconnect();
        System.out.println("Ngắt kết nối networkPrinter");
        networkPrinter.disconnect();

        // Duyệt các thiết bị mạng thông qua INetworkable
        System.out.println("------Duyệt các thiết bị mạng------");
        // Đưa các thiết bị mạng vào danh sách kiểu INetworkable
        INetworkable[] networkDevices = {
            computer1,
            computer2,
            networkPrinter
        };

        // Duyệt các thiết bị mạng
        for (INetworkable device : networkDevices) {
            try {
                device.connect("192.168.1.110");

                System.out.println("Kết nối thành công!");
                System.out.println("IP: " + device.getIpAddress());
                System.out.println("Trạng thái: " + device.isConnected());

                device.disconnect();

                System.out.println("Sau khi ngắt kết nối:");
                System.out.println("IP: " + device.getIpAddress());
                System.out.println("Trạng thái: " + device.isConnected());

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

            System.out.println("----------------------");
        }
    }
}