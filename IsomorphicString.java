private static Character getKeyForValue(HashMap<Character, Character> map, Character c){
    for(Character key : map.keySet()){
        if(map.get(key) == c){
            return key; //return the first found
        }
    }
    return null;
}
    
public static boolean isIsomorphic(String s, String t) {
    // If either string is null -> FALSE
    if (s == null || t == null) {
        return false;
    }
    
    int sLen = s.length();
    int tLen = t.length();
    
    // If the strings are not the same length -> FALSE
    if (sLen != tLen) {
        return false;
    }
    
    // If the strings are both length of 0 -> TRUE
    if (sLen == 0 && tLen == 0) {
        return true;
    }
    
    // Hashmap to store the iso-mappings:
    // sChar => tChar
    HashMap<Character, Character> isoMap = new HashMap<Character, Character>();
    
    // Walk through all of the characters in the strings to make sure they meet the iso-requirements:
    for (int i = 0; i < sLen; i++) {
        Character sChar = s.charAt(i);
        Character tChar = t.charAt(i);
        
        // For checking if tChar has already been mapped to:
        Character backwardChar = getKeyForValue(isoMap, tChar);
        
        if (isoMap.containsKey(sChar)) { // Check prev. forward mapping for sChar
            if (isoMap.get(sChar) != tChar) {
                return false;
            }
        } else if (backwardChar != null && backwardChar != sChar) { // Check prev. backward mapping for tChar
            return false;
        } else { // If no prev. mapping, add the mapping for sChar => tChar
            isoMap.put(sChar, tChar);
        }
    }
    
    return true;
    
}
