package onetopic.xmlandjavaconvert;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;

import onetopic.xml2java.Xml2java;
import onetopic.xmlandjavaconvert.obj.Product;

import org.junit.Test;

public class Xml2javaTest
{
    @Test
    public void convertToJavaPojoTest() throws FileNotFoundException, JAXBException
    {
        
        String filePath = this.getClass().getResource("xml/").getPath() + "javaXml.xml";
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        
        Product obj = (Product) new Xml2java().convertToJavaPojo(fileInputStream,Product.class);
        
        Product product = (Product) obj;
        
        assertEquals("equal message", "WI1", product.getCode());
        assertEquals("equal message", "Widget Number One", product.getName());
        assertEquals("equal message", new BigDecimal("300.0"), product.getPrice());
        
    }
}
