
// Cloud Code
Parse.Cloud.define("findNearbyUsers", async (request) => {
  const currentUser = request.user;
  const userGeoPoint = currentUser.get("location");

  const innerQuery = new Parse.Query(Parse.User);
  innerQuery.near("location", userGeoPoint);
  innerQuery.notEqualTo("objectId", currentUser.id);
  
  // Limit the data that is being returned
  innerQuery.select("objectId"); // Only return the user IDs, not the locations

  const query = new Parse.Query(MyObject);
  query.matchesQuery("user", innerQuery);

  // You can include other fields from MyObject if needed
  query.select("someField", "anotherField");

  try {
    const results = await query
