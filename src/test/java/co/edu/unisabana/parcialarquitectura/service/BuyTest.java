package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyTest {

    private final Buy service = new Buy(new Database());
    @ExtendWith(MockitoExtension.class)
    @InjectMocks
    Buy buy;

    @Test
    public void test() {
        service.makePurchase(2, 3, "Books");
    }

    @Test
    public void Given_codes_When_buyer_code_and_vendor_code_equals_Then_verify_throw_Illegal_exception() {
        assertThrows(IllegalSaleException.class, ()-> service.makePurchase(3, 3, "Books"));

    }
    @Test
    public void Given_vendor_and_different_buyer_When_purchase_Then_sold() {
        service.makePurchase(2, 3, "Books");
        assertEquals("Product sold", service.makePurchase(2, 3, "Books"));
    }
    @Test
    public void Given_vendor_and_different_buyer_with_null_item_When_purchase_Then_sale_couldnt_be_possible() {
        assertEquals("The sale was not possible", service.makePurchase(2, 3, null));
    }

}