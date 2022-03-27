package com.company;

import java.util.Scanner;

interface IPolynomialSolver {

    void setPolynomial(char poly, int[][] terms);
    String print(char poly);
   // void clearPolynomial(char poly);
   // float evaluatePolynomial(char poly, float value);
   // int[][] add(char poly1, char poly2);
   // int[][] subtract(char poly1, char poly2);
   // int[][] multiply(char poly1, char poly2);

}
interface ILinkedList {

    public void add(int index, Object element);
    public void add(Object element);
    public Object get(int index);
    public void set(int index, Object element);
    public void clear();
    public boolean isEmpty();
    public void remove(int index);
    public int size();
    public void sublist(int fromIndex, int toIndex);
    public boolean contains(Object o);
}


/* The borders of the Copied Doubly Linked List Implementation
*/
class DoublyLinkedList implements ILinkedList{

public class node {
    public Object elm ;
    node next ;
    node prev ;

}
    node head=null;
    node tail=null;
    public static int size=0;
    node pointer = head;
    public void add(Object element){ //*same as single*//
        if(size==0){
            node no =new node();
            no.elm=element;
            no.next=null;
            no.prev=null;
            head=no;
            tail=no;
            size++;
        }
        else{
            node f=new node();
            f.elm=element;
            tail.next=f;
            f.prev=tail;
            tail=f;
            tail.next=null;
            size++;
        }
        pointer = head;
    }
    public void print(){ //*same as single*//
        node p=head;
        System.out.print("[");
        for(int i=0;i<size;i++){

            System.out.print(p.elm);
            p=p.next;
            if(i != size - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public void add(int index, Object element)
    {
        node added = new node();
        added.elm = element;
        if(size == 0)
        {
            added.next = null;
            added.prev = null;
            head = added;
            tail = added;
        }
        else {
            node counter;
            if(index <= size/2) {
                counter = head;
                for (int i = 0; i < index - 1; i++)
                    counter = counter.next; // stopped right before the required index
            }
            else
            {
                counter = tail;
                // stopped right before the req index to make it similar the manupilation uphere
                for(int i = 0; i < size - index; i++)
                    counter = counter.prev;
            }

            if(index!=0) {
                added.next = counter.next;
                added.prev = counter;
                counter.next.prev = added;
                counter.next = added;
            }
            else
            {
                added.next = head;
                head = added;
                head.prev = null;
            }
        }
        size++;
    }

    public Object get(int index){
        node count = head;
        if(index<=size){
            for(int j=0;j<size;j++){
                if(j==index){
                    return count.elm;
                }
                count=count.next;
            }
        }
        return ("null");
    }

    public void set(int index, Object element){
        node counter;
        if(index <= size/2)
        {
            counter = head;
            for (int i = 0; i < index; i++)
                counter = counter.next;
            counter.elm = element;
        }
        else
        {
            counter = tail;
            for (int i = 0; i < size - index - 1; i++)
                counter = counter.prev;
            counter.elm = element;
        }
        return ;
    }

    public void clear(){  //*same as single*//
        node x=null;
        head=x;
        tail=x;
        size=0;
        return ;}

    public boolean isEmpty(){if(size==0)return true; //*same as single*//
    else return false;
    }

    public void remove(int index) {

        if(index != 0){
            node counter;

            if (index <= size / 2) {
                counter = head;
                for (int i = 0; i < index - 1; i++)
                    counter = counter.next; // To stop just after the removed node
                // Erga3 mrten w 5alli elly 2odamak elle m3ana
                counter.next = counter.next.next;


            } else {
                counter = tail;
                for (int i = 0; i < size - index ; i++)
                    counter = counter.prev; // To stop just before the removed node
                counter.next = counter.next.next; // It could be done with prev,
                // for clarity we chosed same approach
                // of single linked list
            }
        }
        else
            head = head.next;
        size--;
        return;
    }

    public int size(){return size;} //*same as single*//

    public void sublist(int fromIndex, int toIndex){
        node counter = head;
        System.out.print("[");
        for(int i = 0; i < size; i++)
        {
            if(i >= fromIndex && i <= toIndex)
            {
                System.out.print(counter.elm);
                if(i != toIndex)
                    System.out.print(", ");
            }
            counter = counter.next;
        }
        System.out.print("]");

        return ;
    }
    public boolean contains(Object o){
        if(head != null) {
            node contain = head;
            for (int j = 0; j < size; j++) {
                if (contain.elm == o) {
                    return true;
                }
                contain = contain.next;
            }
        }
        return false;
    }
}











public class PolynomialSolver implements IPolynomialSolver {
    static PolynomialSolver plslv = new PolynomialSolver();
    static int row = 0;
    static int[] lenghts = new int[3];
    DoublyLinkedList dbly = new DoublyLinkedList();
    int[][] terms = new int[10][50];
     public void setPolynomial(char poly, int[][] terms)
     {
        String test = new String();
        String aux = String.valueOf(plslv.dbly.get(2));
        String[] tank = aux.split(",");
        lenghts[0] = tank.length;

            for (int i = 0; i < tank.length; i++)
                terms[row][i] = (Integer.parseInt(tank[i]));
            row++;
            for (int i = 0; i < lenghts[0]; i++) {
                terms[row][i] = tank.length - i - 1;
            }
            row++;
            for (int i = 0; i < 3; i++) {
                plslv.dbly.remove(0);
            }
    }
    public String print(char poly)
    {
         StringBuilder printer = new StringBuilder();
         int row;
        if(poly == 'A') row = 0;else if(poly == 'B') row = 1;else row = 2;
        plslv.dbly.remove(0);
        plslv.dbly.remove(0);
        plslv.dbly.remove(0);
        for(int i=0;i<lenghts[row];i++){
            if(terms[2*row+1][i]!=0) {
                if(terms[2*row][i]<0) {
                    printer.append("-");
                    printer.append(terms[2 * row][i]);
                }
                else
                    printer.append(terms[2 * row][i]);
                printer.append("x^");
                if(terms[2*row+1][i]<0) {
                    printer.append("-");
                    printer.append(terms[2*row+1][i]);
                }
                else
                    printer.append(terms[2*row+1][i]);
            }
            else
                printer.append(terms[2*row][i]);
        }

        return printer.toString();
    }










    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char name = ' ';

        String scan = new String();
        try {
            int x;
            for (int i = -1; i < plslv.dbly.size; i++) {
                scan = in.nextLine().replaceAll("\\[|\\]", "");
                plslv.dbly.add(scan);
                if(scan.equals("s"))
                    x=in.nextInt();
            }
        } catch (Exception e) {
            while (plslv.dbly.size != 0) {
                String.valueOf(plslv.dbly.get(0));
                name = String.valueOf(plslv.dbly.get(1)).charAt(0);
                if (plslv.dbly.get(0).equals("set")) {
                    plslv.setPolynomial(name, plslv.terms);
                }
                else if (plslv.dbly.get(0).equals("print")) {
                    System.out.print(plslv.print(name));
                }
            }
        }
    }
}