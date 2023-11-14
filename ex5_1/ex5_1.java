package ex5_1;

import java.util.ArrayList;
import java.util.List;
/**
 * 4theme
 * exercise5_1
 * @author Vitalii Reshetnyk
 */
class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}

class Sentence {
    private List<Word> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Word> getWords() {
        return words;
    }
}

class Text {
    private List<Sentence> sentences;
    private String title;

    public Text(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printText() {
        System.out.println("Title: " + title);
        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                System.out.print(word.getWord() + " ");
            }
            System.out.println();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class ex5_1 {
    public static void main(String[] args) {

        Word hello = new Word("Hello");
        Word world = new Word("world");
        Word example = new Word("example");


        Sentence sentence1 = new Sentence();
        sentence1.addWord(hello);
        sentence1.addWord(world);


        Sentence sentence2 = new Sentence();
        sentence2.addWord(example);


        Text text = new Text("My Text");
        text.addSentence(sentence1);
        text.addSentence(sentence2);


        text.printText();


        Word addedWord = new Word("added");
        sentence2.addWord(addedWord);
        text.printText();


        text.setTitle("Updated Text");
        text.printText();
    }
}
