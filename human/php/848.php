$query = "INSERT INTO users (`username`, `email`, `password`, `country`) VALUES( ?, ?, ?, ?)";
if ($stmt = mysqli_prepare($conn, $query) ) {
    $stmt->bind_param("ssss", $username, $email1, $hashed_password, $country );
    $stmt->execute();
    $stmt->close();
} else {
    ob_clean();
    header("Location: ".$_SERVER['HTTP_REFERER']);
    mysqli_close($conn);
    exit();
}