const topUpDocId = firestore.collection("Temp")
  .doc($('input:hidden[name=zyx]').val())
  .collection("TopUp").doc().id;

firestore.collection("Temp")
  .doc($('input:hidden[name=zyx]').val())
  .collection("TopUp")
  .doc(topUpDocId)
  .set({
    cash: $("#cashField").val(),
    topUp: $("#topUpField").val()
  }, { merge: true })
  .then((doc) => {
    // ...
  }).catch((error) => {
    showError(error.message);
    hideDevicesLoading();
  });