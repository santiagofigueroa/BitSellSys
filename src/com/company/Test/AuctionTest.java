package com.company.Test;

import com.company.Auction;
import com.company.Bit;
import com.company.FileHandler;
import com.company.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {
    FileHandler fileHandler = new FileHandler();
    Auction auction = new Auction(20,5,"","");
    Item item =  new Item(20,5,"","ItemName");
    Bit bit =  new Bit(20,5,"","");
    @Test
    void addItem() {
        auction.AddItem(item);
        assertEquals(1,auction.getLItems().size());
    }

    @Test
    void placeBit() {
       // auction.
        auction.PlaceBit(bit);
        assertEquals(1,auction.getBits().size());
        assertEquals(0,auction.getBits().indexOf(bit));
    }

    @Test
    void getUserID() {
        int result = bit.GetUserID();
        assertEquals(5,result);
        assertNotEquals(0,result);
    }

    @Test
    void getBits() {
        ArrayList<Bit> arrayList = new ArrayList<Bit>();
        arrayList.add(bit);
        auction.PlaceBit(bit);
        assertNotNull(arrayList);
        assertEquals(1,auction.getBits().size());
    }

    @Test
    void getLItems() {
        ArrayList<Item> arrayList = new ArrayList<Item>();
        arrayList.add(item);
        auction.AddItem(item);
        assertNotNull(arrayList);
        assertEquals(1,auction.getLItems().size());

    }

    @Test
    void getTimestamp() {
        auction.setTimestamp(15);
        int result = auction.getTimestamp();
        assertEquals(15,result);
        assertNotEquals(0,result);
    }

    @Test
    void setTimestamp() {
        auction.setTimestamp(20);
        int result = auction.getTimestamp();
        assertEquals(20,result);
        assertNotEquals(0,result);
    }

    @Test
    void getItemByName() {
        auction.AddItem(item);
        boolean result = auction.getItemByName("ItemName");
        assertEquals(true,result);
        assertNotEquals(false,result);
    }
}