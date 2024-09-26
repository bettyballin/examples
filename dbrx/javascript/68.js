Here is the executable JavaScript code:


Parse.Cloud.afterSave(Parse.User, function(request) {
    var user = request.object;
    if (user.existed()) return; // only update new objects

    var randomPoint = generateRandomGeoPoint(user.get("location"));
    user.set("location", randomPoint);
    user.save(null, { useMasterKey: true });
});

function generateRandomGeoPoint(center) {
    var radiusInMeters = 100;
    var earthRadiusInKm = 6371;

    // Convert degrees to radians
    center.latitude *= Math.PI / 180.0;
    center.longitude *= Math.PI / 180.0; 

    // Generate random point within the circle around 'center' with radius 'radius'
    var u = Math.random();
    var v = Math.random();

    var w = radiusInMeters / earthRadiusInKm * (u + v);
    var t = 2 * Math.PI * v;

    var x = w * Math.cos(t);
    var y = w * Math.sin(t);

    // Convert radians back to degrees
    var newLat = (center.latitude + x) * 180.0 / Math.PI;
    var newLong = (center.longitude + y) * 180.0 / Math.PI;
    return new Parse.GeoPoint(newLat, newLong);
}