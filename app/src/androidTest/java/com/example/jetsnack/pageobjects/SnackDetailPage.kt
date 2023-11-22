package com.example.jetsnack.pageobjects

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.jetsnack.R
import com.example.jetsnack.ui.snackdetail.SnackDetailTag
import com.example.jetsnack.utils.hasRole

class SnackDetailPage(private val composeTestRule: ComposeContentTestRule) {

    private val nameLabel = composeTestRule.onNodeWithTag(SnackDetailTag.NAME.name)
    private val tagLineLabel = composeTestRule.onNodeWithTag(SnackDetailTag.TAG_LINE.name)
    private val priceLabel = composeTestRule.onNodeWithTag(SnackDetailTag.PRICE.name, useUnmergedTree = true)

    private val increaseQuantityButton = composeTestRule.onNodeWithContentDescription("Increase")
    private val decreaseQuantityButton = composeTestRule.onNodeWithContentDescription(getString(R.string.label_decrease))

    fun assertNameIsDisplayedCorrectly(text: String) {
        with(nameLabel) {
            assertIsDisplayed()
            assertTextEquals(text)
        }

        nameLabel.assertIsDisplayed()
        nameLabel.assertTextEquals(text)
    }

    fun assertTagLineIsDisplayedCorrectly(text: String) {
        with(tagLineLabel) {
            assertIsDisplayed()
            assertTextEquals(text)
        }
    }

    fun assertPriceIsDisplayedCorrectly(text: String) {
        with(priceLabel) {
            assertIsDisplayed()
            assertTextEquals(text)
        }
    }

    fun clickOnIncreaseQuantity() {
        increaseQuantityButton.performClick()
    }

    fun clickOnDecreaseQuantity() {
        decreaseQuantityButton.performClick()
    }

    private fun getString(@StringRes id: Int): String {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        return context.resources.getString(id)
    }

    fun assertAddToCartButtonIsDisplayedCorrectly(text: String) {
        with(composeTestRule.onNode(hasRole(Role.Button))) {
            assertIsDisplayed()
            assertTextEquals(text)
        }
    }
}
