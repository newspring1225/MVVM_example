package kr.co.unioncomm.petid.view

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import kr.co.unioncomm.petid.R

class LoadingView(context: Context) : Dialog(context) {
    init {
        super.setContentView(R.layout.dialog_loading)

        setCancelable(false)

        window?.let {
            // 어두운 정도 설정하기
            val lp = it.attributes
            lp.dimAmount = 0.3f
            it.attributes = lp
            it.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        }
    }

    override fun onBackPressed() {}
}
