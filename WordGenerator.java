import java.util.ArrayList;
import java.util.Random;

public class WordGenerator{
    private ArrayList<String> words;
    
    public WordGenerator(){
        words = new ArrayList<>();
        fillArrayList();
    }
    
    public void fillArrayList(){
        words.add("boolean");
        words.add("break");
        words.add("byte");
        words.add("case");
        words.add("char");
        words.add("class");
        words.add("continue");
        words.add("do");
        words.add("double");
        words.add("else");
        words.add("enum");
        words.add("for");
        words.add("if");
        words.add("import");
        words.add("int");
    }
    
    public String generateWord(){
        Random rand = new Random();
        int index = rand.nextInt(words.size());
        return words.get(index);
    }
    
    public void addWord(String word){
        words.add(word);    
    }
}