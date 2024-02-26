import java.util.Random;


   

class stacklist {
    private Cell first;

    public static void main(String[] args) {
        int ett = 0;
        int två = 0;
        int tre = 0;
        int fyra = 0;
        stacklist list = new stacklist();
        stacklist b = new stacklist();
        list.push(9);
        list.push(7);
        list.show();
        System.out.println("///////");
        ett = list.pop();
        list.show();
        System.out.println("///////");
        list.push(6);
        list.push(1);
        list.show();
        System.out.println("///////");
       två = list.pop();
        tre = list.pop();
        fyra = list.pop();


        
        
        System.out.println("////////");
        System.out.println(ett+","+två+","+tre+","+fyra);
    }

    private class Cell {
        int Value;
        Cell next;

        Cell(int val, Cell tl) {
            Value = val;
            next = tl;
        }
    }

    public void push(int item) {
        Cell Current = first;
        if (Current == null) {
            Cell cell = new Cell(item, null);
            first = cell;
            return;
        }
        while (true) {
            if (Current.next == null) {
                Cell cell = new Cell(item, null);
                Current.next = cell;
                break;
            }
            Current = Current.next;
        }

    }

    int length() {
        int i = 0;
        Cell current = first;
        while (current != null) {
            current = current.next;
            i++;
        }
        // System.out.println(i);
        return i;
    }

    boolean find(int item) {
        boolean trueorfalse = false;
        Cell current = first;
        while (current != null) {

            if (current.Value == item) {
                trueorfalse = true;
                break;
            }
            current = current.next;
        }

        return trueorfalse;
    }

    int pop() {
        int poppad = 0;
        Cell current = first;
        if (current == null) {
            return poppad; // List is empty, nothing to remove
        }
        if (current.next==null) {
            poppad = first.Value;
            first = first.next;
            return poppad;
        }
        while (true) {
            if (current.next.next==null) {
                poppad = current.next.Value;
                current.next=current.next.next;
                return poppad;
            }
            current = current.next;

        }
        
    }

    public void show() {
        Cell current = first;
        if(current == null){
            System.out.println("Stack is empty");
            return;
        }
        while (current != null) {
            System.out.println(current.Value);
            current = current.next;
        }
    }

    public void append(stacklist b) {
        Cell nxt = this.first;

        while (nxt.next != null) {

            nxt = nxt.next;
        }
        nxt.next = b.first;
    }

    

    public static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            duplicate = false;

            nxt = rnd.nextInt(n*5) + 1;
            for (int j = 0; j < i; j++) {
                if (nxt == array[j]) {
                    i--;
                    duplicate = true;
                }
            }
            if (duplicate == false) {
                array[i] = nxt;
            }
        }
        return array;
    }
}


