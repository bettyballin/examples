<?php

$myusername = $_POST['myusername'];   
$mypassword = $_POST['mypassword']; 

$mysqli = new mysqli("localhost", "root", "password", "DataBase");

// Check Connection
if ($mysqli->connect_errno) 
{
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

// Move to MySQL(i) as MySQL is now obslete and use Prepare statment for protecting against SQL Injection in better and easier way
$stmt = $mysqli->prepare('SELECT username FROM users WHERE username = ? and password = ?');

$stmt->bind_param("ss", $myusername, $mypassword);
//ss means expecting a variable of type string

$stmt->execute();

$stmt->store_result();
$count = $stmt->num_rows;

if($count > 0) 
{
    session_start();
    //Session Register is now history better go with
    $_SESSION['userid'] = $myusername;
    $_SESSION['mypassword'] = $mypassword;
    header("location:index.php");
}

else 
{
    echo "Wrong Username or Password";
}

?>