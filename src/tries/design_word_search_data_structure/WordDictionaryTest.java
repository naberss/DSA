package tries.design_word_search_data_structure;



public class WordDictionaryTest {

    public static void main(String[] args) {
        var test = new WordDictionary();
        test.addWord("etg");
        System.out.println(test.search(".t."));
    }


}
