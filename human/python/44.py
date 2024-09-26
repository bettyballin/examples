from datetime import datetime

class Article:
    def __init__(self):
        self.published = datetime.now()
        for propname in "year month day hour minute second".split():
            setattr(self, propname, getattr(self.published, propname))

# Test the class
article = Article()
print(article.year)
print(article.month)
print(article.day)
print(article.hour)
print(article.minute)
print(article.second)