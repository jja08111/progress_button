package io.github.jja08111.progress_button

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec
import com.google.android.material.progressindicator.IndeterminateDrawable

class ProgressButton(
    context: Context,
    attrs: AttributeSet? = null
) : MaterialButton(context, attrs) {

    fun showProgress(params: ProgressParams.() -> Unit = {}) {
        val progressParams = ProgressParams(
            isEnabled = false,
            showProgress = true
        )
        progressParams.params()
        updateState(progressParams)
    }

    fun hideProgress(params: ProgressParams.() -> Unit = {}) {
        val progressParams = ProgressParams(
            isEnabled = true,
            showProgress = false
        )
        progressParams.params()
        updateState(progressParams)
    }

    private fun updateState(params: ProgressParams) {
        isEnabled = params.isEnabled
        text = params.textResourceId?.let { context.getText(it) }
        icon = if (params.showProgress) createProgressDrawable() else null
        iconGravity = params.iconGravity
    }

    private fun createProgressDrawable(): IndeterminateDrawable<CircularProgressIndicatorSpec> {
        val spec = CircularProgressIndicatorSpec(
            context, null, 0,
            com.google.android.material.R.style.Widget_Material3_CircularProgressIndicator_ExtraSmall
        )
        return IndeterminateDrawable.createCircularDrawable(context, spec)
    }
}