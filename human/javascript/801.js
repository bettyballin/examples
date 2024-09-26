var db = firebase.firestore();
var ref = db.collection("your-collection-name");
var user_id = "your-user-id";

ref.where("access", "array-contains-any", [user_id, user_id+":R"]).get().then(function(querySnapshot) {
  querySnapshot.forEach(function(doc) {
    console.log(doc.data());
  });
});