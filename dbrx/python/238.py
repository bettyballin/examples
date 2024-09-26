from sqlalchemy import create_engine
import urllib.parse
import pandas as pd
import getpass

CONSTANT_QUERY_STRING = "SELECT * FROM table1 WHERE user_id=%s AND password=%s;"
DB_URI = 'postgresql://{db_user}:{db_password}@postgres.acme.com:5432/acme_db'

class DbConnector:
    def __init__(self, db_uri):
        self.uri = db_uri

    def get_data(self, query, params):
        engine = create_engine(self.uri)
        df = pd.read_sql_query(query, con=engine, params=params)
        engine.dispose()
        return df

if __name__ == "__main__":
    userid = input('User: ')
    password = getpass.getpass('Password for {}:'.format(userid))
    db_connector = DbConnector(DB_URI.format(db_user=userid, db_password=password))
    result_df = db_connector.get_data(CONSTANT_QUERY_STRING, (userid, password))

    if result_df is not None and not result_df.empty:
        print("Here's your data!")
        print(result_df)