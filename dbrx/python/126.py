import sqlite3
from passlib.hash import sha256_crypt
import getpass

def create_connection(db_file):
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        
    except sqlite3.Error as e:
        print(e)

    return conn


def register_user(conn, user):
    sql = '''INSERT INTO users(username, password) VALUES(?,?)'''
    cur = conn.cursor()
    
    hashed_password = sha256_crypt.hash(user['password'])
    cur.execute(sql, (user['username'], hashed_password))
    conn.commit()


def check_credentials(conn, username, password):
    cur = conn.cursor()

    sql_query = '''SELECT * FROM users WHERE username=?'''
    cur.execute(sql_query, (username,))
    user_data = cur.fetchall()
    
    if len(user_data) > 0:
        hashed_password = user_data[0][1]
        # Verify the password
        if sha256_crypt.verify(password, hashed_password):
            return True

    return False


def main():
    database = "test.db"

    conn = create_connection(database)

    cur = conn.cursor()
    cur.execute('''CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)''')
    conn.commit()

    register_user(conn, {'username': 'user1', 'password': 'pass123'})
    
    username = input("Enter your username: ")
    password = getpass.getpass(prompt="Enter your password: ")

    if check_credentials(conn, username, password):
        print(f"Welcome {username}!")
        
    else:
        print("Invalid credentials")

    conn.close()


if __name__ == '__main__':
    main()