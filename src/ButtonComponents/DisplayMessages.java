package ButtonComponents;

/**
 * @author Zach Sotak
 *
 */
import imageconverter.ImageConverter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import steganographer.Steganographer;



public class DisplayMessages {

//    private static Scanner scan = new Scanner(System.in);
//    public static Scanner getScan() {
//        return scan;
//    }
//    private static void menu() {
//        String menu = "\nSelect an option:\n"
//                + "---------------------\n"
//                + "1. Hide an text\n"
//                + "2. Hide an image\n"
//                + "3. Reveal text from stego image\n"
//                + "4. Reveal an image from a stego image\n"
//                + "5. Convert image to (ppm, jpg, jpeg, png, gif)\n"
//                + "6. Exit\n";
//        System.out.println(menu);
//    }
    /**
     * This fucntion convertImage is will recieve the filename and the format
     * to be converted to and will send those variables to the
     * ImageConverter and convert the image to the desired file.
     * @param filename this is the filename for the image
     * @param format this is the desired format to be converted to
     * @param flag for if the converter worked or not
     * @return returns blank string //may need to change to void
     */
    public static String convertImage(String filename, String format, boolean flag) {
        try {
            /*
            System.out.println("File name to convert: ");
            String filename = scan.nextLine();
            System.out.println("Format to convert(ppm, jpg, jpeg, png, gif): ");
            String format = scan.nextLine();
             */
            String outPath = ImageConverter.convert(filename, format);
            flag = true;
            //System.out.println("Succesfully converted file!");
            return outPath;
        } catch (Exception ex) {
            Logger.getLogger(DisplayMessages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }


    /**
     * This fucntion hideText is will recieve the filename and the text
     * to be hidden in the image. We load the file, instantiate the
     * stegonagher with the image and call the hide function
     * with the text to hide the text in the image.
     * The result will be sent to the file stego-image.ppm
     * @param filename this is the filename for the image
     * @param text this is the desired text to be hidden
     * @param flag for if the message hiding worked or not
     */
    public static void hideText(String fileName, String text, boolean flag) {
        /*
        System.out.println("File name to hide the text: ");
        File f = new File(scan.nextLine());
        System.out.println("Text to hide: ");
        String text = scan.nextLine();
         */
        File f = new File(fileName);
        Steganographer steg = new Steganographer(f);
        boolean hidden = steg.hide(text.getBytes(), "text");
        flag = hidden;
        if (hidden) {
            System.out.println("Successfully hidden text into file (stego-image.ppm)!");
        }
    }

//    public static void hideImage() {
//        try {
//            System.out.println("File name to hide the image (must be substantially larger than the image to hide): ");
//            File f = new File(getScan().nextLine());
//            System.out.println("File name to hide: ");
//            byte[] image = Files.readAllBytes(Paths.get(getScan().nextLine()));
//
//            Steganographer steg = new Steganographer(f);
//            boolean hidden = steg.hide(image, "image");
//
//            if (hidden) {
//                System.out.println("Successfully hidden image into file (stego-image.ppm)!");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DisplayMessages.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public static void revealText() {
//        System.out.println("Key file name (original file): ");
//        File f = new File(getScan().nextLine());
//        System.out.println("File name where text is hidden (stego-image): ");
//        File f2 = new File(getScan().nextLine());
//
//        Steganographer steg = new Steganographer(f);
//        System.out.println("\nHidden Message:\n------------------");
//        steg.reveal(f2, "text");
//        System.out.println("\nSuccessfully revealed text from file (stego-image.ppm)!");
//    }
//    public static void revealImage() {
//        System.out.println("Key file name (original file): ");
//        File f = new File(getScan().nextLine());
//        System.out.println("File name where image is hidden (stego-image): ");
//        File f2 = new File(getScan().nextLine());
//
//        Steganographer steg = new Steganographer(f);
//        steg.reveal(f2, "photo");
//        System.out.println("Successfully revealed image from file (stego-image.ppm)!");
//        System.out.println("File name is revealed-image.ppm");
//    }
//    public static String getFileExtensionFromPath(String path) {
//        int i = path.lastIndexOf('.');
//        if (i > 0) {
//            return path.substring(i + 1);
//        }
//        return "";
//    }
//    public void runSoftware() {
//        int choice = 0;
//        boolean exitProgram = false;
//        do {
//            menu();
//            try {
//                choice = getScan().nextInt();
//                switch (choice) {
//                    case 1:
//                        // hideText();
//                        break;
//                    case 2:
//                        hideImage();
//                        break;
//                    case 3:
//                        revealText();
//                        break;
//                    case 4:
//                        revealImage();
//                        break;
//                    case 5:
//                        // convertImage();
//                        break;
//                    case 6:
//                        System.exit(0);
//                        break;
//                }
//            } catch (InputMismatchException ex) {
//                System.err.println("Please select a valid option");
//            }
//        } while (!exitProgram);
//    }
}
