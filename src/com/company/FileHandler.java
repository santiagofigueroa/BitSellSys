package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileHandler {

    private static Auction events ;
    private static List<Auction> startAuction; // Will get the list of Items and bits.
    private static String context =  "";
    private static int closeTime;

    public FileHandler (){
        // Please chang directory of input file
        // TODO: Change the input file directory.
        String txtFile =  "C:\\Users\\santi\\IdeaProjects\\TMAuction\\src\\input.txt" ;
        int i = 0;
        try {
             File file =  new File(txtFile);
             Scanner scan  = new  Scanner(file);
             startAuction = new ArrayList<>();
            //
             while(scan.hasNext()){
            // Context will run until last line.
                 context = context.concat(scan.nextLine());
                 String itemProperties =  context.replace("|"," ");
                 String [] properties = itemProperties.split(" ");
                    //  Handles the items to bit.
                     if (itemProperties.contains("SELL")) {
                         if (startAuction.isEmpty()) {
                            // Starting a new Auctions
                             events = new Auction(Integer.parseInt(properties[0]),
                                     Integer.parseInt(properties[1])
                                     , properties[2]
                                     , properties[3]);
                             //events.se(Double.parseDouble(properties[4]));
                             events.setTimestamp(Integer.parseInt(properties[5]));
                             // Once is not empty we do not create another object
                             // Set Close time for Auction
                             this.closeTime =Integer.parseInt(properties[5]);
                             startAuction.add(events);
                         }
                         // Checks timer.
                         if(events.getTimestamp() != Integer.parseInt(properties[0])) {
                             System.out.println("Add Item to bit" + properties.toString());
                             //
                         Item item = new Item(Integer.parseInt(properties[0]),
                                 Integer.parseInt(properties[1])
                                 , properties[2]
                                 , properties[3]);
                         item.setPrice(Double.parseDouble(properties[4]));
                         item.setCloseTime(Integer.parseInt(properties[5]));
                         System.out.println(item);
                         events.AddItem(item);

                         }
                         //  If a bit is place makes sure that at least a sale item has being added.
                     } else if (itemProperties.contains("BID") && events != null) {
                         if (events.getTimestamp() != Integer.parseInt(properties[0])) {
                             Bit bit = new Bit(Integer.parseInt(properties[0]),
                                     Integer.parseInt(properties[1])
                                     , properties[2]
                                     , properties[3]);
                             bit.PlaceBit(Double.parseDouble(properties[4]));
                             System.out.println("Add Bit for item :" + properties[3].toString());
                             boolean checkItemExits = events.getItemByName(properties[3]);
                             if (checkItemExits) {
                                 System.out.println(bit);
                                 events.PlaceBit(bit);

                             }

                         }
                     } else {
                         // Once it reaches the time stamp limit will print all items status
                         if( events.getTimestamp() == Integer.parseInt(properties[0])){
                             // Print  output

                             // Sort all of the  items to  it's bits.
                             ArrayList<Item>  itemsL  = events.getLItems();
                             ArrayList<Output> itemsOutPuts = new ArrayList<Output>();
                             String [] outputS ;
                             String [] line;
                             int e = 0;
                             // Outputs for testing
                             outputS = new String[25];
                             // TODO: Change the output file directory

                             BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\santi\\IdeaProjects\\TMAuction\\src\\output.txt" ));
                             for (Item itemO : itemsL){
                                 itemO.setAllbitsArr();
                                 outputS[e] = itemO.getCloseTime()+"|"+
                                         itemO.getItemName() +"|" +
                                         itemO.UserPaidID()+"|" +
                                         itemO.ItemStat()+"|" +
                                         itemO.getPaidPrice()+"|" +
                                         itemO.BitsLenght()+"|" +
                                         itemO.getHighest()+"|" +
                                         itemO.getLowest()+"| ";
                                 line = outputS[e].split(" ");
                                 String out = line[0];
                                 bw.write(out);
                                 bw.newLine();
                                 e++;
                             }
                             bw.close();
                         }
                     }
                 context = "";
                 i++;// IN case I need the number of inputs
             }
            System.out.println();
            } catch (IOException ex){
               System.out.println("File not found: " + ex.toString());
               ex.printStackTrace();
            }
        }

        private static int getCloseTime(){
            return events.getTimestamp();
        }


    }


