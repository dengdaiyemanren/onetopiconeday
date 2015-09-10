package onetopic.java2xml;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 把java类转换为xml文件
 * 
 * @author yinlg
 * @created 2015年9月2日 下午11:48:16
 */
public class Java2xml
{
    
    public void convertToXml(Object obj, OutputStream os) throws JAXBException, FileNotFoundException
    {
        JAXBContext context;
        context = JAXBContext.newInstance(obj.getClass());
        
        Marshaller marsh;
        marsh = context.createMarshaller();
        
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marsh.marshal(obj, os);
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, JAXBException
    {
        /*
         * Product object = new Product();
         * object.setCode("WI1");
         * object.setName("Widget Number One");
         * object.setPrice(BigDecimal.valueOf(300.00));
         * String filePath = "javaXml.xml";
         * OutputStream os = new FileOutputStream(filePath);
         * new Java2xml().convertToXml(object, os);
         */
        
    }
    
}
