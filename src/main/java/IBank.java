public interface IBank {

    void create(String name, String address, String phone, String prefix);
    void createAccount(String owner_name, String owner_address,
                       String owner_phone, String account_type, float amount);
    void deposit(String account_no, String owner_name, String depositor_name,
                 String depositor_phone, float amount);
    void withdrawal(String account_no, float amount);

}
