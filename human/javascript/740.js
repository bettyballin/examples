{
  ".read": "root.child('members/'+$room_id+'/'+auth.uid+joined).exists() && !data.exists() && newData.exists()",
  ".validate": "newData.hasChildren(['user', 'message', 'joined'])"
}