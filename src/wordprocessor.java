import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class wordprocessor {
	public static void main(String[] args) throws FileNotFoundException {
		Pattern p = Pattern.compile("[rt]");
		String s = "greatest time";
		String arr[] = p.split(s);
		System.out.println(Arrays.asList(arr));
	}
}
