
function del(x){
  // Assuming `x` is 1-based index, and arrays are 0-based.
  const documentId = filesListID[x-1]; 
  console.log("Delete File : " + documentId);
  console.log("File : " + fileList[x-1].fileno + " " + decrypt(fileList[x-1].fileno));
  
  deleteDoc(doc(firestore, "property", documentId)).then( function(){
      var table = document.getElementById("userlist");
      table.innerHTML = "";
      userList();
      alert("File Deleted Successfully");
  }).catch((error) => {
    console.log("Error Deleting Property List: " + error);
  });
}

