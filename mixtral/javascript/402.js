firestore.collection("Temp")
         .doc($('input:hidden[name=zyx]').val())
         .collection("TopUp")
         .doc('yourDocId')
         .get()
         .then(function(doc) {
             if (doc.exists) {
                 console.log("Document data:", doc.data());
             } else {
                 console.log("No such document!");
             }
         })
         .catch(function(error) {
             console.log("Error getting document:", error);
         });