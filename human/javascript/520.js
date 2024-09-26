firebase.database().ref('items')
    .orderByChild('title')
    .startAt('a')
    .endAt('z')
    .limitToFirst(15).on('value', function(snapshot) {
        console.log(snapshot.val());
    });