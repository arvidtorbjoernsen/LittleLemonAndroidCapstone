package com.example.littlelemonandroidcapstone.presentation.component

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.littlelemonandroidcapstone.ui.theme.Charcoal
import com.example.littlelemonandroidcapstone.ui.theme.KarlaFont


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextInput(
    modifier: Modifier = Modifier,
    text: String,
    capitalize: Boolean = false,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var capitalizeInput = KeyboardCapitalization.None
    if (capitalize) {
        capitalizeInput = KeyboardCapitalization.Words
    }
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Charcoal,
            focusedBorderColor= Charcoal,
            focusedLabelColor= Charcoal,
            unfocusedBorderColor = Charcoal,
            unfocusedLabelColor = Charcoal,
        ),
        textStyle = TextStyle.Default.copy(fontSize = 20.sp, fontFamily = KarlaFont),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            capitalization = capitalizeInput,
            keyboardType = keyboardType,
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}