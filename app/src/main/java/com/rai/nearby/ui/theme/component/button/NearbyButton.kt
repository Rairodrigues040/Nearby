package com.rai.nearby.ui.theme.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rai.nearby.R
import com.rai.nearby.ui.theme.Typography
import com.rocketseat.nlw.nearby.ui.theme.GreenBase

@Composable
//consegue modificar o formato do botão
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    //@DrawableRes possibilita pegar apenas da pasta res
    // Int -> identificador do que a gente vai pegar
    @DrawableRes iconRes: Int? = null,
    //ação de clicar no botão
    onClick: () -> Unit
) {

    Button(
        modifier = modifier.heightIn(min = 56.dp),
//shape = RoundedCornerShape(16.dp) - deixa o botão mais quadrado
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        ),
        onClick = onClick
    ) {
// Row -> Permite controlar a visibilidade na horizontal
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(painter = painterResource(id = iconRes), contentDescription = "Ícone do Botão")
            }
            //text?.let - verifica se o valor que está dentro das chaves é nulo
            //O método uppercase deixa o texto com letras maiúsculas
            text?.let { Text(text = text.uppercase(), style = Typography.labelLarge) }
        }
    }

}

@Preview
@Composable
private fun NearbyButtonPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(), text = "Confirmar", iconRes = R.drawable.ic_scan
    ) {}

}


@Preview
@Composable
private fun NearbyButtonNoIconPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar"
    ) {}

}


@Preview
@Composable
private fun NearbyNoTextButtonPreview() {
    NearbyButton(
        modifier = Modifier,
        iconRes = R.drawable.ic_arrow_left
    ) {}

}