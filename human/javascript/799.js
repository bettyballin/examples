const ref = db.collection("your-collection-name");
const user_id = "your-user-id";

ref.where("access", "array-contains", user_id).get()
  .then(querySnapshot => {
    querySnapshot.forEach(doc => {
      console.log(doc.data());
    });
  })
  .catch(error => {
    console.error(error);
  });