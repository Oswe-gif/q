package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BuyTest {

    @InjectMocks
    Buy buy;

    @Mock
    Database database;

    @Test
    void Given_vendorCode_equals_to_buyerCode_When_invoke_makePurchase_Then_IllegalSaleException(){
        int vendorCode = 1;
        int buyerCode = 1;
        String item = "algo";

        Assertions.assertThrows(IllegalSaleException.class, ()->{
            buy.makePurchase(vendorCode, buyerCode, item);
        });
    }
    @Test
    void Given_vendorCode_different_to_buyerCode_and_result_is_one_When_invoke_makePurchase_Then_success_message(){
        int vendorCode = 2;
        int buyerCode = 1;
        String item = "algo";

        Mockito.when(database.savePurchase(buyerCode, item)).thenReturn(1);
        Assertions.assertEquals("Product sold", buy.makePurchase(vendorCode, buyerCode, item));
        Mockito.verify(database).savePurchase(buyerCode, item);
    }
    @Test
    void Given_vendorCode_different_to_buyerCode_and_the_result_is_not_one_When_invoke_makePurchase_Then_failed_message(){
        int vendorCode = 2;
        int buyerCode = 1;
        String item = "algo";

        Mockito.when(database.savePurchase(buyerCode, item)).thenReturn(2);
        Assertions.assertEquals("The sale was not possible", buy.makePurchase(vendorCode, buyerCode, item));
        Mockito.verify(database).savePurchase(buyerCode, item);
    }
}
