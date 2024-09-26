csharp
[Authorize(Roles = "Producer,Editor")]
public ActionResult Details(int id) {
    // Only available to users who are Producers AND Editors
}