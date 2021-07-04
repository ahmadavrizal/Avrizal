package penjadwalan;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import static penjadwalan.Node.Temp;

class Node{
    static Node Temp;
    public int P;
    public int burstTime;
    public int arrivalTime;
    public int priority;
    public int endTime;
    
    Node(int P, int arrivalTime, int burstTime, int priority, int endTime){
        this.P = P;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.endTime = endTime;
    }
}

class FindPriority implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return a.priority <b.priority ? -1 : a.priority == b.priority ? 0:1;
    }
}


public class Proses{
    LinkedList<Node> iob = new LinkedList<>();
    LinkedList<Node> show = new LinkedList<>();
    LinkedList<Node> antrian = new LinkedList<>();
    int n;
    int quantum;
    
    void priority(){
        insertPr();
        
        int countProses=0;
        Collections.sort(iob, new FindPriority());
        while(!iob.isEmpty()){
            Node Temp = iob.getFirst();
            Temp.endTime = countProses;
            show.add(Temp);
            iob.removeFirst();
            countProses+=Temp.burstTime;
        }
        
        print();
        show.clear();
    }
    
    void roundRobin(){
        insert();
        insertQuantum();
        
        int countProses=0;
        while(!iob.isEmpty() || antrian.isEmpty()){
            while(!iob.isEmpty()){
                if(iob.getFirst().arrivalTime<=countProses){
                    antrian.add(iob.getFirst());
                    iob.removeFirst();
                }   else {
                        break;
                }
            }
            
            if(antrian.isEmpty()){
                Node.Temp = antrian.getFirst();
                antrian.removeFirst();
                    if(Temp.burstTime > quantum){
                        if(show.isEmpty() || show.getLast().P != Temp.P){
                            show.add(new Node(Temp.P,Temp.arrivalTime,quantum,0,countProses));
                        } else{
                            show.add(new Node(Temp.P,0,quantum,0,0));
                        }
                        Temp.burstTime = quantum;
                        Temp.arrivalTime = countProses+quantum;
                        antrian.add(Temp);
                        countProses+=quantum;
                    } else {
                        if(show.isEmpty() || show.getLast().P != Temp.P){
                            show.add(new Node(Temp.P,Temp.arrivalTime,quantum,0,countProses));
                        } else {
                            show.add(new Node(Temp.P,0,quantum,0,0));
                        }
                        countProses+=Temp.burstTime;
                    }
            } else {
                countProses++;
            }
        }
        
        print();
        iob.clear();
        show.clear();
    }
    
    void insertPr(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jumlah proses");
        n = input.nextInt();
        System.out.println("Masukan Burst Time dan Priority secara berurutan : ");
        for(int i = 0; i < n; i++){
            System.out.print("P"+(i+1)+" = ");
            iob.add(new Node(i+1,0,input.nextInt(),input.nextInt(),0));
        }
        System.out.println("");
    }
    
    void insert(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jumalah Proses = ");
        n = input.nextInt();
        System.out.println("Masukan Arrival Time dan Burst time secara berurutan : ");
        for(int i = 0; i < n; i++){
            System.out.print("P"+(i+1)+" = ");
            iob.add(new Node(i+1,0,input.nextInt(),input.nextInt(),0));
        }
        System.out.println("");
    }
    
    void insertQuantum(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukan jumlah quantum = ");
        quantum = input.nextInt();
        System.out.println("");
    }
    
    void print(){
        show.stream().forEach((shows) -> {
            for(int i = 0; i < 2*shows.burstTime;i++){
                if(i==shows.burstTime)
                    System.out.print("P"+shows.P);
                else
                    System.out.print(" ");
            }
        });
        
        System.out.println("");
        
        int totLamaProses = 0;
        System.out.print("|");
        for(Node shows : show) {
            int lamaProses = shows.endTime - shows.arrivalTime;
            totLamaProses+=lamaProses;
          for(int i = 0; i<shows.burstTime;i++){
              System.out.print("--");
          }
          System.out.print("|");
        }
        System.out.print("");
        
        int count = 0;
        for (Node shows : show){
            System.out.printf("%-2d",count);
            for(int i = 0; i<2*shows.burstTime-1;i++){
                System.out.print(" ");
            }
            count+=shows.burstTime;
        } System.out.printf("%-2d",count);
        
        System.out.println("\n");
        System.out.println("Average Waiting Time : "+(float)totLamaProses/n);
        System.out.println("");
    }
}