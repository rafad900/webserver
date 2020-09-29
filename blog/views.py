from django.shortcuts import render
from django.http import JsonResponse
from blog.models import Picture
from django.http import FileResponse
from django.conf import settings
from django.views.decorators.csrf import csrf_exempt

posts = [
	{
		'author': 'CoreyMS',
		'title' : 'Blog post 1', 
		'content' : 'First opst content',
		'date_posted' : 'August 27, 2018'
	},
	{
		'author': 'Jane Doe',
		'title' : 'Blog post 2',
		'content': 'Second post content',
		'date_posted': 'august 28, 2018'
	}
]



def home(request):
	context = {
		'posts': posts,
        'pic': Picture.objects.first()
	}
	return render(request, 'blog/home.html', context)

def about(request):
	return render(request, 'blog/about.html')

def json(request):
    return JsonResponse( {'posts': posts} )

def image(request):
    return FileResponse(open(settings.MEDIA_ROOT + '/youfoundme.jpg', 'rb'))

@csrf_exempt
def postrequest(request):
    print ("This is the request values: ", end='')
    print(request)
    print(request.body)
    print(request.scheme)
    print(request.path)
    print(request.method)

    return JsonResponse( {'value': "It got it"} )
