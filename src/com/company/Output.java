package com.company;

public class Output {
    //  Fields that concur with the output file.
    private int close_time;
    private String item_name;
    private int user_id;
    private String status; // SOLD or UNSOLD
    private double price_paid;
    private int total_bits;
    private double highest_bit;
    private double lowest_bit;

    public Output(int close_time, String item_name, int user_id, String status,double price_paid,int total_bits, double highest_bit,double lowest_bit){
        this.close_time = close_time;
        this.item_name = item_name;
        this.user_id =  user_id;
        this.status = status; // SOLD or Unsold
        this.price_paid = price_paid;
        this.total_bits = total_bits;
        this.highest_bit =  highest_bit;
        this.lowest_bit = lowest_bit;
    }

}
