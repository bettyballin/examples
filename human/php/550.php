<?php
$username = 'your_username';
$password = 'your_password';

$my_super_sha1_hash = 
sha1(
    sha1(
        substr(
            sha1($username)
            , 0
            , strlen($password) 
        )
    )
    .sha1(
        substr(
            sha1($password)
            , 0
            , 40-strlen($password)
        )
    )
);

print($my_super_sha1_hash);
?>