package za.ac.nwu.domain.dto.persistence;

import com.fasteral.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@ApiModel(value = AccountType, description = "A DTO that represents the AccountType")
@Entity
@Table(name = "ACCOUNT_TYPE",schema = "Discovery Miles")

public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = 4656451835837549737L;
    @Id
    @SequenceGenerator(name = "DISC_GENERIC_SEQ", sequenceName = "DISCOVERY_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISC_GENERIC_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "ACCOUNT_TYPE_NAME")
    private String accountTypeName;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    public AccountTypeDto(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }
    //one accountType(Miles) can have many transactions
    @OneToMany(targetEntity = AccountTransaction.class,fetch = FetchType.LAZY, mappedBy = "accountType",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction>@getAccountTransactions(){ //All the rows in table will be unique
        return accountTransactions;
    }
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(position =1,

            value= "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies AccountType",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position =2,

            value= "AccountType Name",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lang.String",
            example = "Miles",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position =3,

            value= "AccountType Creation Date",
            name = "CreationDate",
            notes = "Date when account was created",
            dataType = "java.lang.String",
            example = "2020-05-21",
            allowEmptyValue = true ,
            required = false)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public AccountTypeDto() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }
    @JsonIgnore //Any getters showing up which aren't part of your model are going to be added to the gitIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationDate());
    }


    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
