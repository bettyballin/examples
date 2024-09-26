
$stmt = $conn->prepare('INSERT INTO modaltable (afirstname, alastname, aenrollmentno) VALUES (:afirstname, :alastname, :aenrollmentno)');
$stmt->bindValue(':afirstname', $afirstname);
$stmt->bindValue(':alastname', $alastname);
$stmt->bindValue(':aenrollmentno', $aenrollmentno, PDO::PARAM_INT);
$stmt->execute();

