
$start_record = $_GET['page'];
$ids = array('pid_b', 'pid_l', 'pid_g');
$qMarks = str_repeat('?,', count($ids) - 1) . '?';

$limit = 50;
$offset = isset($start_record) ? (int)$
