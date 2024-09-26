
exports.postsQuery = function(req, res) {
    var queryString = req.params.query; // 'name=awesome'
    var properties = queryString.split('+');
    var criteria = {};

    properties.forEach(function(property) {
        var propParts = property.split('=');
        var key = propParts[0];
        var value = propParts[1];
        criteria[key] = new RegExp(value, 'i'); // {name: /awesome/i}
    });

    db.products.find(criteria, function (err, records) {
        if (err) {
            // Handle error
        } else {
            // Do stuff with records
        }
    });
