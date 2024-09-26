function del(x) {
  console.log("Delete File : " + filesListID[x - 1]);
  console.log("File : " + fileList[x - 1].fileno + " " + decrypt(fileList[x - 1].fileno));
  deleteDoc(doc(firestore, "property", filesListID[x - 1])).then(function() {
    var table = document.getElementById("userlist");
    table.innerHTML = "";
    userList();
    alert("File Deleted Successfully");
  }).catch((error) => {
    console.log("Error Deleting Property List: " + error);
  });
}