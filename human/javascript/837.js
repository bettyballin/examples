firestore()
    .collection('Users')
    .where('userId', '==', user.uid)
    .get()
    .then(querySnapshot => {
        querySnapshot.forEach(doc => {
            console.log(doc.data());
        });
    })
    .catch(error => {
        console.error(error);
    });