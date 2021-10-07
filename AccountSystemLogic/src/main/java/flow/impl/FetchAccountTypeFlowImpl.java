package flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.translater.config.flow.impl.AccountTypeTranslator;
import za.ac.nwu.domain.dto.persistence.AccountTypeDto;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component("FetchAccountTypeFlowName")
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {


    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl (AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }



    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos= new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto(mnemonic: "MILES",accountTypeName:"Miles", LocalDate.now()));
        return accountTypeDtos;

    }
    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        return accountTypeTranslator.getAllAccountTypes();
    }
    public boolean methodToTest(){
        return true;
    }
}
