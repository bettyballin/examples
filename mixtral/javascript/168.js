let _start = 0;
let _n = 15;

function lazyLoadItems() {
  firebase.database().ref('items')
    .orderByChild('title')
    .limitToFirst(_n)
    .once("value", snapshot => {
      // Process the first page of results

      let lastItem = null;
      let promises = [];

      snapshot.forEach(childSnapshot => {
        if (!lastItem || childSnapshot.key > lastItem.key) {
          lastItem = childSnapshot;
        }

        // Process each item
      });

      _start += _n;

    }).then(() => {
      return firebase.database().ref('items')
        .orderByChild('title')
        .endAt(lastItem.key)
        .limitToFirst(_n + 1)
        .once("value", snapshot => {
          // Process the next page of results
        });
    });
}

lazyLoadItems();