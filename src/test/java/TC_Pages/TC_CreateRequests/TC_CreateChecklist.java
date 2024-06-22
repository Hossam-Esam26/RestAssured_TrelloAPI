package TC_Pages.TC_CreateRequests;

import Pages.CreateRequests.CreateChecklist;
import org.testng.annotations.Test;

public class TC_CreateChecklist {

    @Test
    public void checklist()
    {
        new CreateChecklist().createChecklist();
    }
}
