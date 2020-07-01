package com.company.Test;

import com.company.Auction;
import com.company.Bit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitTest {

    Auction auction = new Auction(20,5,"","");
    Bit bit =  new Bit(20,5,"","BitName");
    @Test
    void placeBit() {
        bit.PlaceBit(2.0);
        assertEquals(2.0,bit.getBit_amount());
        assertNotEquals(0.0,bit.getBit_amount());
    }

    @Test
    void getBit_amount() {
        bit.PlaceBit(2.0);
        double result = bit.getBit_amount();
        assertEquals(2.0, result);
        assertNotEquals(1.0, result);
    }

    @Test
    void getItemname() {
        String result  =  bit.getItemname();
        assertEquals("BitName",result);
    }
}