/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/*
We will get an input file
read that file and write that file into copressed file
taking care no data is lossed
*/
public class compressor {
    public static void method(File file) throws IOException{
        String filedirectory= file.getParent();
        //getting directory of the input file(parent) present in my machine
        //return null if parent doesnot exist
        FileInputStream fis=new FileInputStream(file);
        //used to read byte data from input file
        FileOutputStream fos=new FileOutputStream(filedirectory+"/Compressedfile.gz");
        //used to write byte data into output file which takes directory to which output 
        //file should be stored and gave the name of output file
        //gz is extenxtion for zip file
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);
        //used to compress data of output file
        
        byte[] buffer =new byte[1024];//byte array
        int len;
        
        while((len=fis.read(buffer)) != -1){
            //run loop while reading from fis to byte array !=-1
            gzipOS.write(buffer,0,len);
            // write to output zipfile (buffer store byte read from input file,offset value, ending value)
             
        }
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("/Users/shwet/Documents/CompressorDecompressor/compressor/Test_File.txt");
        method(path);
    }
    
    
}
