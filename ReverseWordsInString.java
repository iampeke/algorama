public static String reverseWords(String s) {

  // Trim leading and ending white space:
  s = s.trim();
  
  // Split the words by any amount of white space between words:
  String[] words = s.split("\\s+");
  
  // Reverse the words of the string:
  int len = words.length;
  String result = "";
  if (len == 0) {
      return result;
  }
  for (int i = (len-1); i > 0; i--) {
      result = result + words[i] + " ";
  }
  result = result + words[0];
  return result;
}
