import java.io.*;

class Mountain {
  public static int max(int[] a) {
    int m = a[0];

    for (int i = 1; i < a.length; i++) {
      if (m < a[i])
        m = a[i];
    }

    return m;
  }

  public static String fillwater(char[] c) {
    int p1, p2;

    p1 = p2 = -1;
    for (int i = 0; i < c.length; i++) {
      if ((i % 2) == 1)
        continue;
      else {
        if (c[i] == 'X') {
          if (p1 == -1) {
            p1 = i;
            continue;
          } else if (p2 == -1) {
            p2 = i;
          }
        }
        if (p1 != -1 && p2 != -1) {
          for (int j = p1 + 1; j < p2; j++) {
            if ((j % 2) == 1)
              continue;
            c[j] = 'o';
          }
          p1 = p2;
          p2 = -1;
        }
      }
    }
    return (new String(c));
  }

  public static void main(String[] args) {
    int[] h = new int[] {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 5, 6, 7, 8, 9, 8, 7, 6, 7, 8, 9};
    int mh = max(h);
    char[] g = new char[2 * h.length - 1];

    for (int i = 0; i < mh; i++) {
      for (int j = 0; j < g.length; j++) {
        if ((j % 2) == 1)
          g[j] = ' ';
        else {
          if (mh - i <= h[j/2])
            g[j] = 'X';
          else
            g[j] = ' ';
        }
      }
      System.out.println(fillwater(g));
    }
  }
}
