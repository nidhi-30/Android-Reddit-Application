# Android-reddit-Application

This application requires internet connection to load the feed. The application starts with the feed page with list of feeds. To load the new list, user can refresh it by “pull down” gesture. From this list after selecting any feed item, user can see the detail with an image and if image failed to load or feed does not contain image, then it will show default image.

To implement the application, I have used MVVM architecture and for the list of feed, I have used RecyclerView. Also, ViewBinding has been used. The navigation of fragment is handled using Navigation component. To fetch the List of feed from the API, retrofit library was used. To load the image from url, I have used Glide library. Here, I have set the orientation of screen as portrait.
