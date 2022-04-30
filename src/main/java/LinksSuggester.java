import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinksSuggester {
    private static final int TYPE_KEYWORD = 0;
    private static final int TYPE_TITLE = 1;
    private static final int TYPE_URL = 2;

    List<Suggest> suggestList = new ArrayList<>();

    public LinksSuggester(File file) throws IOException, WrongLinksFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Scanner scanner;
        String line;

        int i = 0;
        while ((line = reader.readLine()) != null) {
            Suggest suggest = new Suggest();
            scanner = new Scanner(line);
            scanner.useDelimiter("\t");
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (i) {
                    case TYPE_KEYWORD: {
                        suggest.setKeyWord(data);
                        break;
                    }
                    case TYPE_TITLE: {
                        suggest.setTitle(data);
                        break;
                    }
                    case TYPE_URL: {
                        suggest.setUrl(data);
                        break;
                    }
                    default:
                        throw new WrongLinksFormatException("Данные не верные, в строке должно быть три части: ключевое слово, заголовок  и ссылка");
                }
                i++;
            }
            i = 0;
            suggestList.add(suggest);
        }
        reader.close();
    }

    public List<Suggest> getSuggestList() {
        return suggestList;
    }

    public List<Suggest> suggest(String text) {
        List<Suggest> suggestOnFirstPage = new ArrayList<>();

        for (Suggest s : suggestList) {
            if (text.toLowerCase().contains(s.getKeyWord())) {
                suggestOnFirstPage.add(s);
            }
        }
        return suggestOnFirstPage;
    }
}
