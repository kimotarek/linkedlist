import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java .util.Scanner;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(int element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public void sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}








public class SingleLinkedList implements ILinkedList {
    public class node {
    public int elm ;
    node next ;
        
    }
    node head=null;
    node tail=null;
   static int size=0;
    
    public void add(int element){
        
       
        
        if(size==0){
            node no =new node();
            no.elm=element;
            no.next=null;
            head=no;
            tail=no;
            size++;
            
        }
        
        else{
            node f=new node();
            f.elm=element;
            tail.next=f;
            tail=f;
            size++;
            
        }
              

    }
    public void print(){
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
    
    
    
    
public void add(int index, Object element){return ;}
public Object get(int index){return 5;}
public void set(int index, Object element){return ;}
public void clear(){return ;}
public boolean isEmpty(){return true;}
public void remove(int index){return ;}
public int size(){return 5;}
public void sublist(int fromIndex, int toIndex){return ;}
public boolean contains(Object o){return true;}


    
    
    
    
    
    
    
    
   
      
	/* Implement your linked list class here*/
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        String a=in.nextLine().replaceAll("\\[|\\]","");
        String[] arr =a.split(", ");
        String op=in.nextLine();
        String d ="add";

        SingleLinkedList p=new SingleLinkedList();
        
        if(arr.length == 1 && arr[0].isEmpty()){}
        else{
        for(int i=0;i<arr.length;i++){
            p.add(Integer.parseInt(arr[i]));
        }}
        
        
   
if(op.equals("add")){
            int element=in.nextInt();
             p.add(element);
             p.print();
            
            
            
        }
        
else if (op.equals("addToIndex") ){
            int ind=in.nextInt();
            int element=in.nextInt();
        }
else if (op.equals("get")){
            int ind=in.nextInt();

            
        }
else if (op.equals("set")){
            int ind=in.nextInt();
            int element=in.nextInt();
            
        }
else if (op.equals("clear")){
            
            
        }
 else if (op.equals("isEmpty")){
            
            
        }
else if (op.equals("remove")){
             int ind=in.nextInt();

            
        }
else if (op.equals("sublist")){
            int start_ind=in.nextInt();
            int end_ind=in.nextInt();

            
        }
else if (op.equals("contains")){
            
             int element=in.nextInt();

        }
        
                    

        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    }
}