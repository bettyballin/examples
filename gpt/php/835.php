
$stm1 = $db->prepare("UPDATE user SET rep = rep + 15 WHERE id = ?");
$stm1->execute(array($author_id));

