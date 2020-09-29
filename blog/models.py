from django.db import models

# Create your models here.

class Picture(models.Model):
    photo = models.ImageField()

    class Meta:
        verbose_name_plural = 'User_Image'

    def __str__(self):
        return self.photo.name
