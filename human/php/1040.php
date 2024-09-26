<?php
// require_once 'database.php'; Consider PDO in your database.php like below

$pdo = new PDO('mysql:host=dbhost;dbname=dbname', 'dbuser', 'dbpass'); // Provide your own credentials

$Username   =   $_POST['username']; #Username
$Password   =   $_POST['password']; #Password
$Password2  =   $_POST['password2'];#Password

if(empty($Password2)){ 
    echo "Please enter a valid confirmation password.";
    $msg .=" Please enter a valid confirmation password."; 
    echo 
            "<script>
            alert('$msg');
            window.location.href='../register.html';
            </script>";
            exit;
} 

if($Password !== $Password2){ 
        echo "Sorry, passwords do not match!";
        $msgPass = "Sorry, passwords do not match!";
        echo 
            "<script>
            alert('$msgPass');
            window.location.href='../register.html';
            </script>";
            exit;
}

function NewUser($pdo, $Username, $Password)
{
    $hashed_pass = password_hash($Password, PASSWORD_DEFAULT);
    $query = "INSERT INTO users (username,password) VALUES (:username, :password)";
    $data = $pdo->prepare($query);
    $data->execute(array(':username'=>$Username, ':password'=>$hashed_pass));
    if($data->rowCount() > 0)
    {
        return "YOUR REGISTRATION IS COMPLETED...";
    }
}

function SignUp($pdo, $Username, $Password)
{
    if(!empty($Username))   //checking the 'username' name which is from register.html, if is it empty or have some text
        {
                $query = ("SELECT * FROM users WHERE username = :username");
                $query = $pdo->prepare($query);
                $query->execute(array(':username'=>$Username));
                if($query->rowCount() == 0)
            {
                $msg = NewUser($pdo, $Username, $Password);
                echo $msg;
            }
            else {
                echo "SORRY...YOU ARE ALREADY REGISTERED USER...!";
                die();
            }

        }
}

if(isset($_POST['submit']))
{
    //User registration
    SignUp($pdo, $Username, $Password);
    echo "Your account has been created successfully. \n Thank you for joined us!";
    $msgSuccess = "Your account has been created successfully. \n Thank you for joined us!";
        echo 
            "<script>
            alert('$msgSuccess');
            window.location.href='../index.php';
            </script>";

}
?>