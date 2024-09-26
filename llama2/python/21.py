import sqlite3

def add(table, *args):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    statement = "INSERT INTO {} VALUES ({})".format(table, ','.join(['?' for _ in args]))
    cursor.execute(statement, args)
    conn.commit()
    conn.close()

# Example usage:
add('my_table', 'value1', 'value2', 'value3')