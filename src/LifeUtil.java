import java.lang.Object;
/**
 * 
 *
 */
public class LifeUtil {
    /**
     * obtenir les position et longeur qu'on veut translation
     * 
     * @param lc
     * @return
     */
    public static UsefulData getUsefulData(LC lc) {
        int length = 1;
        int x = 0;
        int y = 0;
        Maillon m = lc.getTete();
        if (m == null) {
            return null;
        }
        Cellule c = (Cellule) m.info;
        x = c.getColonne();
        y = c.getLigne();
        while (true) {
            m = m.suivant;
            if (m == null) {
                break;
            }
            c = (Cellule) m.info;
            // 获取左上方坐标 obtenir la position de haut-gauche
            if (x > c.getColonne()) {
                x = c.getColonne();
                y = c.getLigne();
            }
            else if (x == c.getColonne()) {
                if (y > c.getLigne()) {
                    x = c.getColonne();
                    y = c.getLigne();
                }
            }
            length++;
        }
        return new UsefulData(0 - x, 0 - y, length);
    }

    /**
     * 获取平移后的细胞 obtenir les cellues apres translation
     * 
     * @return
     */
    public static Cellule[] move(LC lc, UsefulData data) {
        Cellule[] arry = new Cellule[data.getLCLength()];
        int addX = data.getAddX();
        int addY = data.getAddY();
        int length = 0;
        Maillon m = lc.getTete();
        if (m == null) {
            return null;
        }
        Cellule c = (Cellule) m.info;
        arry[length] = new Cellule(c.getColonne() + addX, c.getLigne() + addY);
        // 平移
        while (true) {
            m = m.suivant;
            if (m == null) {
                break;
            }
            length++;
            c = (Cellule) m.info;
            arry[length] = new Cellule(c.getColonne() + addX, c.getLigne() + addY);
        }
        return arry;
    }

    /**
     * 比较平移后的坐标位置是否相等 comparer les positions equals ou pas
     * 
     * @return
     */
    public static boolean equal(Cellule[] firstGenMoveCell, Cellule[] otherGenMoveCell) {
        if (firstGenMoveCell == null || otherGenMoveCell == null) {
            return false;
        }
        if (firstGenMoveCell.length != otherGenMoveCell.length) {
            return false;
        }
        Cellule[] originArray = copyCellArray(firstGenMoveCell);
        int count = originArray.length;
        Cellule c = null;
        Cellule c2 = null;
        for (int i = 0; i < otherGenMoveCell.length; i++) {
            c = otherGenMoveCell[i];
            for (int j = 0; j < originArray.length; j++) {
                c2 = originArray[j];
                if (c2 != null && c2.equals(c)) {
                    count--;
                    originArray[j] = null;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    private static Cellule[] copyCellArray(Cellule[] cells) {
        if (cells == null) {
            return null;
        }
        Cellule[] array = new Cellule[cells.length];
        array=cells.clone();

        return array;
    }
}