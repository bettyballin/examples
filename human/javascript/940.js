const db = {
  find: (query) => {
    console.log(query);
  }
};

db.find({ "someProperty": {"$exists": true} });