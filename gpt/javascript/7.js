
function try_show_result() {
  var code = $("#try-input").val();
  if (code !== "") {
    var iframe = document.getElementById('sandbox');
    iframe = iframe.contentWindow || (iframe.contentDocument.document || iframe.contentDocument);

    iframe.document.open();
    iframe.document.write(code);
    iframe.document.close();
 
