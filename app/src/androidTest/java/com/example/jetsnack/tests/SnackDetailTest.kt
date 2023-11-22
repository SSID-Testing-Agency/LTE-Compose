package com.example.jetsnack.tests

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.jetsnack.pageobjects.SnackDetailPage
import com.example.jetsnack.ui.snackdetail.SnackDetail
import com.example.jetsnack.ui.theme.JetsnackTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SnackDetailTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val snackDetailPage = SnackDetailPage(composeTestRule)

    @Before
    fun before() {
        composeTestRule.setContent {
            JetsnackTheme {
                SnackDetail(1L) {
                    // Do nothing
                }
            }
        }
    }

    @Test
    fun snackDetail_contentIsDisplayedCorrectly() {
        snackDetailPage.assertNameIsDisplayedCorrectly("Cupcake")
        snackDetailPage.assertTagLineIsDisplayedCorrectly("A tag line")
        snackDetailPage.assertPriceIsDisplayedCorrectly("$2.99")
    }

    @Test
    fun snackDetail_assert_add_to_cart_button_is_displayed() {
        snackDetailPage.assertAddToCartButtonIsDisplayedCorrectly("ADD TO CART")
    }

    @Test
    fun snackDetail_assert_can_increase_decrease_quantity() {
        snackDetailPage.clickOnIncreaseQuantity()
        debugWait()

        snackDetailPage.clickOnDecreaseQuantity()
        debugWait()

        composeTestRule.onRoot().printToLog("HERE")
    }

    private fun debugWait() {
        /*
         * Cette fonction sert à dire à Compose d'attendre qu'il est terminé des actions de son côté.
         * Cela peut être une reconstruction de vue
         * ou un Idling Resources
         */
        composeTestRule.waitForIdle()

        /*
         * Il est déconseillé de faire un Thread.sleep, car cela bloque les mises à jours des vues et les appels d'api
         * Il faut préférer un composeTestRule.waitUntilXXXX
         * Mais là c'est plus à des fins de démos ou de développement du test
         */
        Thread.sleep(10000L)
    }
}
