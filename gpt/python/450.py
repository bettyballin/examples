
class Role(db.Model):
    id = db.Column(db.Integer, primary_key=True)  # Corrected spelling here
    name = db.Column(db.String(40))

