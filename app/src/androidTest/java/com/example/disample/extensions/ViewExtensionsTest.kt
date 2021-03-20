package com.example.disample.extensions

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.disample.common.extension.gone
import com.example.disample.common.extension.show
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ViewExtensionsTest : Spek({
    //Relaxed mockも指定できそう
    val view by memoized {
        mockk<View>(relaxed = true)
    }

    //関係ないものが呼ばれていない場合の確認の例のため、仮モックする
    val noRelationshipView by memoized {
        mockk<ConstraintLayout>(relaxed = true)
    }

    describe("View_Extensions.kt#show") {
        context("normal pattern") {
            it("view is visible") {
                view.show()
                //1度呼ばれていることを確認
                verify {
                    view.visibility = View.VISIBLE
                }
                //呼ばれていないこと確認
                confirmVerified(noRelationshipView)
            }
        }

    }

    describe("View_Extensions.kt#gone") {
        context("normal pattern") {
            it("view is gone") {
                val result = view.gone()
                verify {
                    view.visibility = View.GONE
                }
            }
        }
    }
})