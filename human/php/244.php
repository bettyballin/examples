<?php
$config = parse_ini_file('config.ini', true);

$dbConfig = [
    'dsn' => sprintf(
        '%s:host=%s;port=%d;dbname=%s',
        $config['db_general']['driver'],
        $config['db_data_source_name']['host'],
        $config['db_data_source_name']['port'],
        $config['db_data_source_name']['dbname']
    ),
    'username' => $config['db_general']['user'],
    'password' => $config['db_general']['password'],
    'options' => [
        PDO::MYSQL_ATTR_INIT_COMMAND => $config['db_pdo_options']['MYSQL_ATTR_INIT_COMMAND'],
    ],
    'attributes' => [
        PDO::ATTR_CASE => constant($config['db_pdo_attributes']['ATTR_CASE']),
        PDO::ATTR_ERRMODE => constant($config['db_pdo_attributes']['ATTR_ERRMODE']),
        PDO::ATTR_EMULATE_PREPARES => $config['db_pdo_attributes']['ATTR_EMULATE_PREPARES'] === 'true',
    ],
];

try {
    $pdo = new PDO($dbConfig['dsn'], $dbConfig['username'], $dbConfig['password'], $dbConfig['options']);
    foreach ($dbConfig['attributes'] as $attribute => $value) {
        $pdo->setAttribute($attribute, $value);
    }
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
}