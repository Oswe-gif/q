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
class BuyTest {
    @InjectMocks
    Buy buy;
    @Mock
    Database database;

    @Test
    void Given_vendedorYcompradorSonIguales_When_invoke_makePurchase_Then_IllegalSaleException()
    {
        int buyCode=1, vendorCode=1;
        String item="carro";
        Assertions.assertThrows(IllegalSaleException.class, () -> {
            buy.makePurchase(buyCode,vendorCode,item);
        });
    }

    //jejeje

}