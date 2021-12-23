import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        EnglishUkrainianDictionary dictionary = new EnglishUkrainianDictionary();
        DictionaryCreator.SetUoDictionary(dictionary);

        String englishPhrase = "Java is the most popular in the world";
        System.out.println("Example of translation");
        System.out.println(englishPhrase);

        try{
            System.out.println(dictionary.getBySentence(englishPhrase));
        }catch(IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }

        appLoop:
        while (true){
            System.out.println("input 1 to input new pair");
            System.out.println("input 2 to to input new sentence");
            System.out.println("input 3 to quit");
            System.out.print("Key: ");
            int res = in.nextInt();
            switch (res){
                case 1:
                    addNewPair(in, dictionary);
                    break;
                case 2:
                    inputNewSentence(in, dictionary);
                    break;
                case 3:
                    break appLoop;
                default:
                    System.out.println("Invalid command, try again");
            }
        }
    }

    public static void addNewPair(Scanner in, EnglishUkrainianDictionary dict){
        in.nextLine();
        System.out.println("Input english word");
        String engWord = in.nextLine();
        System.out.println("Input its translation into ukrainian");
        String ukrWord = in.nextLine();
        dict.addWordToDictionary(engWord, ukrWord);
    }

    public static void inputNewSentence(Scanner in, EnglishUkrainianDictionary dict){
        in.nextLine();
        System.out.println("Input english sentence");
        String engSentence = in.nextLine();
        System.out.println(dict.getBySentence(engSentence));
    }
}
