package app.lawnchair.qsb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.widget.ImageButton
import androidx.core.view.isVisible
import app.lawnchair.preferences2.PreferenceManager2
import app.lawnchair.qsb.providers.QsbSearchProvider
import com.android.launcher3.R

@SuppressLint("AppCompatCustomView")
class AssistantIconView(context: Context, attrs: AttributeSet?) : ImageButton(context, attrs) {

    init {
        val provider = LawnQsbLayout.getSearchProvider(context, PreferenceManager2.getInstance(context))

        val intent = getVoiceIntent(provider, context)
        isVisible = intent != null

        setOnClickListener {
            context.startActivity(intent)
        }
    }

    fun setIcon(isGoogle: Boolean, themed: Boolean) {
        clearColorFilter()

        val iconRes = if (isGoogle) R.drawable.ic_mic_color else R.drawable.ic_mic_flat
        val themingMethod = if (isGoogle) ThemingMethod.THEME_BY_LAYER_ID else ThemingMethod.TINT

        setThemedIconResource(
            resId = iconRes,
            themed = isGoogle && themed || !isGoogle,
            method = themingMethod,
        )
    }

    companion object {

        fun getVoiceIntent(
            provider: QsbSearchProvider,
            context: Context,
        ): Intent? {
            val intent = if (provider.supportVoiceIntent) provider.createVoiceIntent() else null

            return if (intent == null || !LawnQsbLayout.resolveIntent(context, intent)) {
                null
            } else {
                intent
            }
        }
    }
}
