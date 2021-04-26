import java.io.*;
import java.util.*;
public class DeHuffman{
     public static void main(String[] args) throws IOException{
         /*
         Scanner input = new Scanner(System.in);
         System.out.println("Enter the filename for the code file: ");
         String codeFile = input.nextLine();
         Scanner scan = new Scanner(new File("hamlet.code"));
         System.out.println("Enter the filename for the encoded file: ");
         String compressedFile = input.nextLine();
         
         BitInputStream comp = new BitInputStream(compressedFile);
         HuffmanTree ht = new HuffmanTree(scan);
         ht.printTree();
         
         PrintStream ps = new PrintStream(new File("decoded.txt"));
         ht.decode(comp, ps);
         */
         
         Scanner uncompressed = new Scanner(new File("hamlet.txt"));
            
         MapHistogram mh = new MapHistogram();
         HuffmanTree ht = new HuffmanTree(uncompressed,mh);
         ht.printTree();
                    
//          ht.generateCodeFile(new PrintStream(new File("Hamlet2.code")));    

            
   }
}