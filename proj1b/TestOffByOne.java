import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offBy3= new OffByN(3);
    // Your tests go here.
    /*Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void TestOffByOne(){
        assertTrue(offByOne.equalChars('a','b'));
        assertFalse(offByOne.equalChars('a','c'));
    }

    @Test
    public void TestOffBy3(){
        assertTrue(offBy3.equalChars('a','d'));
        assertFalse(offBy3.equalChars('a','b'));

    }
}
