import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AuthorCRUD {
    private final SAXReader READER = new SAXReader();
    private Document document;

    public AuthorCRUD() throws DocumentException {
        this.document = this.READER.read("Ksiegarnia.xml");
    }

    public void read() {
        List<Node> nodes = this.document.selectNodes("ksiegarnia/autorzy/autor");
        for (Node n : nodes) {
            Element e = (Element) n;
            System.out.println(this.getContent(e));
        }
    }

    private String getContent(Element element) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Element> i = element.elementIterator(); i.hasNext();) {
            Element e = i.next();
            stringBuilder.append(e.asXML());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
    public void createBook(String imie, String nazwisko) throws IOException {
        int authorId = getAuthorNextId();
        Node n = document.selectSingleNode("//ksiegarnia/autorzy");
        Element root = (Element) n;
        Element author = root.addElement("autor");
        Element name = author.addElement("imie");
        Element surname = author.addElement("nazwisko");
        author.addAttribute("autorId", "autor" + authorId);
        name.setText(imie);
        surname.setText(nazwisko);

        save();
    }

    private void save() throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        Writer writer = new OutputStreamWriter(new FileOutputStream(this.document.getName()));
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(this.document);
        xmlWriter.close();
    }

    public void delete(String xPath) throws IOException {
        Node node = this.document.selectSingleNode(xPath);
        node.detach();
        save();
    }

    public void sort() {
        List<Node> nodes = this.document.selectNodes("//ksiegarnia/autorzy/autor");
        Collections.sort(nodes, (Node n1, Node n2) -> n1.getStringValue().compareTo(n2.getStringValue()));
        for (Node n : nodes) {
            Element e = (Element) n;
            System.out.println(this.getContent(e));
        }
    }

    public int getAuthorNextId(){
        List<Node> nodes = this.document.selectNodes("ksiegarnia/autorzy/autor");
        return nodes.size() + 1;
    }
}
