import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AdditionalOperationsTest extends BaseTest {
    AdditionalOperations additionalOperations = new AdditionalOperations();


    @Test()
    public void assertEqualsNoOrder(List<Integer> list1, List<Integer> list2) {

        assertEqualsNoOrder(additionalOperations.list1, additionalOperations.list2);
    }

   @Test()
    public void assertTrue( boolean b) {

      assertTrue(additionalOperations.arr1[1]==additionalOperations.arr2[1]);
   }

    @Test()
    public void assertFalse( boolean b) {

        assertFalse(additionalOperations.arr1[3]==additionalOperations.arr2[3]);
    }

    @Test()
    public void assertArrayEquals( int arr1[], int arr2[]) {

        assertArrayEquals(additionalOperations.arr1,additionalOperations.arr2 );
    }

    @Test()
    public void assertNull( String p){

        assertNull(additionalOperations.str1 );
    }
}