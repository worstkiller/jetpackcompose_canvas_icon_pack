# Jetpack Compose Canvas API Demo App
We all know that Jetpack Compose has now reached the 1.0.0 release milestone. This is a huge change we can say for the future for the Android applications. 
Jetpack compose is reactive and more easy to develop and prototype something. 
Given the nice API's i tried the Jetpack Compose Canvas API's.

## 📱Screenshots
Black | White
------------ | -------------
<img src="https://github.com/worstkiller/jetpackcompose_canvas_icon_pack
/blob/master/screenshots/black_2.jpg" height="649" width="300">|<img src="https://github.com/worstkiller/jetpackcompose_canvas_icon_pack
/blob/master/screenshots/white_1.jpg.jpg" height="649" width="350">

## 🖥️ Tech
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Android Studio Arctic Fox 2020.3.1](https://android-developers.googleblog.com/2021/05/android-studio-arctic-fox-beta.html)


## 👩‍💻 How to install and Requirements
- Download the Project
- Open in Android Studio Arctic Fox 2020.3.1 or above for working with jetpack compose 1.0.0 version.
- Run in Android emulator or Device from Android Studio


## ✔️ Code Sample Sections
This much code creates an Instagram Icon, it's cool right 😃.
```kotlin
@Composable
fun instagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * 0.20f),
        )
    }
}
```

This code creates a youtube icon 🔥.
```kotlin
@Composable
fun getYoutubeIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val path = Path().apply {
            moveTo(size.width * .43f, size.height * .38f)
            lineTo(size.width * .72f, size.height * .55f)
            lineTo(size.width * .43f, size.height * .73f)
            close()
        }
        drawRoundRect(
            color = Color.Red,
            cornerRadius = CornerRadius(40f, 40f),
            size = Size(size.width, size.height * .70f),
            topLeft = Offset(size.width.times(.0f), size.height.times(.20f))
        )
        drawPath(color = Color.White, path = path)
    }
}    
```
There are much more in the code, all the are simple enough to follow and build. This shows the how easy the new Jetpack compose Canvas api's are to follow and play around.


## 💁 Feel Free to Reach for :
 * Suggestions
 * Code Improvements
 * Issues


## 🤝 Let's get Social
 * [Twitter](https://twitter.com/vikaskum09)
 * [LinkedIn](https://www.linkedin.com/in/vikaskumar09/)
 * [Behance](https://www.behance.net/vikaskum)
 * [Portfolio](https://vikas.dev)
 * [Email](mailto:contactvikasrajput@gmail.com)


## 🙏 Credits
- [Android Compose Docs](https://developer.android.com/jetpack/compose)

