package team.doma;

public class WordObj {
    String deutschWord;
    String spanischWord;
    int priority = 1;

    public void setDeutschWord(String deutschWord) {
        this.deutschWord = deutschWord;
    }

    public void setSpanischWord(String spanischWord) {
        this.spanischWord = spanischWord;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDeutschWord() {
        return deutschWord;
    }

    public String getSpanischWord() {
        return spanischWord;
    }

    public int getPriority() {
        return priority;
    }
}
