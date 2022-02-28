import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void test1() {
        int duplicate1 = Main.findDuplicatesInList(new String[]{"Dusan"});
        assertEquals(0, duplicate1);
    }

    @Test
    public void test2() {
        int duplicate2 = Main.findDuplicatesInList(new String[]{"Dusan", "David", "Pera", "Dusan", "Mila"});
        assertEquals(1, duplicate2);
    }

    @Test
    public void test3() {
        int duplicate2 = Main.findDuplicatesInList(new String[]{"Dusan", "David", "Pera", "Dusan", "Mila", "David"});
        assertEquals(2, duplicate2);
    }

    @Test
    public void test4() {
        int duplicate2 = Main.findDuplicatesInList(new String[]{});
        assertEquals(0, duplicate2);
    }
}
