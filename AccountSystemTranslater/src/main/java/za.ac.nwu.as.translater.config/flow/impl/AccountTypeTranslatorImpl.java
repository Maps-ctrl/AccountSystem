package za.ac.nwu.as.translater.config.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.repo.persistence.AccountTypeRepository;
import za.ac.nwu.domain.dto.persistence.AccountTypeDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator{

    private final AccountTypeRepository accountTypeRepository;
    
    @Autowired
    public AccountTypeTranslatorImpl (AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }
    
    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for (AccountType accountType : accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB",e);

        }
        return accountTypeDtos;
    }
}
