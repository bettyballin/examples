import random
import sys
from google.appengine.ext import db
from models import Session  # Assuming Session is a model defined in models.py

random.seed()
id = None
while id is None or Session.get_by_id(id):
    id = random.randrange(sys.maxsize)
seshKey = db.Key.from_path('Session', id)
session = Session(key=seshKey)