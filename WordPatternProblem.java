public class WordPatternProblem {
    
    public static Character keyForValue(HashMap<Character, String> map, String value) {
        for (Character o : map.keySet()) {
            if (map.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
    
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hMap = new HashMap<Character, String>();
        String[] wordsInStr = str.split(" ");
        int patternLen = pattern.length();
        
        if (wordsInStr.length != patternLen) {
            return false;
        }
        
        for (int i=0; i < pattern.length(); i++) {
            char currentLetter = pattern.charAt(i);
            String currentWord = wordsInStr[i];
            if (hMap.containsValue(currentWord)) {
                char prevStoredKey = keyForValue(hMap, currentWord);
                if (currentLetter != prevStoredKey) {
                    return false;
                }
            } else if (!hMap.containsKey(currentLetter)) {
                hMap.put(currentLetter, currentWord);
            } else {
                String prevStoredWordValue = hMap.get(currentLetter);
                if (!prevStoredWordValue.equals(currentWord)) {
                    return false;
                }
            }
        }
        return true;
    }
}
