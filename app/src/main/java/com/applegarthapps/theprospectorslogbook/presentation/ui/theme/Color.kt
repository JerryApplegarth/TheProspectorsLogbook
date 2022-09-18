package com.applegarthapps.theprospectorslogbook.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)




//Light
val Primary = Color(0xff00695c)
val OnPrimary = Color(0xFFece0db)
val Secondary = Color(0xFf00897b)
val OnSecondary = Color(0xFF201a17)
val Surface = Color(0xFFece0db)
val OnSurface = Color(0xFF201a17)
val NewBackground = Color(0xFFB2E8E1)
val CardBackground = Color(0xFF89F47D)

//Dark
val DarkPrimary = Color(0xff003d33)
val DarkOnPrimary = Color(0xFFece0db)
val DarkSecondary = Color(0xff005b4f)
val DarkOnSecondary = Color(0xFFece0db)
val DarkPrimaryVariant = Color(0xFF4ebaaa)
val DarkOnPrimaryVariant = Color(0xFF201a17)
val DarkSurface = Color(0xFF005b4f)
val DarkOnSurface = Color(0xFFece0db)

val DarkNewBackground = Color(0xFF005b4f)

val Amber200 = Color(0xFFffe54c)
val Amber500 = Color(0xFFffb300)
val Amber700 = Color(0xFFc68400)
val LightAmber = Color(0xFFffecb3)

val MediumGreen = Color(0xFF3BAE06)

val Colors.cardBackground: Color
    @Composable
    get() = if (isLight) CardBackground else MediumGreen

val Colors.mediumGreen: Color
    @Composable
    get() = if (isLight) MediumGreen else MediumGreen

val Colors.newBackgroundColor: Color
    @Composable
    get() = if (isLight) NewBackground else DarkNewBackground

val Colors.fontColor: Color
    @Composable
    get() = if (isLight) DarkOnSecondary else DarkOnPrimary
