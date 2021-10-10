package com.aliucord.plugins.ui

import android.content.Context
import com.aliucord.plugins.utils.LinkReplacement
import com.google.android.material.card.MaterialCardView
import com.aliucord.views.TextInput
import com.aliucord.utils.DimenUtils
import com.discord.utilities.color.ColorCompat
import com.lytefast.flexinput.R

class ReplacerCard(ctx: Context) : MaterialCardView(ctx) {
    val regex: TextInput
    val toDomain: TextInput

    init {
        radius = DimenUtils.getDefaultCardRadius().toFloat()
        setCardBackgroundColor(ColorCompat.getThemedColor(ctx, R.b.colorBackgroundSecondary))
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        val p = DimenUtils.getDefaultPadding()

        val linearLayout = com.aliucord.widgets.LinearLayout(ctx).apply {
            regex = TextInput(ctx).apply { 
                hint = "From Regex"
            }
            toDomain = TextInput(ctx).apply { 
                hint = "To Domain"
            }
    
            addView(regex)
            addView(toDomain)
        }
        addView(linearLayout)
    }
}