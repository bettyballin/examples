
foreach($stmt as $row){
  echo htmlspecialchars($row['column_name'], ENT_QUOTES, 'UTF-8');
