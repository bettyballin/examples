const someThreadId = 'your_thread_id_here'; // replace with your actual thread id
const querySnapshot = await firebase.firestore()
  .collection('messages')
  .where('threadId', '==', someThreadId)
  .get();