# progress_button

The custom button for indicate progress in Android.

![sample](./image/sample.gif)

# Usage

```kotlin
if (isLoading) {
    binding.button.showProgress {
        textResourceId = R.string.submitting
    }
} else {
    binding.button.hideProgress {
        textResourceId = R.string.submit
    }
}
```
