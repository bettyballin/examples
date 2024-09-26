<?php
$data = 'This is a comment.'; // replace with your data

echo '<script>
var comment = document.createElement("div");
comment.appendChild(document.createTextNode("'.$data.'"));
var list = document.getElementById("comment_list");
list.insertBefore(comment, list.firstChild);
</script>';
?>