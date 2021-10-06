package za.ac.nwu.domain.dto.persistence;

import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT_TYPE",schema = "Discovery Miles")

public class AccountTransaction implements Serializable{
    private static final long serialVersionUID = -1801640786030747480L;

    /*private Long transactionId;
    private Long accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;*/

    @Id
    @SequenceGenerator(name = "DISC_GENERIC_SEQ", sequenceName = "DISCOVERY_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISC_GENERIC_SEQ")
    @Column(name = "TX_ID")
    private Long transactionId;

    //@Column(name = "ACCOUNT_TYPE_ID") //Added to GetOperation in
    private AccountType accountType; //DB which represents the table
    //we do the above for any foreign key

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "AMMOUNT")
    private Long amount;

    @Column(name = "TX_DATE")
    private Long transactionDate;

    public AccountTransaction(Long transactionId, Long accountTypeId, Long memberId, Long amount, Long transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)//In this code we can have many transactions
    @JoinColumn(name = "ACCOUNT_TYPE_ID")//and they'll all lead to one place
    public Long getAccountTypeId() {
        return accountType;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountType = accountTypeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAccountType(AccountType accountType){
        this.accountType =accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
}
