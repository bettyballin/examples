
$user_input = "O'Reilly";
$escaped_input = pg_escape_literal($user_input);
$query = "SELECT * FROM table WHERE column = $escaped_input";

