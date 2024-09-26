// Add this line to make the code executable in a browser environment
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div id="user_roles">["admin", "moderator"]</div>
<a id="linkId" href="#">Link to hide</a>

<script>
function hasRole(role) {
  const currentUserRoles = JSON.parse($('#user_roles').text());
  return currentUserRoles && currentUserRoles.includes(role);
}

if (!hasRole('admin')) {
  $('#linkId').hide();
}
</script>