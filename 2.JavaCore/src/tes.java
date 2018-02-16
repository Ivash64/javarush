import com.javarush.task.task17.task1711.Solution;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @author Ivanov
 * @since 26.01.2018.
 */
public class tes {
  public static void main(String[] args) throws ParseException {
    Solution.main(Arrays.asList("-c","Миронов","м","15/04/1990","Миронов","м","15/04/1991").toArray(args));
    System.out.println();
    Solution.main(Arrays.asList("-i","0","1","2","3").toArray(args));
    System.out.println();
    Solution.main(Arrays.asList("-d","1","2").toArray(args));
    System.out.println();
    Solution.main(Arrays.asList("-i","0","1","2","3").toArray(args));
    System.out.println();
    Solution.main(Arrays.asList("-u","1","Сидоров","ж","15/03/1990","3","Кашин","ж","16/04/1991").toArray(args));
    System.out.println();
    Solution.main(Arrays.asList("-i","0","1","2","3").toArray(args));
  }
}
