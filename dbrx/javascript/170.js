const mongoose = require("mongoose");
const mongoCredentials  = require("../protected/mongoCredential");

const URI = `mongodb+srv://${mongoCredentials.username}:${mongoCredentials.password}@firstcluster-eldi8.mongodb.net/culturapp?retryWrites=true&w=majority`;

const opts = {
    useNewUrlParser: true,
    useUnifiedTopology: true
};

mongoose.connect(URI, opts)
   .then(db => console.log("MongoDB is connected"))
   .catch(err => console.log(">> ERROR: ", err));

module.exports = mongoose;