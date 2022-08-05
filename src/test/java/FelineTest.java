import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    public void eatMeatShouldReturnListObject() throws Exception {
        List <String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.doReturn(objectsList).when(feline).getFood(Mockito.anyString());
        List <String> actual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());

        Assert.assertEquals(objectsList, actual);
    }

    @Test (expected = Exception.class)
    public void getFoodShouldThrowExceptionWhenAnimalKindIncorrect() throws Exception {
        feline.getFood(Mockito.anyString());
    }

    @Test
    public void getFamilyShouldReturnCorrectFamilyName() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();

        Assert.assertEquals("values do not match", expected, actual);
    }

    @Test
    public void getKittensConstructorShouldVerifyAnyInt() {
        int kittensCount = 0;
        Mockito.doReturn(kittensCount).when(feline).getKittens(Mockito.anyInt());

        Assert.assertEquals("values do not match", kittensCount, feline.getKittens());
    }

    @Test
    public void getKittensShouldReturnCorrectKittensCount() {
        int expected = 1;
        int actual = feline.getKittens();

        Assert.assertEquals("values do not match", expected, actual);
    }
}
