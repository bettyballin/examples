let ref = db.collection('users').doc(currentUser.uid)

ref.get().then(doc => {
  if (doc.exists) {
    console.log("Document data:", doc.data())
  } else {
    console.log("No such document!")
  }
}).catch(error => {
  console.error("Error getting document:", error)
})