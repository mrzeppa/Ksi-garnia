import org.dom4j.DocumentException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        BookCRUD bc = new BookCRUD();
//        bc.createBook("autor5","122", "Anka z zielonego", "200", "zł", "201", "Nowa Era", "2011");
        bc.sort();

        AuthorCRUD ac = new AuthorCRUD();
//        System.out.println(ac.getAuthorNextId());
        ac.createBook("Misza", "Ivachenko");
    }
}
