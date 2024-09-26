csharp
public class ThingController : Controller
{
    public ActionResult EditThing(int ID)
    {
        ThingRepository repository = new ThingRepository();

        if (!repository.UserHasAccess(ID))
            return View("NotAuthorized");

        // Do stuff here
        return View();
    }
}

public class ThingRepository
{
    public bool UserHasAccess(int ID)
    {
        // Implement logic to check user access
        // For demo purposes, always returns true
        return true;
    }
}