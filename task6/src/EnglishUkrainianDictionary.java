import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class EnglishUkrainianDictionary {

    private final Map<String,String> EnglishToUkrainian;

    public EnglishUkrainianDictionary(){
        EnglishToUkrainian = new HashMap<>();
    }

    public String getByKey(String englishWord){
        if(EnglishToUkrainian.containsKey(englishWord)) {
            return EnglishToUkrainian.get(englishWord);
        }else{
            throw new IllegalArgumentException("Our dictionary contains "+englishWord);
        }
    }

    public String getBySentence(String englishSentence){
        String[] strings = englishSentence.toLowerCase(Locale.ROOT).split(" ");
        return Arrays.stream(strings).map(this::getByKey).collect(Collectors.joining(" ")).replace("   ", " ");
    }

    public void addWordToDictionary(String english, String ukrainian){
        EnglishToUkrainian.put(english, ukrainian);
    }
}
