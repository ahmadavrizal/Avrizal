package penjadwalan;

import java.util.Scanner;

public class Penjadwalan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Proses p = new Proses();
        
        do{
            System.out.print("\n====================================\n"
                             +"||       ALGORITMA PENJADWALAN     ||\n"
                             +"=====================================\n"
                             +"|| 1. Penjadwalan priority         ||\n"
                             +"|| 2. Roud Robin                   ||\n"
                             +"|| 3. Exit                         ||\n");
            System.out.print("choose : ");
            int pilih = input.nextInt();
                switch (pilih) {
                    case 1: {
                        System.out.println(
                                "===========PRIORITY==========");
                        p.priority();
                        System.out.println("");
                        break;
                    }
                    case 2: {
                        System.out.println(
                                 "========ROUND ROBIN==========");
                        p.roundRobin();
                        System.out.println("");
                        break;
                    }
                    case 3: {
                        System.out.println("==TERIMA KASIH==");
                        System.exit(0);
                    }
                    default: {
                        System.out.println(
                                "===========\n"
                               +"||Invalid||\n"
                               +"=============");
                        break;
                    }
                }
            } while (true);
        }
    
}
