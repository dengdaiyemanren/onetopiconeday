/**
 * 
 */
package onetopic.xml2java;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author yinlg
 * @created 2016年3月19日 上午12:02:36
 */
public class Xml2javaByXpath {

	public Document parseInputStream(InputStream inputStream) throws ParserConfigurationException, SAXException,
			IOException {
		// 创建文档处理对象
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// 通过DocumentBuilder创建doc的文档对象
		Document doc = db.parse(inputStream);

		return doc;
	}

	public Object convertToJavaPojo(InputStream inputStream) throws ParserConfigurationException, SAXException,
			IOException {

		//Document doc = parseInputStream(inputStream);

		return null;
	}

	public NodeList getNodeList(Document doc, String path) throws XPathExpressionException {
		// 创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList nodeList = (NodeList) xpath.evaluate(path, doc, XPathConstants.NODESET);

		return nodeList;
	}

	public Node getNode(Document doc, String path) throws XPathExpressionException {
		// 创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();

		Node node = (Node) xpath.evaluate(path, doc, XPathConstants.NODE);

		return node;
	}

	public String getNodeAttrValue(Document doc, String path, String attr) throws XPathExpressionException {
		// 创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList nodeList = (NodeList) xpath.evaluate(path, doc, XPathConstants.NODESET);
		Element element =(Element) nodeList.item(0);
		
		return element.getAttribute(attr);

	}

	public NodeList getChildNodes(Node node, String path) throws XPathExpressionException {
		// 创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList nodeList = (NodeList) xpath.evaluate(path, node, XPathConstants.NODESET);

		return nodeList;
	}

}
