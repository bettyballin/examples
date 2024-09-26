php
<?php
  $id = mysqli_real_escape_string($conn, $_GET['id']);
  $query = "SELECT username FROM users WHERE id = '$id'";
  $result = mysqli_query($conn, $query);

  if ($result) {
    while ($row = mysqli_fetch_assoc($result)) {
      echo $row['username'];
    }
  } else {
    echo "Error: " . mysqli_error($conn);
  }
?>