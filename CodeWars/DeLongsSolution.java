import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Solving this https://www.codewars.com/kata/5bc6f9110ca59325c1000254/java
 */
public class Main {

   public static int testCounter = 0;

   public static Map<Integer, Integer> count(int[][] chessBoard) {
      // Debugging
      ++testCounter;
      System.out.println("Test number:" + testCounter);
      System.out.println("With field count: " + chessBoard.length);

      HashMap<Integer, Integer> countEmptyFields = new HashMap<Integer, Integer>();

      for (int i = 0; i < chessBoard.length; i++) {
         for (int j = 0; j < chessBoard[i].length; j++) {
            if (chessBoard[i][j] == 1) {
               if (countEmptyFields.containsKey(i)) {
                  // For each field with 1 the count is added up
                  countEmptyFields.put(i, countEmptyFields.get(i) + 1);
               } else {
                  // Init for the field count
                  countEmptyFields.put(i, 1);
               }
            }
         }
      }

      // Reverse order by using keys as attribute and
      // putting the value/key pair back in reverse
      HashMap<Integer, Integer> countEmptyFieldsReversed = countEmptyFields.entrySet().stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (e1, e2) -> e1, HashMap::new));

      return countEmptyFieldsReversed;
   }
}