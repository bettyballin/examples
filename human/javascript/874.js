// Note: JavaScript is not used for database operations like creating views or granting roles.
// Instead, SQL is used. The provided code is in SQL.

// However, if you want to execute SQL queries from JavaScript, you can use a library like sqlite3 or a database driver.

// Assuming you're using a Snowflake database (due to the CREATE SECURE VIEW syntax), 
// you can use the Snowflake JavaScript driver.

const snowflake = require('snowflake-sdk');

const connection = snowflake.createConnection({
  user: 'your_username',
  password: 'your_password',
  account: 'your_account',
  database: 'your_database',
  schema: 'your_schema',
  warehouse: 'your_warehouse',
  role: 'your_role'
});

connection.connect((err, conn) => {
  if (err) {
    console.error('Unable to connect: ' + err.message);
  } else {
    console.log('Successfully connected to Snowflake.');
    const statement1 = `CREATE SECURE VIEW GLOBAL_VIEW AS SELECT * FROM Fruits_DB.Fruits_Schema.Fruits;`;
    const statement2 = `GRANT SELECT ON GLOBAL_VIEW TO ROLE GLOBAL_ROLE;`;

    conn.execute({
      sqlText: statement1,
      complete: (err, stmt, rows) => {
        if (err) {
          console.error('Failed to create view: ' + err.message);
        } else {
          console.log('View created successfully.');
          conn.execute({
            sqlText: statement2,
            complete: (err, stmt, rows) => {
              if (err) {
                console.error('Failed to grant access: ' + err.message);
              } else {
                console.log('Access granted successfully.');
              }
            }
          });
        }
      }
    });
  }
});