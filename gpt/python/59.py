
import sqlite3

def is_valid_table_name(table_name):
    # Implement a check to ensure the table name is valid and not malicious
    return True  # This should be replaced with actual validation logic

def add(cursor, table, *args):
    if not is_valid_table_name(table):
        raise ValueError("Invalid table name")

    placeholders = ', '.join('?' for _ in args)
    statement = f"INSERT INTO {table} VALUES ({placeholders})"
    cursor.execute(statement, args)

# Usage
