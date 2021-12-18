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

  public static String fillwater(String a) {
    int p1, p2;
    char[] c = a.toCharArray();

    p1 = p2 = -1;
    for (int i = 0; i < c.length; i++) {
      if (c[i] == 'X') {
        if (p1 == -1) {
          p1 = i;
          continue;
        } else if (p2 == -1) {
          p2 = i;
        }
      }
      if (p1 != -1 && p2 != -1) {
        for (int j = p1 + 1; j < p2; j++)
          c[j] = 'o';
        p1 = p2;
        p2 = -1;
      }
    }
    return (new String(c));
  }

  public static void main(String[] args) {
    int[] h = new int[] {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 5, 6, 7, 8, 9, 8, 7, 6, 7, 8, 9};
    int mh = max(h);
    String[] g = new String[mh];

    for(int i = 1; i <= mh; i++) {
      g[mh - i] = "";
      for (int j = 0; j < h.length; j++) {
        if (i <= h[j])
          g[mh - i] += "X";
	else
          g[mh - i] += " ";
      }
    }

    for (int i = 0; i < mh; i++)
      System.out.println(fillwater(g[i]));
  }
}
