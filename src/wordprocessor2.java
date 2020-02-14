
import java.lang.*;
import java.io.*;
import java.util.Scanner;

				class wordbob
				{
					public static void main (String[] args) throws java.lang.Exception
					{
						Scanner sc = new Scanner(new File("word.in"));
						//PrintWriter out = new PrintWriter(new File("word.out"));
						int n = sc.nextInt();
						int k = sc.nextInt();
						String bob[] = new String[n];
						sc.nextLine();
						for(int i = 0; i< n; i++){
							bob[i]= sc.next();
						}

						int x= 0;
						int i= 0;
						int y = 0;
						while(i<n){
							if(i==n-1){
								System.out.print(bob[i]);
								i++;
							}else {
								while ((bob[i].length() + x) <= k) {
									if(x==0){
										System.out.print(bob[i]);
										x += bob[i].length();
										i++;
									}
									else{
										System.out.print(" " + bob[i]);
									}

								}
								x = 0;
								System.out.println();
							}
						}
						//out.close();

					}
				}

