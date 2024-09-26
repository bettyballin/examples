import psycopg2

try:
    con = psycopg2.connect(database="postgres", user="postgres", password="balloons")
    c = con.cursor()
except Exception as e:
    print(f"Error connecting to DB: {e}")
finally:
    if 'c' in locals() and c is not None:
        c.close()
    if 'con' in locals() and con is not None:
        con.close()