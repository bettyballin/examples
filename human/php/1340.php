$data = array('column1' => 'value1', 'column2' => 'value2'); // sample data
$tab = 'your_table_name'; // sample table name

$keys = array();
$vals = array();

foreach($data as $key=>$val){
    $keys[] = $key;
    $vals[] = ":".$key;
}

$keys = "`".implode("`,`", $keys)."`";
$vals = implode(",", $vals);

$sql = "INSERT INTO `".$tab."`(".$keys.") VALUES (".$vals.")";

$dsn = 'mysql:host=localhost;dbname=your_database_name'; // sample dsn
$username = 'your_username'; // sample username
$password = 'your_password'; // sample password

$pdo = new PDO($dsn, $username, $password);

$prep_insert = $pdo->prepare($sql);
$prep_insert->execute($data);