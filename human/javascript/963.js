db.collection("users").doc(auth.currentUser.uid).get().then(res => {
  console.log("user:", res.data())
}).catch(error => {
  console.error("Error getting user:", error)
})