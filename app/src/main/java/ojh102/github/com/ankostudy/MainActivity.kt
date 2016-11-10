package ojh102.github.com.ankostudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUi().setContentView(this)
    }
}

class MainActivityUi : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout {
            textView {
                gravity = Gravity.CENTER
                text = "hi"
                textSize = 20f
            }
        }
    }
}
