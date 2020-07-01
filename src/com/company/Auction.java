package com.company;

import java.util.ArrayList;

public class Auction {
    // fields needed for Auction to start

    private int time_stamp = 0;
    private int user_id;
    private String item_name;
    private String action;


    // Arrays to store
    private ArrayList<Item> items;
    private ArrayList<Bit> bits;

    public Auction(int time_s, int user_i, String act, String item_n) {
        // fields that need to be
        this.time_stamp = time_s;
        this.user_id = user_i;
        this.item_name = item_n;
        this.action = act;
        // Initialize array
        if (items == null && bits == null) {
            items = new ArrayList<Item>();
            bits = new ArrayList<Bit>();
        }

    }

    public void AddItem(Item item) {
        items.add(item);
    }

    public void PlaceBit(Bit bit) {
        bits.add(bit);

            for(Item item : items){
                if(bit.getItemname().equals(item.getItemName())){
                item.placeItemBit(bit);
            }
        }
    }

    public int GetUserID (){
      return this.user_id;
    }

    public ArrayList<Bit> getBits()
    {
        return bits;
    }

    public ArrayList<Item> getLItems()
    {
        return items;
    }

    public int getTimestamp(){
        return this.time_stamp;
    }

    public void  setTimestamp(int new_time){
        this.time_stamp = new_time;
    }

    public boolean getItemByName(String name){
        for(Item item : items){
            if(item.getItemName().equals(name)){
                return true;
            }
        }
        return false ;
    }

}
