<?php
session_start();

// Check if the session variable 'user_id' exists or not.
if (!isset($_SESSION['user_id'])) {
    // If user is NOT logged in show this header with Login Form and exit.
?>
<div class="topnav">
  <a href="#home">Home</a>
  <?php
        echo "<button onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">Sign Up</button>";
    ?>
  <div id="id01" class="modal">

    <!-- Modal Content -->
    <form action="/action_page.php" method="post">
      Username:<br>
      <input type="text" name="username" value="">
      <br>
      Password:<br>
      <input type="password" name="pwd" value="">
      <br><br>
      <input type="submit" value="Log In">
    </form>

  </div>
</div>
<?php
} else {
    // If user is logged in show this header with Logout button.
?>
<div class="topnav">
  <a href="#home">Home</a>
  <?php echo "<button onclick=\"document.getElementById('id02').style.display='block'\" style=\"width:auto;\">Sign Out</button>"; ?>
  <!-- Modal content -->
  <div id="id02" class="modal">

    Are you sure?<br>

    <form action="/action_page.php" method="post">
      Username:<br>
      <?php echo $_SESSION['username']; ?><br><br>
      Password:<br>
      ****<br><br>
      <input type="submit" value="Sign Out">
    </form>
  </div>
</div>
<?php
}
?>