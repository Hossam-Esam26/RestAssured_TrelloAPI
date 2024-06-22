package TC_Pages.TC_CreateRequests;

import Pages.CreateRequests.CreateCard;
import org.testng.annotations.Test;

public class TC_CreateCard {

    @Test
    public void card()
    {
        new CreateCard().createCard();
    }
}
