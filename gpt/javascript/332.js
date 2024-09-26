
firebase.database().ref('/users/'+id).orderByValue().endAt(7000).once('value')

