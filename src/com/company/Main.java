# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Main.java                                          :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: cmbuyamb <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2020/06/22 12:16:39 by cmbuyamb          #+#    #+#              #
#    Updated: 2020/06/22 12:16:58 by cmbuyamb         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #


package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                File file = new File(args[0]);
                List<String> names = new ArrayList<>();
                List<String> bets = new ArrayList<>();
                Scanner input = new Scanner(System.in);
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String name;
                long time = 30000;
                while ((name = reader.readLine()) != null){
                    names.add(name.trim());
                }
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        showResults(bets, getNumber());
                    }
                }, time, time);

                String bet;
                print("Place your bets: ");
                while ((bet = input.nextLine()) != "exit"){
                    if (bet.split(" ").length == 3 && names.contains(bet.split(" ")[0])) {
                        bets.add(bet);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Owww, it looks like you forgot the file");
        }
    }

    private static void print(String str){
        System.out.println(str);
    }

    private static void showResults(List<String> bets, int num){
        String name, betStr;
        int betNum;
        double betAmnt;

        print("\nNumber: " + num);
        System.out.format("%10s%10s%10s%10s\n", "Player", "Bet", "Outcome", "Winnings");
        print("----");
        for (int c=0; c<bets.size(); c++){
            String betsArr[] = bets.get(c).split(" ");
            name = betsArr[0];
            betStr = betsArr[1];
            if (betsArr[1].equalsIgnoreCase("even") || betsArr[1].equalsIgnoreCase("odd")){
                betStr = betsArr[1];
                betNum = -1;
            }
            else{
                betStr = null;
                betNum = Integer.valueOf(betsArr[1]);
            }
            betAmnt = Double.valueOf(betsArr[2]);
            if (betStr == null){
                if (betNum == num){
                    System.out.format("%10s%10d%10s%10s\n", name, betNum, "Win", String.valueOf(36.0*betAmnt));
                }else{
                    System.out.format("%10s%10d%10s%10s\n", name, betNum, "Lost", "0.0");
                }
            }
            else{
                if (betStr.equalsIgnoreCase("even") && num%2 == 0){
                    System.out.format("%10s%10s%10s%10s\n", name, betStr, "Win", String.valueOf(2.0*betAmnt));
                } else if (betStr.equalsIgnoreCase("odd") && num%2 != 0){
                    System.out.format("%10s%10s%10s%10s\n", name, betStr, "Win", String.valueOf(2.0*betAmnt));
                }
                else{
                    System.out.format("%10s%10s%10s%10s\n", name, betStr, "Lost", "0.0");
                }
            }
        }
        bets.clear();
        print("\nPlace your bets: ");
    }

    private static int getNumber(){
        Random random = new Random();
        return random.nextInt(36);
    }
}
