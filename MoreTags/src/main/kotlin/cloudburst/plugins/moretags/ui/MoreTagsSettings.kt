package cloudburst.plugins.moretags.ui

import com.aliucord.fragments.SettingsPage
import android.view.View
import android.view.Gravity

import com.aliucord.Utils
import com.discord.views.CheckedSetting
import com.aliucord.widgets.LinearLayout
import com.aliucord.api.SettingsAPI
import com.aliucord.utils.MDUtils
import android.widget.TextView
import com.lytefast.flexinput.R

class MoreTagsSettings(private val settings: SettingsAPI) : SettingsPage() {
    override fun onViewBound(view: View) {
        super.onViewBound(view)

        setActionBarTitle("MoreTags")
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Colorize", "Colorize tags acording to role colors.").apply {
            val key = "MoreTags_Colorize"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Webhook", "Rename \"BOT\" to \"WEBHOOK\" or \"SERVER\" when appropriate.").apply {
            val key = "MoreTags_Webhook"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "System", "Rename \"BOT\" to \"SYSTEM\" system messages (eg. Clyde) .").apply {
            val key = "MoreTags_System"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Bot Only", "Wheter to display bots with admin permissions as \"BOT\" or \"BOT • ADMIN\".").apply {
            val key = "MoreTags_BotOnly"
            isChecked = settings.getBool(key, false)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Owner", "Show \"OWNER\" tags.").apply {
            val key = "MoreTags_Owner"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Administrator", "Show \"ADMIN\" tags.").apply {
            val key = "MoreTags_Admin"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Staff", "Show \"STAFF\" tags.").apply {
            val key = "MoreTags_Staff"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(Utils.createCheckedSetting(view.context, CheckedSetting.ViewType.SWITCH, "Moderator", "Show \"MOD\" tags.").apply {
            val key = "MoreTags_Mod"
            isChecked = settings.getBool(key, true)
            setOnCheckedListener {
                settings.setBool(key, it)
            }
        })
        addView(TextView(view.context, null, 0, R.i.UiKit_TextView).apply { 
            text = MDUtils.render("""
            ***OWNER***: Owner of the server (duh)

            ***ADMIN***: Has the administrator permission

            ***STAFF***: Has one of the following permissions:
            - Manage Server
            - Manage Channels
            - Manage Roles

            ***MOD***: Has one of the following permissions
            - Kick Members
            - Ban Members
            - Manage Messages

            ***SERVER***: Message that was crossposted from another server using

            ***WEBHOOK***: Message that was sent by a webhook

            ***SYSTEM***: Sender is a system user (eg. Clyde)
            """.trimIndent())
            
            
        })
    }
}
