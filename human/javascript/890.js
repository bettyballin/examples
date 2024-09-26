const request = {
  auth: {
    uid: 'some_uid'
  }
};

const userId = 'some_uid';

function isOwnerOfContent(){
  return request.auth.uid == userId;
}

console.log(isOwnerOfContent());