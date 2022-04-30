public class Suggest {
    private String keyWord;
    private String title;
    private String url;

    public Suggest(String keyWord, String title, String url) {
        this.keyWord = keyWord;
        this.title = title;
        this.url = url;
    }

    public Suggest() {
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return keyWord + '\'' +
                title + '\'' +
                url + '\'';
    }
}
