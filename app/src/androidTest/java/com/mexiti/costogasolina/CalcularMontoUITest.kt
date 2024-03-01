package com.mexiti.costogasolina

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class CalcularMontoUITest {
    @get: Rule //leer algo
    val composeTestRule = createComposeRule()

   @Test
    fun CalcularMonto23_94_20l(){
        composeTestRule.setContent {
            CostoGasolinaTheme {
                CostGasLayout()
            }
        }
       composeTestRule.onNodeWithText("Ingresa precio por litro de gasolina")
           .performTextInput("23.94")
       composeTestRule.onNodeWithText("Litros")
           .performTextInput("20")

       val montoEsperado = NumberFormat.getCurrencyInstance().format(478.8)

       composeTestRule.onNodeWithText("Monto total: $montoEsperado").
       assertExists("No se encontro ningún nodo con el texto señalado")
    }
}