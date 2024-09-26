firebase.database().ref('Validations/Usernames')
        .child(username)
        .once('value')
        .then(snapshot => {
          console.log(snapshot.val());
        })
        .catch(error => {
          console.error(error);
        });