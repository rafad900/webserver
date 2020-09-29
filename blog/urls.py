from django.urls import path
from django.conf.urls.static import static
from django.conf import settings
from . import views

urlpatterns = [
    path('', views.home, name="blog-home"),
	path('about/', views.about, name='blog-about'),
    path('json/', views.json, name='blog-json-response'),
    path('image/', views.image, name='blog-image'),
    path('post/', views.postrequest, name='blog-post')
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
