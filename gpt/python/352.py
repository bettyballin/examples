
from sqlalchemy import create_engine
from sqlalchemy.engine.url import URL
import pandas as pd
import getpass

CONSTANT_QUERY_STRING = "SELECT * FROM table1
