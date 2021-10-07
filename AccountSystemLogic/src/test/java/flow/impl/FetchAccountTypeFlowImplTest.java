package flow.impl;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl testClass;
    @BeforeEach
    void setUp() {
        testClass = new FetchAccountTypeFlowImpl(accountTypeTranslator: null);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodToTest() {
        assertFalse(testClass.methodToTest());
    }
}