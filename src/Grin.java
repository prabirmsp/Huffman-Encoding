import java.io.IOException;
import java.util.Scanner;

public class Grin {

    public static void main(String[] args) {
        // write your code here
        if (args.length > 0 && args.length <= 3) {
            if (args[0].equalsIgnoreCase("encode") || args[0].equalsIgnoreCase("decode")) {

                Scanner input = new Scanner(System.in);

                String infile, outfile;

                if (!(args.length >= 2)) {
                    System.out.printf("Enter input filename: ");
                    infile = input.nextLine();
                } else
                    infile = args[1];

                if (!(args.length >= 3)) {
                    System.out.printf("Enter output filename: ");
                    outfile = input.nextLine();
                } else
                    outfile = args[2];

                try {
                    if (args[0].equalsIgnoreCase("encode"))
                        GrinEncoder.encode(infile, outfile);
                    else
                        GrinDecoder.decode(infile, outfile);

                } catch (IOException e) {
                    System.out.println("There was an error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid Argument: " + args[0]);
                System.out.println("Usage: grin <encode|decode> <infile> <outfile>");
            }
        } else {
            System.out.println("Invalid number of arguments.");
            System.out.println("Usage: grin <encode|decode> <infile> <outfile>");
        }
    }
}
