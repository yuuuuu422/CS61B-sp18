import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArrayDequeGold(){
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        for(int i=0;i<1000;i++){
            if (arrayDequeSolution.size()==0){
                int opt_2 = StdRandom.uniform(2);
                if (opt_2 == 0){
                    arrayDequeSolution.addFirst(i);
                    studentArrayDeque.addFirst(i);
                }else {
                    Integer arrRemoveNumber = null,stuRemoveNumber=null;
                    int opt_4 = StdRandom.uniform(4);
                    switch (opt_4){
                        case 0:
                            arrayDequeSolution.addFirst(i);
                            studentArrayDeque.addFirst(i);
                            break;
                        case 1:
                            arrayDequeSolution.addLast(i);
                            studentArrayDeque.addLast(i);
                            break;
                        case 2:
                            arrRemoveNumber= arrayDequeSolution.removeFirst();
                            stuRemoveNumber= studentArrayDeque.removeFirst();
                            break;
                        case 3:
                            arrRemoveNumber = arrayDequeSolution.removeLast();
                            stuRemoveNumber = studentArrayDeque.removeLast();
                            break;
                        default:
                    }
                    assertEquals("",arrRemoveNumber,stuRemoveNumber);
                }
            }
        }

    }
}
