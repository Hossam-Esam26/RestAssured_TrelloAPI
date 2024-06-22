package TC_Pages.TC_DeleteRequests;

import Pages.DeleteRequests.DeleteCard;
import org.testng.annotations.Test;

public class TC_DeleteCard {

    @Test
    public void deleteCard()
    {
        new DeleteCard().card();
    }
}
