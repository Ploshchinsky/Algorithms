import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
* Liquid Island
*
* Given: There is a two-dimensional island consisting of [b] blocks. It forms a landscape with depressions.
* Problem: Calculate how many blocks with liquid {-} can fit into these depressions .
*
*       [b]{-}[b]
* [b]{-}[b][b][b]{-}{-}{-}[b]
* [b]{-}[b][b][b][b]{-}{-}[b]
* [b][b][b][b][b][b][b][b][b][b]
*
* */
public class LiquidIsle {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 3, 4, 2, 1, 1, 3, 1};

        System.out.println(liquidValue(arr));
    }

    private static int liquidValue(int[] intArr) {
        int absMax = 0;
        int indexAbsMax = 0;
        int currentMax = 0;
        int resValue = 0;

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] >= absMax) {
                absMax = intArr[i];
                indexAbsMax = i;
            }
        }

        for (int i = 0; i < indexAbsMax; i++) {
            if (intArr[i] > currentMax) {
                currentMax = intArr[i];
                continue;
            }
            resValue += currentMax - intArr[i];
        }

        currentMax = 0;

        for (int i = intArr.length - 1; i > indexAbsMax; i--) {
            if (intArr[i] > currentMax) {
                currentMax = intArr[i];
                continue;
            }
            resValue += currentMax - intArr[i];
        }

        return resValue;
    }
}
