package uz.jl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void transfer() {
//        transactionRepository = Mockito.mock(TransactionRepository.class);
        transactionService = new TransactionService(transactionRepository);
        BigDecimal amount = new BigDecimal("10000000");
        when(transactionRepository.transfer(amount)).thenReturn("successfully transferred");
        String result = transactionService.transaction(amount);
        String expected = "successfully transferred";
        assertEquals(expected, result);
    }

    @Test
    void transferWithException() {
        transactionRepository = Mockito.mock(TransactionRepository.class);
        transactionService = new TransactionService(transactionRepository);
        BigDecimal amount = new BigDecimal("-10000000");
        assertThrows(RuntimeException.class,()->{
            transactionService.transaction(amount);
        }).printStackTrace();
    }


}