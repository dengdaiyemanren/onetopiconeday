package onetopic.xmlandjavaconvert;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;

import onetopic.java2xml.Java2xml;
import onetopic.xmlandjavaconvert.obj.Product;

import org.junit.Test;

public class Java2xmlTest
{
    @Test
    public void javaToxmlFile() throws JAXBException
    {
        Product object = new Product();
        object.setCode("WI1");
        object.setName("Widget Number One");
        object.setPrice(BigDecimal.valueOf(300.00));
        
        String filePath = this.getClass().getResource("xml/").getPath() + "javaXml.xml";
        
        OutputStream os = null;
        try
        {
            os = new FileOutputStream(filePath);
            new Java2xml().convertToXml(object, os);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != os)
            {
                try
                {
                    os.close();
                }
                catch (IOException e)
                {
                }
            }
        }
        
    }
    
    @Test
    public void javaToxmlSytemOut() throws JAXBException
    {
        Product object = new Product();
        object.setCode("WI1");
        object.setName("Widget Number One");
        object.setPrice(BigDecimal.valueOf(300.00));
        OutputStream os = null;
        try
        {
            os = System.out;
            new Java2xml().convertToXml(object, System.out);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                }
                catch (IOException e)
                {
                }
            }
        }
        
    }
    
}
