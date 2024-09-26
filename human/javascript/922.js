exports.createInvoice = functions.firestore
    .document('invoices/{invoiceID}')
    .onCreate((snap, context) => {
      const invoiceData = snap.data();
      // perform desired operations ...
      console.log(invoiceData);
      return null;
    });