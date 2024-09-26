import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

  @Id
  private String accountNumber;
  private Float balance;
  private String owner;
  private String accountingDepartment;

  // Constructors
  public BankAccount() {}

  public BankAccount(String accountNumber, Float balance, String owner, String accountingDepartment) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.owner = owner;
    this.accountingDepartment = accountingDepartment;
  }

  // Getters and Setters
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getAccountingDepartment() {
    return accountingDepartment;
  }

  public void setAccountingDepartment(String accountingDepartment) {
    this.accountingDepartment = accountingDepartment;
  }

  // toString method for easy printing
  @Override
  public String toString() {
    return "BankAccount{" +
            "accountNumber='" + accountNumber + '\'' +
            ", balance=" + balance +
            ", owner='" + owner + '\'' +
            ", accountingDepartment='" + accountingDepartment + '\'' +
            '}';
  }
}