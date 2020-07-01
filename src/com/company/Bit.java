package com.company;
import java.awt.*;

public class Bit extends Auction {

    private double bit_amount;
    private String item_name;

    public Bit(int time_s, int user_i, String act, String item_n) {
        super(time_s, user_i ,act, item_n);
        this.item_name = item_n;
    }

    public void PlaceBit(double b ){
        this.bit_amount = b;
    }

    public double getBit_amount()
    {
        return  this.bit_amount;
    }

    public String getItemname(){
        return  this.item_name;
    }
}
