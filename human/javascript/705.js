// Add new product
db.ref('products/public').push(publicData)
  .then((data) => {
    const key = data.key
    return key
  })
  .then((key) => {
    return db.ref('products/private').child(key).update(privateData)
      .then(() => key)
  })
  .then((key) => {
    // ...
  })
  .catch((error) => {
    console.error(error)
  })