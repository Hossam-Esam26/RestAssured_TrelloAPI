package TC_Pages.TC_CreateRequests;

import Pages.CreateRequests.CreateBoard;
import org.testng.annotations.Test;

public class TC_CreateBoard {
    @Test
    public void board()
    {
        new CreateBoard().createBoard();
    }
}
