package p900;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.*;

public class p900Test extends WebDriverTestBase{
    @Test
    public void openPage() {
        open("http://p900.com.ua");
        $("body").shouldBe(Condition.visible);
    }
}
