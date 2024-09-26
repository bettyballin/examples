SELECT * 
FROM `menubalk` 
WHERE `webnr` LIKE CONCAT('%', '$webnr', '-') 
AND `hoofdgroep` = ? 
ORDER BY `naamt1` ASC;

php
$stmt = $pdo->prepare($sql);
$stmt->execute([$_GET['id']]);
$result = $stmt->fetchAll();