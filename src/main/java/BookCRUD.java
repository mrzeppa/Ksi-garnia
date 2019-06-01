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
public class BookCRUD {
    private final SAXReader READER = new SAXReader();
    private Document document;

    public BookCRUD() throws DocumentException {
        this.document = this.READER.read("Ksiegarnia.xml");
    }

    public void read() {
        List<Node> nodes = this.document.selectNodes("ksiegarnia/produkty/ksiazki/ksiazka");
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
    public void createBook(String autorId, String ilosc, String nazwaKsiazki, String cena,
                           String currency, String liczbaStron, String wydawnictwo, String rokWydania) throws IOException {
        Node n = document.selectSingleNode("//ksiegarnia/produkty/ksiazki");
        Element root = (Element) n;
        Element book = root.addElement("ksiazka");
        Element author = book.addElement("autorId");
        Element bookName = book.addElement("nazwaKsiazki");
        Element price = book.addElement("cena");
        Element noOfPages = book.addElement("liczbaStron");
        Element publisher = book.addElement("wydawnictwo");
        Element year = book.addElement("rokWydania");
        root.addAttribute("ilosc", ilosc);
        author.addAttribute("refid", autorId);
        price.addAttribute("currency", currency);
        bookName.setText(nazwaKsiazki);
        price.setText(cena);
        noOfPages.setText(liczbaStron);
        publisher.setText(wydawnictwo);
        year.setText(rokWydania);

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
        List<Node> nodes = this.document.selectNodes("//ksiegarnia/produkty/ksiazki/ksiazka");
        Collections.sort(nodes, (Node n1, Node n2) -> n1.getStringValue().compareTo(n2.getStringValue()));
        for (Node n : nodes) {
            Element e = (Element) n;
            System.out.println(this.getContent(e));
        }
    }
}
