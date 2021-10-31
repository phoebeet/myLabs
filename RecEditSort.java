// Read initial records from data_to_parse.txt
// Sort the contact by name
// Create, delete, or edit a Contact, or retrieve the Contact by name


import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*;


public class RecEditSort {
    static Scanner ui = new Scanner(System.in);

    // Swapping 2 elements
    private static void swap(String[] a, int i, int j)
    {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Java Program for BogoSort
    private static class BogoSort {
        // Sorts array a[0..n-1] using Bogo sort
        void bogoSort(String[] key, String[] f1, String[] f2)
        {
            // if array is not sorted then shuffle the
            // array again
            while (isSorted(key) == false)
                shuffle(key, f1, f2);
        }

        // To generate permutation of the array
        void shuffle(String[] a, String[] b, String[] c)
        {
            // Math.random() returns a double positive
            // value, greater than or equal to 0.0 and
            // less than 1.0.
            for (int i = 0; i < a.length; i++) {
		int j = (int)(Math.random() * i);
                swap(a, i, j);
		swap(b, i, j);
		swap(c, i, j);
            }
        }

        // To check if array is sorted or not
        boolean isSorted(String[] a)
        {
            for (int i = 1; i < a.length; i++)
                if (a[i].compareTo(a[i - 1]) < 0)
                    return false;
            return true;
        }
    }

    // Java program for BubbleSort
    private static class BubbleSort {
        // Sorts array a[0..n-1] using Bogo sort
        void bubbleSort(String[] key, String[] f1, String[] f2)
        {
            for (int j = 0; j < key.length; j++) {
                for (int i = j + 1; i < key.length; i++) {
                    // comparing adjacent strings
                    if (key[i].compareTo(key[j]) < 0) {
			swap(key, i, j);
			swap(f1, i, j);
			swap(f2, i, j);
                    }
                }
            }
        }
    }
 
    // Java program for MergeSort
    private static class MergeSort
    {
        // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        void merge(String[] key, String[] a, String[] b, int l, int m, int r)
        {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
	    int i, j;

            /* Create temp arrays */
            String Lk[] = new String [n1];
	    String La[] = new String [n1];
	    String Lb[] = new String [n1];
            String Rk[] = new String [n2];
	    String Ra[] = new String [n2];
	    String Rb[] = new String [n2];

            /*Copy data to temp arrays*/
            for (i=0; i<n1; ++i) {
                Lk[i] = key[l + i];
                La[i] = a[l + i];
                Lb[i] = b[l + i];
            }
            for (j=0; j<n2; ++j) {
                Rk[j] = key[m + 1+ j];
                Ra[j] = a[m + 1+ j];
                Rb[j] = b[m + 1+ j];
            }

            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            i = 0;
            j = 0;

            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) {
                if (Lk[i].compareTo(Rk[j]) < 0) {
                    key[k] = Lk[i];
		    a[k] = La[i];
		    b[k] = Lb[i];
                    i++;
                } else {
                    key[k] = Rk[j];
		    a[k] = Ra[j];
		    b[k] = Rb[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                key[k] = Lk[i];
		a[k] = La[i];
                b[k] = Lb[i];	
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                key[k] = Rk[j];
                a[k] = Ra[j];
                b[k] = Rb[j];
                j++;
                k++;
            }
        }

        // Main function that sorts arr[l..r] using
        // mergeSort()
        void mergeSort(String[] key, String[] f1, String[] f2, int l, int r)
        {
            if (l < r) {
                // Find the middle point
                int m = (l+r)/2;

                // Sort first and second halves
                mergeSort(key, f1, f2, l, m);
                mergeSort(key, f1, f2, m+1, r);

                // Merge the sorted halves
                merge(key, f1, f2, l, m, r);
            }
        }
    }

    // Prints the array
    private static void printArrays(String[] names, String[] ages, String[] addrs)
    {
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i] + "\t" + ages[i] + "\t" + addrs[i]);
    }

    private static String[] append(String[] arr, String s)
    {
        if (arr == null) {
            String[] a = new String[1];
            a[0] = s;
            return a;
        } else {
            String[] a = new String[arr.length + 1];
            for (int i = 0; i < arr.length; i++)
                a[i] = arr[i];
            a[arr.length] = s;
            return a;
        }
    }

    private static String[] delete(String[] arr, int pos)
    {
        int i;
        String[] a = new String[arr.length - 1];

        for (i = 0; i < pos; i++)
            a[i] = arr[i];
        for (i = pos; i < arr.length -1; i++)
            a[i] = arr[i+1];
        return a;
    }

    private static int getAnInt(){
        int retval = 0;
        boolean done = false;
        String dummy;
        while (!done) {
            if(ui.hasNextInt()) {
                done = true;
                retval = ui.nextInt();
            } else {
                    System.out.println("Positive integer only, please re-enter a valid input:");
                    dummy = ui.next();
            }
        }
        return retval;
    }//getAnInt

    public static void main(String[] args)
    {
        int i;
	int inputnum = -1;
        String[] names = null;
	String[] ages = null;
	String[] addrs = null;
        Pattern textPattern = Pattern.compile("^(?<Name>[A-Za-z|-]+\\s[A-Za-z]+)\\s+(?<Age>\\d+)\\s+(?<Addr>(.*))");

        try {
            FileReader fin = new FileReader("data_to_parse.txt");
            Scanner src = new Scanner(fin);
            String activeLine;
            Matcher textMatcher;
	    src.nextLine();
            while (src.hasNext()) {
                activeLine = src.nextLine();
                System.out.println(activeLine);
                textMatcher = textPattern.matcher(activeLine);
                textMatcher.find();
                names = append(names, textMatcher.group("Name"));
                ages = append(ages, textMatcher.group("Age"));
                addrs = append(addrs, textMatcher.group("Addr"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        while (inputnum == -1) {
            System.out.println("0: Delete existing entry");
            System.out.println("1: Add new entry");
            System.out.println("2: Modify existing entry");
            System.out.println("Any other positive number: Skip editing");
            System.out.println("Choose one:");

            inputnum = getAnInt();

            switch (inputnum){
                case 0:
                    System.out.println("Name to be deleted:");
                    ui.nextLine();
                    String d = ui.nextLine();
                    for (i = 0; i < names.length; i++) {
                        if (d.compareTo(names[i]) == 0) {
                            names = delete(names, i);
                            ages = delete(ages, i);
                            addrs = delete(addrs, i);
			    break;
                        }
                    }
                    if (i == names.length)
                        System.out.println(d + "is not found");
                    inputnum = -1;
                    break;
                case 1:
                    System.out.println("Name to be added:");
                    ui.nextLine();
                    String n = ui.nextLine();
                    System.out.println("Age of " + n + ":");
                    String ag = ui.nextLine();
                    System.out.println("Address of " + n + ":");
                    String ad = ui.nextLine();
                    names = append(names, n);
                    ages = append(ages, ag);
                    addrs = append(addrs, ad);
                    inputnum = -1;
                    break;
                case 2:
                    System.out.println("Name entry to be modified:");
                    ui.nextLine();
                    String m = ui.nextLine();
                    for (i = 0; i < names.length; i++) {
                        if (m.compareTo(names[i]) == 0) {
                            System.out.println("New age of " + m + ":");
                            ages[i] = ui.nextLine();
                            System.out.println("New address of " + m + ":");
                            addrs[i] = ui.nextLine();
			    break;
                        }
                    }
                    inputnum = -1;
                    break;
                default:
                    System.out.println("Editing skipped...");
                    ui.nextLine();
                    break;
            }
        }

        inputnum = -1;
        while (inputnum == -1) {
            System.out.println("0: Bogo Sort");
            System.out.println("1: Bubble Sort");
            System.out.println("2: Merge Sort");
            System.out.println("Any other positive number: Skip sorting");
            System.out.println("Choose a sorting algorithm:");

            inputnum = getAnInt();

            switch (inputnum){
                case 0:
                    BogoSort bgs = new BogoSort();
                    bgs.bogoSort(names, ages, addrs);
                    break;
                case 1:
                    BubbleSort bbs = new BubbleSort();
                    bbs.bubbleSort(names, ages, addrs);
                    break;
                case 2:
                    MergeSort mgs = new MergeSort();
                    mgs.mergeSort(names, ages, addrs, 0, names.length - 1);
                    break;
                default:
                    System.out.println("Array is not sorted");
                    break;
            }
        }

        System.out.println("Sorted array: ");
        printArrays(names, ages, addrs);

        for (String s: args) {
            for (i = 0; i < names.length; i++) {
                if (s.compareTo(names[i]) == 0) {
                    System.out.println("Found: " + names[i] + "\t" + ages[i] + "\t" + addrs[i]);
                    break;
                }
            }
           if (i == names.length)
               System.out.println(s + " is not found");
        }

        try (PrintWriter writer = new PrintWriter("test.csv")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Name");
            sb.append(',');
            sb.append("Age");
            sb.append(',');
            sb.append("Address");
            sb.append('\n');

            for (i =0; i < names.length; i++) {
                sb.append(names[i]);
                sb.append(',');
                sb.append(ages[i]);
                sb.append(',');
                sb.append(addrs[i]);
                sb.append('\n');
            }

            writer.write(sb.toString());
            System.out.println("test.csv created!");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}

