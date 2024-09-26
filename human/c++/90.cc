cpp
#include <iostream>
#include <string>
#include <mysql/mysql.h>

// Function to demonstrate SQL injection vulnerability
void vulnerableFunction(MYSQL* conn, const std::string& userInput) {
    std::string query = "SELECT * FROM users WHERE name = '" + userInput + "'";
    mysql_query(conn, query.c_str());
}

// Option #1: Use of Prepared Statements (Parameterized Queries)
void parameterizedQuery(MYSQL* conn, const std::string& userInput) {
    MYSQL_STMT* stmt;
    MYSQL_BIND bind;

    stmt = mysql_stmt_init(conn);
    mysql_stmt_prepare(stmt, "SELECT * FROM users WHERE name = ?", -1);

    bind.buffer_type = MYSQL_TYPE_STRING;
    bind.buffer = (void*) userInput.c_str();
    bind.length = userInput.length();
    bind.is_null = 0;

    mysql_stmt_bind_param(stmt, &bind);
    mysql_stmt_execute(stmt);
    mysql_stmt_close(stmt);
}

// Option #2: Use of Stored Procedures
void storedProcedure(MYSQL* conn, const std::string& userInput) {
    std::string query = "CALL sp_select_user('" + userInput + "')";
    mysql_query(conn, query.c_str());
}

// Option #3: Escaping all User Supplied Input
void escapedInput(MYSQL* conn, const std::string& userInput) {
    std::string escapedUserInput = mysql_real_escape_string(conn, userInput.c_str(), userInput.length());
    std::string query = "SELECT * FROM users WHERE name = '" + escapedUserInput + "'";
    mysql_query(conn, query.c_str());
}

int main() {
    MYSQL* conn;
    conn = mysql_init(0);
    mysql_real_connect(conn, "localhost", "root", "password", "database", 0, NULL, 0);

    std::string userInput;
    std::cout << "Enter user input: ";
    std::cin >> userInput;

    // Call the functions to test
    vulnerableFunction(conn, userInput);
    parameterizedQuery(conn, userInput);
    storedProcedure(conn, userInput);
    escapedInput(conn, userInput);

    mysql_close(conn);
    return 0;
}