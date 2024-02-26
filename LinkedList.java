import java.util.Random;

class LinkedList {
    private Cell first;

    public static void main(String[] args) {
        Cell[] array = new Cell[6000];

        int[] k = unsorted(100);

        LinkedList list = new LinkedList(6000, array);

        long total = 0;
        
        for(int i = 0; i<k.length; i++){
        Cell cell = array[k[i]];
        long t0 = System.nanoTime();
        list.unlink(cell);
        list.insert(cell);
        long t1 = System.nanoTime();
        total += (t1-t0);

        }
    
        System.out.println(total/100+"ns");
         
        

        /*
         * int[] ar1 = unsorted(10000);
         * 
         * long total1 = 0;
         * long t2 = System.nanoTime();
         * LinkedList b = new LinkedList(100000);
         * long t3 = System.nanoTime();
         * total1 = (t3 - t2);
         * System.out.println(total1);
         */
        /*
         * b.add(6);
         * b.add(8);
         * b.add(7);
         * 
         * list.add(3);
         * list.add(4);
         * list.add(5);
         * 
         * if (list.find(4)) {
         * System.out.println("finns");
         * }
         * 
         * int längd = list.length();
         * System.out.println(längd + "/////");
         * 
         * //list.remove(5);
         * list.show();
         * 
         * System.out.println("///////////");
         */

        /*
         * long total = 0;
         * long t0 = System.nanoTime();
         * arrayap(ar1,ar2);
         * // list.append(b);
         * long t1 = System.nanoTime();
         * total = (t1 - t0);
         * System.out.println(total);
         */
        // list.show();
    }
     
    void insert(Cell tres){
    tres.next = first;
    first = tres;


    }


    void unlink(Cell un) {
        Cell current = first;
        if (current == null) {
            return; // List is empty, nothing to remove
        }
        if (current == un) {
            first = first.next;
        }
        while (current.next != null) {
            if (current.next == un) {
                current.next = current.next.next;
                break;
            }
            current = current.next;

        }

    }

    public class Cell {
        int Value;
        Cell next;

        Cell(int val, Cell tl) {
            Value = val;
            next = tl;
        }
    }

    public Cell add(int item) {
        Cell Current = first;
        if (Current == null) {
            Cell cell = new Cell(item, null);
            first = cell;
            return cell;
        }
        while (true) {
            if (Current.next == null) {
                Cell cell = new Cell(item, null);
                Current.next = cell;
                return cell;
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

    void remove(int item) {
        Cell current = first;
        if (current == null) {
            return; // List is empty, nothing to remove
        }
        if (current.Value == item) {
            first = first.next;
        }
        while (current.next != null) {
            if (current.next.Value == item) {
                current.next = current.next.next;
                break;
            }
            current = current.next;

        }

    }

    public void show() {
        Cell current = first;

        while (current != null) {
            System.out.println(current.Value);
            current = current.next;
        }
    }

    public void append(LinkedList b) {
        Cell nxt = this.first;

        while (nxt.next != null) {

            nxt = nxt.next;
        }
        nxt.next = b.first;
    }
 
        public LinkedList(int n, Cell[] uno) {
        
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
            uno[i] = last;
        }
        first = last;
       
        
    }
/* */
    public static int[] arrayap(int[] ett, int[] två) {
        int[] app = new int[ett.length + två.length];
        for (int i = 0; i < ett.length; i++) {
            app[i] = ett[i];
        }
        int k = 0;
        for (int j = ett.length; j < app.length; j++) {
            app[j] = två[k];
            k++;
        }
        return app;
    }

    public static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            duplicate = false;

            nxt = rnd.nextInt(n * 60) ;
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
