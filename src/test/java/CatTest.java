import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundShouldReturnCorrectString() throws Exception {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals("values do not match", expected, actual);
    }
    @Test
    public void getFoodShouldReturnCorrectListObject() throws Exception {
        Cat cat = new Cat(feline);

        List<String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.when(feline.eatMeat()).thenReturn(objectsList);
        List<String> actual = cat.getFood();

        Assert.assertEquals(objectsList, actual);
    }
}
