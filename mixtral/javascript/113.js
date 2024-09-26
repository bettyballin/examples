const Messages = Parse.Object.extend("Messages");
let message = new Messages();
message.set("sender", Parse.User.current());
message.set("receiver", anotherUser);
message.set("subject", "foo");
message.set("body", "bar");

// Save the object
message.save()
  .then((result) => {
    console.log('Success:', result);
  })
  .catch((error) => {
    console.error('Error:', error);
  });