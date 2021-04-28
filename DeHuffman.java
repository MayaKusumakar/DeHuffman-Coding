import java.io.*;
import java.util.*;
public class DeHuffman{
     public static void main(String[] args) throws IOException{
         
         Scanner input = new Scanner(System.in);
         System.out.println("Press 1 to compress a file and 2 to decompress a file:  ");
         int action = input.nextInt();
         input.nextLine();
         
         if(action == 1){
            System.out.println("Enter the file to be compressed, including its extension: ");
            String decompressedFileName = input.nextLine();
            System.out.println("Compression code save to: ");
            String codeFileName = input.nextLine();
            System.out.println("File compressed to: ");
            String fileName = input.nextLine();
            
            Scanner uncompressed = new Scanner(new File(decompressedFileName));
            MapHistogram mh = new MapHistogram();
            HuffmanTree ht = new HuffmanTree(uncompressed,mh);
            ht.generateCodeFile(new PrintStream(new File(codeFileName)));
            
            Scanner uncompressed2 = new Scanner(new File(decompressedFileName));
            ht.encode(uncompressed2, fileName);
    
            
         }
         else if (action == 2){
            System.out.println("Enter compressed file name: ");
            String compressedFileName = input.nextLine();
            System.out.println("Enter code file: ");
            String codeFile = input.nextLine();
            System.out.println("What would you like the decompressed file name to be? ");
            String newFileName = input.nextLine();
            
            BitInputStream comp = new BitInputStream(compressedFileName);
            Scanner scan2 = new Scanner(new File(codeFile));
            HuffmanTree ht = new HuffmanTree(scan2);
            
            PrintStream ps = new PrintStream(new File(newFileName));
            ht.decode(comp, ps);
            
            System.out.println("Finished Decoding");
         } 
         else {
         
         }
         
         
         
         /*
         Scanner scan = new Scanner(new File("hamlet.short"));
         BitInputStream comp = new BitInputStream("hamlet.short");
         PrintStream ps = new PrintStream(new File("decode.txt"));
         
         HuffmanTree ht = new HuffmanTree(scan);
         
         ht.decode(comp, ps);
         */
       
         
         
         // Scanner uncompressed = new Scanner(new File("hamlet.txt"));
//             
          //   Scanner uncompressed = new Scanner(new File("hamlet.txt"));
// 
//             MapHistogram mh = new MapHistogram();
//             HuffmanTree ht = new HuffmanTree(uncompressed,mh);
//             ht.generateCodeFile(new PrintStream(new File("Hamlet2.code")));
//             
//             Scanner uncompressed2 = new Scanner(new File("hamlet.txt"));
//             
//             ht.encode(uncompressed2, "hamlet.cmp");
//          ht.printTree();
//                     
          

                     

            
   }
}