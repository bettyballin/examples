// This is a Firestore security rule, not a JavaScript executable code.
// However, I will provide the equivalent JavaScript code for the given Firestore security rule:

const db = admin.firestore();

db.collection('posts').get()
  .then(querySnapshot => {
    querySnapshot.forEach(doc => {
      const postID = doc.id;
      const publishDate = doc.data().publishDate;
      const requestTime = new Date().getTime() / 1000; // convert to seconds

      if (publishDate.seconds <= requestTime) {
        console.log(`Post ${postID} is readable`);
      } else {
        console.log(`Post ${postID} is not readable`);
      }
    });
  })
  .catch(error => {
    console.error(error);
  });