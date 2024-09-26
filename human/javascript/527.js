// Import the FileSaver library for the saveAs function
import { saveAs } from 'file-saver';

// Assume jQuery is already included
$(() => {
  $("#btn-save").click(function() {
    var text = $("#textarea").val();
    var filename = $("#input-fileName").val()
    var blob = new Blob([text], {type: "text/plain;charset=utf-8"});
    saveAs(blob, filename+".txt");
  });
});