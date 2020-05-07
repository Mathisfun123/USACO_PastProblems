
import java.util.*;

public class Kattis {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n= 50;

		while(sc.hasNextLine() && n!=0) {
			n = Integer.parseInt(sc.nextLine());
			if(n!=0) {
				Boolean[] bits = new Boolean[32];
				for (int i = 0; i < n; i++) {
					String[] ln = sc.nextLine().split(" ");
					if (ln[0].equals("SET")) {
						bits[Integer.parseInt(ln[1])] = Boolean.TRUE;
					} else if (ln[0].equals("CLEAR")) {
						bits[Integer.parseInt(ln[1])] = Boolean.FALSE;
					} else if ((bits[Integer.parseInt(ln[1])]!=null || bits[Integer.parseInt(ln[2])] != null )&& ln[0].equals("OR")) {
						if(bits[Integer.parseInt(ln[1])] !=null) {
							if(bits[Integer.parseInt(ln[2])]!=null) {
								bits[Integer.parseInt(ln[1])] = bits[Integer.parseInt(ln[1])] || bits[Integer.parseInt(ln[2])];
							}
						}else{
							bits[Integer.parseInt(ln[1])] = bits[Integer.parseInt(ln[2])];
						}
					} else if (bits[Integer.parseInt(ln[1])] != null && ln[0].equals("AND")) {
						if (bits[Integer.parseInt(ln[2])] != null) {
							bits[Integer.parseInt(ln[1])] = bits[Integer.parseInt(ln[1])] && bits[Integer.parseInt(ln[2])];
						} else {
							bits[Integer.parseInt(ln[1])] = null;
						}
					}
				}
				StringBuilder s = new StringBuilder();
				for (int i = 31; i >= 0; i--) {
					if (bits[i] == null) {
						s.append("?");
					} else if (bits[i] == Boolean.FALSE) {
						s.append("0");
					} else {
						s.append("1");
					}
				}
				System.out.println(s.toString());
			}

		}

	}
}