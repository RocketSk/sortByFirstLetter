import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class TestWordsCounter {

    @Test
    public void getWordsCountTest() {
        WordsCounter wordsCounter = new WordsCounter();
        String textHomeworkTask = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a Lamb just beginning to drink a little lower down.";
        String expected = "{a=6, at=1, beginning=1, but=1, down=1, drink=1, he=1, hillside=1, just=1, lamb=1, lapping=1, little=1, looking=1, lower=1, on=1, once=1, see=1, should=1, spring=1, time=1, to=1, up=1, upon=1, was=1, what=1, when=1, wolf=1}";

        String actual = wordsCounter.getWordsCount(textHomeworkTask);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWordsCountWithNumbersTest() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = "Hello/, /// hello Hello12714 hello";
        String expected = "{hello=4}";

        String actual = wordsCounter.getWordsCount(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void getWordsCountStateNullIllegalStateExceptionTest() {
        WordsCounter wordsCounter = new WordsCounter();
        String text = null;

        wordsCounter.getWordsCount(text);
    }
}
