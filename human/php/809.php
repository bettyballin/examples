<?php
$mysql_username = 'username'; // for DB
$mysql_password = 'password'; // for DB

$dbh = new PDO('mysql:host=localhost;dbname=database_name', $mysql_username, $mysql_password);

/*
$username = $_POST['username'];
$password = $_POST['password'];
*/

$username = "username";
$password = "mypassword";

$sql = "SELECT * FROM table_name WHERE name=:username";
$statement = $dbh->prepare($sql);
$statement->bindValue(':username',$username,PDO::PARAM_STR);

if($statement->execute())
{
    if($statement->rowCount() == 1)
    {
        $row = $statement->fetch(PDO::FETCH_ASSOC);

        if (crypt($password, $row['pass']) === $row['pass'])
        {
            $username = $row['name'];
            $email = $row['email'];

            echo "Stage 1";

            echo "<hr noshade size=\"1\">";

            echo "Hello " .$username;

            exit;
        }
        else
        {
            // include "error_login.php";

            echo "Stage 2 - ERROR";

        }
    }
    else
    {
       // include "error_login.php";

        echo "Stage 3 error";
    }
}
?>