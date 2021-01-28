import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData
    {
        public String[] readFile(String fname,int fcount) {
            FileReader fr;
            String allFlipkart[]= new String[fcount];
            try {
                    int count=0;
                    int i=0;
                    fr = new FileReader(fname);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while ((line=br.readLine()) != null) {
                            allFlipkart[i]=line;
                            i++;
                    }
                    br.close();
                    System.out.println(count);
            } catch (FileNotFoundException e) {

                    e.printStackTrace();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return allFlipkart;
    }

    public int getFileCount(String fname) {
            FileReader fr;
            int count=0;
            try {
                    fr = new FileReader(fname);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while ((line=br.readLine()) != null) {
                            count=count+1;
                    }
                    br.close();
                    System.out.println(count);
            } catch (FileNotFoundException e) {

                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return count;    
    }

    public Product[] retriveData(String[] allFlipkartData, int fCount) {
                    Product obj[] = new Product[fCount];
                    try {
                            
                            for (int i = 0; i < allFlipkartData.length; i++) {
                                    String spltData[] = allFlipkartData[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                                    obj[i] = new Product();
                                    obj[i].setPid(spltData[0]);
                                    obj[i].setProduct_name(spltData[1]);
                                    obj[i].setBrand(spltData[2]);
                                    obj[i].setProduct_url(spltData[3]);
                                    obj[i].setRetail_price(Integer.parseInt(spltData[4]));
                                    obj[i].setDiscounted_price(Integer.parseInt(spltData[5]));
                                    if(spltData[6].equalsIgnoreCase("No rating available"))
                                    {
                                            obj[i].setProduct_rating(0.0f);
                                    }
                                    else
                                    {
                                            obj[i].setProduct_rating(Float.parseFloat(spltData[6]));
                                    }
                                    
                    } 
                   
            }catch (NumberFormatException e) {
                 System.out.println(" f exception");
            }
            return obj;
      
            }

    

        public ArrayList addToArrayList(Product[] productObj) {
            ArrayList<Product> al = new ArrayList<Product>();
            for (int i = 0; i < productObj.length; i++) {
                al.add(productObj[i]);
            }
            System.out.println("*******************************************************");
            for (int i = 0; i < productObj.length; i++) {
              //  System.out.println(al.get(i));
            }
            return al;
        }

        public void writeSortFile(ArrayList allProducts, String writeFileName) {

            try {
                FileWriter fw = new FileWriter(writeFileName);
                
                fw.append("Product_id,");
                fw.append("product_name,");
                fw.append("brand,");
                fw.append("product_url,");
                fw.append("retail_price,");
                fw.append("discounted_price,");
                fw.append("product_rating");
                fw.append("\n");
    
               for (int i = 0; i < allProducts.size(); i++) {
                       
                    fw.append(allProducts.get(i).toString());
                    fw.append("\n");
                       
               }
               fw.close();
        } catch (IOException e) {
               
                e.printStackTrace();
        }
    }

    }