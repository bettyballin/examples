<script>
var untrustedURL = escapeHTML("<%=HttpUtility.JavaScriptEncodeString(usersUrl)%>");
</script>

<script>
  function escapeHTML(str) {
    return str.replace(/&/g, '&amp;')
              .replace(/</g, '&lt;')
              .replace(/>/g, '&gt;')
              .replace(/"/g, '&quot;')
              .replace(/'/g, '&#039;');
  }
  var usersUrl = "https://example.com/users";
  var untrustedURL = escapeHTML(usersUrl);
  console.log(untrustedURL);
</script>