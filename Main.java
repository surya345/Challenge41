import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        String filePath="./data/flipkart-product-sample.csv";
        FileData fd= new FileData();
        int fileCount=fd.getFileCount(filePath);
        String[] allFlipkartData= fd.readFile(filePath, fileCount);
        System.out.println("total count is "+fileCount); 
        System.out.println("========================================");
        Product[] pdObj=fd.retriveData(allFlipkartData,fileCount);
        ArrayList allProducts= fd.addToArrayList(pdObj);
        System.out.println("========================================");
        System.out.println("Sorted ArrayList based on Product Reatil Price");
        System.out.println("========================================");
        Collections.sort(allProducts,Product.priceComp);
        // for(int i=0;i<allProducts.size();i++){
        //     System.out.println(allProducts.get(i));
        // }
        fd.writeSortFile(allProducts,"sortedPriceFile");
        System.out.println("========================================");
        Collections.sort(allProducts,Product.ratingComp);
        System.out.println("========================================");
        System.out.println("Sorted ArrayList based on Product Rating");
        for(int i=0;i<allProducts.size();i++){
            System.out.println(allProducts.get(i));
        }
        fd.writeSortFile(allProducts,"sortedRatingFile");
       }

   
    }
 
