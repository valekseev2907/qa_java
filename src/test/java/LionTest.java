import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    @Test
    public void doesHaveManeShouldReturnCorrectValue() throws Exception {
        Lion lion = new Lion(sex, feline);

        boolean actual = lion.doesHaveMane();

        Assert.assertEquals(hasMane, actual);
    }

    @Test
    public void doesHaveManeShouldReturnException() {
        Assert.assertThrows("Используйте допустимые значения пола животного - самец или самка", Exception.class, () -> new Lion("Самцы", feline));
    }

    @Test
    public void getFoodShouldReturnCorrectListObject() throws Exception {
        Lion lion = new Lion(feline);

        List<String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(objectsList);
        List<String> actual = lion.getFood();

        Assert.assertEquals(objectsList, actual);
    }

    @Test
    public void getKittensShouldReturnCorrectValue() {
        Lion lion = new Lion(feline);

        Mockito.when(feline.getKittens()).thenReturn(5);
        int actual = lion.getKittens();

        Assert.assertEquals(5, actual);
    }
}
