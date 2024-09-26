
   db.collection("chatRooms").doc(_roomId).collection("messages").get().then(msg => {
     console.log(msg);
   })
   
