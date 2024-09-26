const db = firebase.firestore();
const ref = db.collection("your-collection-name");
const user_id = "your-user-id";

ref.where("access", "array-contains-any", [user_id, user_id+":R", "All_R"]).get()
  .then(querySnapshot => {
    querySnapshot.forEach(doc => {
      console.log(doc.data());
    });
  })
  .catch(error => {
    console.error(error);
  });