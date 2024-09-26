try:
    subdomain = row.find_all('td')[4].text
    subdomain = subdomain.replace("*.","")
    if subdomain not in self.foundURLsList:
        self.foundURLsList.append(subdomain)
except Exception as e:
    pass