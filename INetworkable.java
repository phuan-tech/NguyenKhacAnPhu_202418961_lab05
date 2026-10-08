public interface INetworkable {
    // Lấy địa chỉ IP
    String getIpAddress();

    // Kết nối
    void connect(String ipAddress);

    // Ngắt kết nối
    void disconnect();

    // Kiểm tra kết nối
    boolean isConnected();
}
