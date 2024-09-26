// Retrieve products - Public
db.ref('products/public').orderByChild('isPublished').equalTo(true).once('value')
  .then((data) => {
    let publicData = data.val();
    console.log(publicData);
    // Do something with the data
  })
  .catch((error) => {
    console.error(error);
  });

// Retrieve products - Admin
db.ref('products').once('value')
  .then((data) => {
    let publicData = data.child('public').val();
    let privateData = data.child('private').val();
    console.log(publicData);
    console.log(privateData);
    // Do something with the data
  })
  .catch((error) => {
    console.error(error);
  });