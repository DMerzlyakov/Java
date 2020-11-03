package com.task;

import javax.swing.*;
import java.io.*;;
import java.util.Scanner;

public class Operations {
    private Employee[] e1;
    private int len;
    private Scanner scn;
    private String filename;

    public String getName( int i) {
        return e1[i].getName();
    }

    public double getSalary( int i) {
        return e1[i].getSalary();
    }
    public String getType( int i) {
        return e1[i].getType();
    }

    public Operations(String fn) {
        this.filename = fn;
        this.len = GetRowQtyInFile();
        e1 = new Employee[len] ;
        openfile();
        readfile();
    }
    public int GetRowQtyInFile() {
        int lineNumber = 0;
        try{
            File myFile =new File(filename);
            FileReader fileReader = new FileReader(myFile);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            while (lineNumberReader.readLine() != null){
                lineNumber++;
            }
            lineNumberReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return lineNumber;
    }
    public void openfile() {
        try {
            scn = new Scanner (new File(filename));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Файл не найден");}
    }
    public void readfile() {
        String n;
        String type;
        String s;
        String sal;
        for (int row=0;row<len-1;row++ ) {
            n=scn.next();
            type=scn.next();
            s=scn.next();
            sal=scn.next();
            if (type.equals("t")) {e1[row] = new Timed(  Integer.parseInt(n) , s,  Float.parseFloat(sal));}
            if (type.equals("f")) {e1[row] = new FixedPriceEmployee(  Integer.parseInt(n) , s,  Float.parseFloat(sal));}
        }
    }
    public void change_elements(int i, int j) {
        Employee e10;

        e10=e1[i];
        e1[i]=e1[j];
        e1[j]=e10;
    }
    public void view_all_elements() {
        for (int i = 0; i <= len-1; i++) {
            if (i<=len-2) {
                System.out.print(i) ;System.out.print(e1[i].getName()+" "+e1[i].getType()+" "+e1[i].getSalary());
            }
            System.out.println();
        }
    }
    public void sort_elements() {
        int k=len-2;
        for (int j = 0; j <= len-2; j++) {
            for ( int i = 0; i <= k; i++) {
                if (i+1<=len-2) {
                    if ((e1[i].getSalary()==e1[i+1].getSalary()) && e1[i].getName().compareTo(e1[i+1].getName())   >0 )
                    {
                        change_elements(i, i+1);
                    }
                }
            } k--;
        }
    }
}