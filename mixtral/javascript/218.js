function isBrandLocked(brandAddress) {
  return new Promise((resolve, reject) => {
    firebase.database().ref(`brand/${brandAddress}/`)
      .once('value')
      .then(snapshot => {
        let brand = snapshot.val() || {};
        resolve(!brand.unlocked);
      })
      .catch((error) => reject("Error fetching data: " + error));
  });
}

// Example usage:
isBrandLocked("someBrandAddress")
  .then(result => console.log(result))
  .catch(error => console.error(error));