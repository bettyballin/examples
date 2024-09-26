
const query = db.collection("mycollection")
  .where("user", "==", userId)
  .where("writeDate", ">", writeDate)
  .get()

