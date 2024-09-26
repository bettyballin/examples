import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

  @Id
  private String accountNumber;
  private Float balance;
  private String owner;
  private String accountingDepartment;

  //...

}