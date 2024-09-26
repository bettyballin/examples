import sqlite3

def check_email(email):
    conn = sqlite3.connect('your_database.db')
    cursor = conn.cursor()
    cursor.execute(f"SELECT email FROM credentials WHERE email = '{email}';")
    result = cursor.fetchone()
    conn.close()
    return result

email = "example@example.com"
result = check_email(email)
print(result)