public class Init_Bank extends Thread implements IBank {

    private Thread thread;
    private String threadName;
    private volatile boolean running = true;

    Init_Bank(String name) {
        threadName = name;
        System.out.println("Creating "+ threadName);
    }

//    instance variables
    String name, address, phone, prefix = null;
    String account_no, owner_name, owner_address, owner_phone, account_type,
            depositor_name, depositor_phone = null;
    float balance = 0F;

    int i = 0;
    int startNumber = 1000;

    // run
    public void run() {
        while (running) {
            System.out.println("Running thread: " + threadName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stopping thread: "+ threadName);
    }

    // start
    public void start () {
        System.out.println("Starting " +  threadName );
        if (thread == null) {
            thread = new Thread (this, threadName);
            thread.start ();
        }
    }

    // will handle stopping the thread
    public void stopThread() {
        running = false;
    }

    // will generate an account number
    public int generateAccountNo() {
        while (i > 0 ) {
            return startNumber += 1;
        }
        i++;
        return startNumber;
    }

    // return the current balance
    public float getBalance() {
        return balance;
    }

    @Override
    public void create(String name, String address, String phone, String prefix) {
        if (name.isEmpty() && address.isEmpty() && phone.isEmpty() && prefix.isEmpty())
            System.out.println("Note: All fields are required to create a bank.");

        // assign the incoming args to the class
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.prefix = prefix;
        System.out.println("New Bank: "+ this.name +" created successfully.");
    }

    @Override
    public void createAccount(String owner_name, String owner_address,
                              String owner_phone, String account_type, float amount) {

        // assign the params values to the instance variable
        this.account_no = "AC" + generateAccountNo();
        this.account_type = account_type;
        this.owner_name = owner_name;
        this.owner_address = owner_address;
        this.owner_phone = owner_phone;
        this.balance = amount;
        System.out.println("New Bank Account: "+ account_no +" | Owner: "+ owner_name +" created successfully.");

    }

    @Override
    public void deposit(String account_no, String owner_name, String depositor_name,
                        String depositor_phone, float amount){
        this.depositor_name = depositor_name;
        this.depositor_phone = depositor_phone;
        this.balance += amount;
        System.out.println("Deposit: "+ amount +" in account: "+ account_no +" was successful");
        System.out.println("Your current balance is: "+ getBalance());
    }

    @Override
    public void withdrawal(String account_no, float amount) {
        this.account_no = account_no;
        this.balance = this.balance - amount;
        System.out.println("Withdrawal: "+ amount +" from account: "+ account_no +" was successful");
        System.out.println("Your current balance is: "+ getBalance());
    }

}
