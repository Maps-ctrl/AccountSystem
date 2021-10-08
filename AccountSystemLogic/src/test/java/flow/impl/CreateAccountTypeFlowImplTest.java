package flow.impl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator mock;

    @InjectMocks
    private CreateAccountTypeFlowImpl CreateAccountTypeFlowImplTest;

    @Before
    public void setUp() throws Exception {

        newMethod();
    }
    @After
    public void tearDown() throws Exception {

        newMethod();
    }
    @Test
    public void create() {
        doThrow.(new RuntimeException().when(translator).milesMethod());
            newMethod();

    }

    private void newMethod() {
        try{
            flow.create(new AccountTypeDto());
        }catch (Exception e){
            verify(translator,time(1).milesMethod());
            verify(translator,never()).create(any(AccountTypeDto.class));
        }

    }
}