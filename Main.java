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

        LabRoom labRoom1 = new LabRoom("LR001", "Phòng thực hành 1", 30);
        LabRoom labRoom2 = new LabRoom("LR002", "Phòng thực hành 2", 50);

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
        System.out.print("\n------Thêm thiết bị vào phòng thực hành 1------\n");
        labRoom1.addDevice(computer1);
        System.out.print(labRoom1.findDevice("PC001").displayInfo());

    }
}