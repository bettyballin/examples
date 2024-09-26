const snowflake = require('snowflake-sdk');

// Replace with your account and credentials
const account = 'your_account';
const username = 'your_username';
const password = 'your_password';

// Create a connection
const conn = snowflake.createConnection({
  account: account,
  username: username,
  password: password,
  role: 'ACCOUNTADMIN'
});

// Connect to Snowflake
conn.connect((err, conn) => {
  if (err) {
    console.error(err);
    return;
  }

  // Create roles using Master_role
  conn.execute({
    sqlText: "CREATE ROLE REGION1_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "CREATE ROLE REGION2_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "CREATE ROLE GLOBAL_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  // Grant access to Database and Schema to these roles
  conn.execute({
    sqlText: "GRANT USAGE ON DATABASE Fruits_DB TO ROLE REGION1_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "GRANT USAGE ON SCHEMA Fruits_DB.Fruits_Schema TO ROLE REGION1_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "GRANT USAGE ON DATABASE Fruits_DB TO ROLE REGION2_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "GRANT USAGE ON SCHEMA Fruits_DB.Fruits_Schema TO ROLE REGION2_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "GRANT USAGE ON DATABASE Fruits_DB TO ROLE GLOBAL_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
    }
  });

  conn.execute({
    sqlText: "GRANT USAGE ON SCHEMA Fruits_DB.Fruits_Schema TO ROLE GLOBAL_ROLE;",
    complete: (err, stmt, rows) => {
      if (err) {
        console.error(err);
      }
      conn.destroy();
    }
  });
});