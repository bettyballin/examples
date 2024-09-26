SET GLOBAL secure_file_priv = '';
LOAD DATA INFILE '/var/lib/mysql-files/myfile.csv'
INTO TABLE `test_files`
COLUMNS TERMINATED BY ',' ENCLOSED BY '\"'
LINES TERMINATED BY '\n';