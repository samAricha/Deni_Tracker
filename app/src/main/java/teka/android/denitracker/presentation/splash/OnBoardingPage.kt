package teka.android.denitracker.presentation.splash

import androidx.annotation.DrawableRes
import teka.android.denitracker.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.amazed100,
        title = "Exhausted with Inconsistent Cash Flow?",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second : OnBoardingPage(
        image = R.drawable.perfect100,
        title = "Let us hold your hand to success!!",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third : OnBoardingPage(
        image = R.drawable.letsgo100,
        title = "Let's Go !!",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
