package onetopic.xml2java;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * xml转化为java对象
 * 
 * @author yinlg
 * @created 2015年9月2日 下午11:49:55
 */
public class Xml2java
{
    
    public Object convertToJavaPojo(InputStream inputStream, Class classType) throws JAXBException
    {
        JAXBContext jc = JAXBContext.newInstance(classType);
        Unmarshaller u = jc.createUnmarshaller();
        
        return u.unmarshal(inputStream);
    }
    
    public static void main(String[] args) throws JAXBException, FileNotFoundException
    {
        /*
         * File file = new File("javaXml.xml");
         * FileInputStream fileInputStream = new FileInputStream(file);
         * Product obj = (Product) new Xml2java().convertToJavaPojo(fileInputStream);
         * Product product = (Product) obj;
         * System.out.println(product.getCode());
         * System.out.println(product.getName());
         * System.out.println(product.getPrice());
         */
    }
    
}
