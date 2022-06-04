package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
	   public static void main(String[] args) throws IOException {

	String filename = "C:\\Users\\Admin\\Downloads\\Programs\\Git-2.36.0-64-bit.exe";
	byte[] inputBytes= { 0 };
	long startTime;
	long endTime;{
	inputBytes = Files.readAllBytes(Paths.get(filename));
	startTime = System.currentTimeMillis();
	StringBuffer outputStringBuffer =new StringBuffer();
	for(byte b : inputBytes) {
		outputStringBuffer.append((char)b);
		
	}
	endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
}
	}
}
