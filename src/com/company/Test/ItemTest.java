package com.company.Test;

import com.company.Auction;
import com.company.Bit;
import com.company.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Auction auction = new Auction(20,5,"","");
    Item item =  new Item(20,5,"SELL","ItemName");
    Bit bit =  new Bit(20,5,"BIT","BitName");

    @Test
    void getItemName() {
        String result = item.getItemName();
        assertEquals("ItemName",result);
        assertNotEquals("",result);
    }

    @Test
    void setPrice() {
        item.setPrice(1.0);
       double result = item.getPaidPrice();
        assertEquals(1.0,result);
        assertNotEquals(0.0,result);
    }

    @Test
    void setCloseTime() {
        item.setCloseTime(30);
        int result =item.getCloseTime();
        assertEquals(30,result);
        assertNotEquals(0,result);
    }

    @Test
    void getPrice() {
        item.setPrice(15.5);
        double result = item.getPaidPrice();
        assertEquals(15.5,result);
        assertNotEquals(0.0,result);
    }

    @Test
    void getCloseTime() {
        item.setCloseTime(20);
        double result = item.getCloseTime();
        assertEquals(20,result);
        assertNotEquals(0.0,result);
    }

    @Test
    void placeItemBit() {
        item.placeItemBit(bit);
        assertEquals(1,item.getItemBits().size());
    }

    @Test
    void getItemBits() {
        Bit bit1 = new Bit(1,1,"BIT","Second");
        item.placeItemBit(bit);
        item.placeItemBit(bit1);
        assertEquals(2,item.getItemBits().size());
        assertNotEquals(0,item.getItemBits().size());
    }

    @Test
    void bitsLenght() {
        Bit bit1 = new Bit(1,1,"BIT","Second");
        item.placeItemBit(bit);
        item.placeItemBit(bit1);
        assertEquals(2,item.getItemBits().size());
        assertNotEquals(0,item.getItemBits().size());

    }
}