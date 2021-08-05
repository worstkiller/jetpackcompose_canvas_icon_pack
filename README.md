# Jetpack Compose Canvas API Demo App
We all know that Jetpack Compose has now reached the 1.0.0 release milestone. This is a huge change we can say for the future of Android applications. 
Jetpack compose is reactive way of developing UI's and more easy to develop a full fledge application or prototype something. 
I was following the updates to Compose UI from some time and this time decided to do something with the Canvas. I can say I was never this much close to the Native Canvas Api's of the Android which i feel today after doing some experiments with it. I feel happy what i have achieved till now with it and excited to show you all. There is lot more to explore but this is what i have for now to share with you all.

## 📱Screenshots
Black | White
------------ | -------------
<img src="https://github.com/worstkiller/jetpackcompose_canvas_icon_pack/blob/master/screenshots/black_2.jpg" height="649" width="300">|<img src="https://github.com/worstkiller/jetpackcompose_canvas_icon_pack/blob/master/screenshots/white_1.jpg" height="649" width="300">

## 🖥️ Tech
- [Jetpack Compose 1.0](https://developer.android.com/jetpack/compose)
- [Android Studio Arctic Fox 2020.3.1](https://android-developers.googleblog.com/2021/05/android-studio-arctic-fox-beta.html)


## 👩‍💻 How to install and Requirements
- Download the Project
- Open in Android Studio Arctic Fox 2020.3.1 or above for working with jetpack compose 1.0.0 version.
- Run in Android emulator or Device from Android Studio


## ✔️ Code Sample Section
This much code creates an Instagram Icon, it's cool right 😃
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
There are much more in the code, all are simple enough to follow and create. This shows how easy the new Jetpack compose Canvas api's are to follow and play around.


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

