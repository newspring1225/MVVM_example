package kr.co.unioncomm.petid.view

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import kr.co.unioncomm.petid.R

/**
 * Commonly used loading screen
 * Created by heejoo on 2017-04-26.
 */

class LoadingView(context: Context) : Dialog(context) {
    init {
        super.setContentView(R.layout.dialog_loading)

        setCancelable(false)

        // 어두운 정도 설정하기
        val lp = this.window!!.attributes
        lp.dimAmount = 0.3f
        window!!.attributes = lp

        // 백그라운드 투명
        window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
    }

    override fun onBackPressed() {}
}
