import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParseXML {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("patientData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("patient");
            
            System.out.println("Patient Data:");
            System.out.println("--------------------------------------------------");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String patientName = element.getElementsByTagName("patientName").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                    
                    System.out.println("Patient Name: " + patientName);
                    System.out.println("Age: " + age);
                    System.out.println("Gender: " + gender);
                    System.out.println("--------------------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}