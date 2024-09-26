import models

sign_url = 'https://i.imgur.com/abc123.jpg'
# becomes
direct_link = sign_url + '.jpg'

class Sign(models.Model):
    # ...
    sign_url = models.CharField(max_length=250)
    direct_image_url = models.CharField(max_length=250)

    def save(self, *args, **kwargs):
        self.direct_image_url = f"{self.sign_url}.jpg"
        super().save(*args, **kwargs)