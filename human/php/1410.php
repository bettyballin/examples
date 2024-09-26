<?php
$rows = $s->fetchAll(PDO::FETCH_ASSOC);
$total_rows = $s->rowCount();
$page = (int) $_GET['page'] ?? 1;
$limit = 10; // assuming $limit is defined somewhere
$offset = ($page-1) * $limit;
$end = min($total_rows, $offset + $limit);

foreach ($rows as $row) {
?>
<h4><?php echo $row['id'];?></h4>
<p><?php echo $row['nama_kat'];?></p>
<hr>
<?php
}
?>