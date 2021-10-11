package flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTransaction;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.as.translator.AccountTransactionTranslator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class CreateAccountTransactionFlowImpl {
    public AccountTransaction create(AccountTransaction accountTransaction){
        if (LOGGER.isInfoEnabled()){
            if(null != accountTransaction){
                LOGGER.info("The input object was {} ", accountTransaction);
            }
        }


        accountTransaction.setTransactionDate(LocalDate.now());

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic((accountTransaction.
                getAccountTypeMnemonic()));
        LOGGER.info("Got AccountType for {} ", accountTransaction.getAccountTypeMnemonic());

        Members member = fetchMembersFlow.getMembersDbByUsername((accountTransaction.getUsername()));
        LOGGER.info("Got Member for {}", accountTransaction.getUsername());

        AccountTransaction accountTransaction = accountTransaction.buildAccountTransaction(accountType,member);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if ((Objects.equals(accountTransaction.getDetails(), "add") && (
                Objects.equals(accountType.getMnemonic(), member.getAccountType().getMnemonic()))))
        {
            accountTransaction.setDetails("An amount of " + String.valueOf(accountTransaction.getAmount()) + "" +
                    " has been added to the account." );
            member.setBalance(member.getBalance() + accountTransaction.getAmount());
        }
        else if (Objects.equals(accountTransaction.getDetails(), "subtract") && (Objects.equals(accountType.
                getMnemonic(), member.getAccountType().getMnemonic())))
        {
            accountTransaction.setDetails("An amount of " + String.valueOf(accountTransaction.getAmount()) + " " +
                    "has been subtracted from the account." );
            member.setBalance(member.getBalance() - accountTransaction.getAmount());
        }
        else if (!Objects.equals(accountType.getMnemonic(), member.getAccountType().getMnemonic()))
        {
            accountTransaction.setDetails("No amount was added or subtracted. " +
                    "Incompatible Username and Account Type");
        }

        AccountTransaction results = new AccountTransaction(createdAccountTransaction);
        LOGGER.info("The return object id {}", results);
        return results;
    }
}
