/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thermalprinter;
 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
 
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author Youtube
 */
public class ThermalPrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        //print some stuff. Change the printer name to your thermal printer name.
        //printerService.printString("POS-58-Series", "\n\n testing testing 1 2 3eeeee \n\n\n\nhello\n\n\n\n\njigin\nprint test\n\n\n\n\n");

        byte[] central = {0x1B, 0x61, 1};
        printerService.printBytes("POS-58-Series", central);
        printerService.printString("POS-58-Series", "TEXT mera");
        byte[] lineFeed = {0x0A};
        printerService.printBytes("POS-58-Series", lineFeed);
        printerService.printString("POS-58-Series", "TEXT");
        // cut that paper!
        byte[] cutP = new byte[] { 0x1d, 'V', 1 };

        printerService.printBytes("POS-58-Series", cutP);
        
        printerService.printBytes("POS-58-Series", lineFeed);
        printerService.printBytes("POS-58-Series", lineFeed);
        printerService.printBytes("POS-58-Series", lineFeed);
        printerService.printBytes("POS-58-Series", lineFeed);
        printerService.printBytes("POS-58-Series", lineFeed);
        
    }
}
