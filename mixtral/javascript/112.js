Parse.Cloud.define("getNearbyObjects", async (request) => {
  const currentUser = request.user;

  // Create innerQuery to find nearby users
  var innerQuery = new Parse.Query(Parse.User);
  innerQuery.near("location", currentUser.get("location"));

  // Exclude the logged-in user from results
  if (currentUser) {
    innerQuery.notEqualTo("objectId", currentUser.id);
  }

  const MyObject = Parse.Object.extend(request.params.className || "MyObject");

  var query = new Parse.Query(MyObject);

  // Include the user pointer in results
  if (innerQuery) {
    query.include("user");

    // Matches users found by innerQuery
    query.matchesQuery("user", innerQuery);

    try {
      const objects = await query.find();

      return objects;

    } catch (error) {

      throw error;

    }
  }
});