-- Create databases
CREATE DATABASE A;
CREATE DATABASE B;
CREATE DATABASE C;
CREATE DATABASE D;
CREATE DATABASE E;

-- Enable DB_CHAINING for each database
ALTER DATABASE A SET DB_CHAINING ON;
ALTER DATABASE B SET DB_CHAINING ON;
ALTER DATABASE C SET DB_CHAINING ON;
ALTER DATABASE D SET DB_CHAINING ON;
ALTER DATABASE E SET DB_CHAINING ON;