package team.doma;

public class WordObj {
    String deutschWord;
    String spanischWord;
    int prority = 0;

    public void setDeutschWord(String deutschWord) {
        this.deutschWord = deutschWord;
    }

    public void setSpanischWord(String spanischWord) {
        this.spanischWord = spanischWord;
    }

    public void setPrority(int prority) {
        this.prority = prority;
    }

    public String getDeutschWord() {
        return deutschWord;
    }

    public String getSpanischWord() {
        return spanischWord;
    }

    public int getPrority() {
        return prority;
    }
}
