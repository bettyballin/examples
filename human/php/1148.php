$dynamic_sql = array();
$parameters[':date_of_birth'] = $date_of_birth;

if(valid($email)) {
    $dynamic_sql[] = "email = :email";
    $parameters[':email'] = $email;
}

if(valid($website)) {
    $dynamic_sql[] = "website = :website";
    $parameters[':website'] = $website;
}

if(count($dynamic_sql) > 0) {
    $dynamic_sql = implode(', ', $dynamic_sql);
} else {
    $dynamic_sql = '';
}

$query = "UPDATE user
SET date_of_birth = :date_of_birth $dynamic_sql
WHERE
user_id = :user_id";

$parameters[':user_id'] = $user_id;

$stm = $db->prepare($query);
$stm->execute($parameters);