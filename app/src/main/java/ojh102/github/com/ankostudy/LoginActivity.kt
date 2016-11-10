package ojh102.github.com.ankostudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Gravity
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivityUi().setContentView(this)
    }

    fun login(ui: AnkoContext<LoginActivity>, id: CharSequence?) {
        ui.doAsync {
            Thread.sleep(1000)

            activityUiThreadWithContext {
                if (!TextUtils.isEmpty(id.toString())) {
                    toast("Login!")
                    startActivity<MainActivity>()
                } else {
                    toast("Fail!")
                }
            }
        }
    }
}

class LoginActivityUi: AnkoComponent<LoginActivity> {

    override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)
            gravity = Gravity.CENTER_HORIZONTAL

            val id = textView {
                text = "hello anko"
                textSize = 20f
            }.lparams {
                topMargin = dip(16)
                bottomMargin = dip(16)
            }

            val edit = editText {
                hint = "input id"
            }

            button("Login") {
                onClick {
                    id.text = "${edit.text} login"
                    ui.owner.login(ui, edit.text)
                }
            }

        }
    }
}