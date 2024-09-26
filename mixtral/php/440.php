<?php
// Prepare the SQL statement
if ($stmt = mysqli_prepare($postcon, "INSERT INTO posts (title, descr, imgname, tag) VALUES (?, ?, ?, ?)")) {
    // Bind variables to their placeholder in the statement
    mysqli_stmt_bind_param($stmt, 'ssss', $title, $description, $fileNameNew, $tag);

    if (!mysqli_stmt_execute($stmt)) {
        echo "Error: " . mysqli_error($postcon) . "<br>";
    }

    // Close the statement
    mysqli_stmt_close($stmt);
}
?>