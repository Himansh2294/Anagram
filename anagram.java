import java.io.FileNotFoundException;

        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;

public class anagram {
    public static void main(String []args) throws FileNotFoundException {
        String fileName = "C:\\Users\\agrawaay\\Documents\\sowpods.txt";
        FileReader fread = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fread);
        HashMap<String, String> anagramWords =new HashMap<>();
        String line = "";
        try {
            while((line = bufferedReader.readLine()) != null) {
                char [] array = line.toCharArray();
                Arrays.sort(array);
                String sortedString = String.valueOf(array);
                addSortedWord(sortedString, line, anagramWords);

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        display(anagramWords);

    }

    private static void display(HashMap<String, String> anagramWords) {

        for(String word : anagramWords.keySet()) {
            String [] str = anagramWords.get(word).split(",");
            if(str.length > 1) {
                System.out.println(word+":"+anagramWords.get(word));
            }

        }
    }

    private static void addSortedWord(String sortedString, String word, HashMap<String, String> anagramWords) {
        if(isContainsWord(sortedString, anagramWords)){
            anagramWords.put(sortedString, anagramWords.get(sortedString) + ", "+word);
        } else {
            anagramWords.put(sortedString, word);
        }
    }

    private static boolean isContainsWord(String sortedString, HashMap<String, String> anagramWords) {
        return anagramWords.containsKey(sortedString);
    }


}
