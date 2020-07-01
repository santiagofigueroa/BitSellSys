package com.company;

import java.util.*;

public class Item extends Auction{
    private ArrayList<Bit> itemBits;
    private double [] allbits; //  All bits will be safe in this array.
    private double reserve_price;
    private String itemName;
    boolean sold = false;
    private String status;
    private int close_time;
    private int i; // To populate bits array.
    private double secondMax;

    public Item(int time_s, int user_i, String act, String item_n) {
        super(time_s, user_i,act,item_n);
        int i = 0;
        //  to able to get the Unique name from the items in the list.
        this.itemName = item_n;
        if(allbits == null) {
            itemBits = new ArrayList<>();
        }
    }

    public String getItemName(){
        return this.itemName;
    }

    public void  setPrice (double r_price) {

        if (r_price != reserve_price){
            this.reserve_price = r_price;
        } else{
            System.out.println("Price is lower than highest/Reserve price");
        }
    }

    public void setCloseTime(int c_time) {
        this.close_time = c_time;
    }

    public double getPaidPrice() {
        if (ItemStat().equals("SOLD")) {
            double max = getHighest();
            double secMax = allbits[0];
            for (int j = 0; j < allbits.length; j++) {
                if (max > allbits[j]) {
                    if (secMax < allbits[j]) {
                        secMax = allbits[j];
                    } else if (secMax > allbits[j]) {
                        secMax = allbits[j];
                    }
                }
            }
            this.secondMax = secMax;
            return secMax;
        }
        return reserve_price;
    }

    public int getCloseTime(){
        return this.close_time;
    }

    public void placeItemBit (Bit placedBit){
        itemBits.add(placedBit);
    }

    public double getLowest(){

        return getMinValue(allbits);
    }

    public double  getHighest(){

        return  getMaxValue(allbits);
    }
    private static double getMaxValue(double[] array) {
        double maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                //secondMax = array[-i];
            }
        }
        return maxValue;
    }

    // getting the miniumum value
    private static double getMinValue(double[] array) {
        double minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public int UserPaidID(){
        if(ItemStat().equals("UNSOLD"))
        {
            return 0;
        }else{
        for(Bit bit: itemBits){
            if (bit.getBit_amount() == getHighest())
            {
                return bit.GetUserID();
            }
          }
        }
        return 0;
    }

    public String ItemStat(){
        sold =  false;
        this.status = "";
        if(itemBits.size() < 1)
        {
            sold = true;
            return  status = "UNSOLD";
        }else if (getHighest() < reserve_price){
            return  status = "UNSOLD";
        }else {
            return  status = "SOLD";
        }
    }

    public List<Bit> getItemBits(){

        return this.itemBits;
    }
    public void setAllbitsArr(){
        allbits = new double[itemBits.size()]; // Adds up zeros but there not valid
        for (Bit bit : itemBits) {
            allbits[i] = bit.getBit_amount();
            i ++;
        }

    }

    public int BitsLenght()
    {
        return   itemBits.size();
    }

}