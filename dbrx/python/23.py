import os

if __name__ == "__main__":
    db_user = os.environ.get('DB_USER')
    db_password = os.environ.get('DB_PASSWORD')
    print(f"DB User: {db_user}")
    print(f"DB Password: {db_password}")