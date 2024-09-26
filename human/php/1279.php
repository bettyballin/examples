<html>
<head><title>Picture</title></head>
<body>
    <form enctype="multipart/form-data" action="" method="post">
        <input type="hidden" name="MAX_FILE_SIZE" value="600000" />
        <input type="file" name="users_image"/>
        <input type="submit" value="Upload">
    </form>
<?php

    if($_SERVER['REQUEST_METHOD'] === 'POST')
    {

        $image = file_get_contents($_FILES['users_image']['tmp_name']);
        //encrypt
        $cipher = "aes-128-cbc";
        $ivlen = openssl_cipher_iv_length($cipher);
        $iv = openssl_random_pseudo_bytes($ivlen);
        $key = openssl_random_pseudo_bytes(16); // Changed to 16
        $ciphertext = openssl_encrypt($image, $cipher, $key, $options=0, $iv);

        //add to DB
        $mysqli = new mysqli("localhost","testu","","test");
        $query = "INSERT INTO blobtbl(pics) VALUES (?)";
        $stmt = $mysqli->prepare($query);
        $stmt->bind_param("s", $ciphertext);
        $stmt->execute();
        $id = $mysqli->insert_id;

        //retrieve from DB
        $sql = "SELECT * FROM blobtbl WHERE id = ?";
        $stmt = $mysqli->prepare($sql);
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $res = $stmt->get_result();
        $row = $res->fetch_assoc();
        $newciphertext = $row['pics'];

        //decrpyt and display
        $img = openssl_decrypt($newciphertext, $cipher, $key, $options=0, $iv);
        echo '<img src="data:image/jpeg;base64,'.base64_encode($img).'"/>';
        echo "<br>Did it work?";
    }
?>
</body>
</html>