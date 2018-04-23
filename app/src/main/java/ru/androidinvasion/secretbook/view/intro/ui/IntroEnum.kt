package ru.androidinvasion.secretbook.view.intro.ui

import ru.androidinvasion.secretbook.R

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 12.04.18
 */

enum class IntroEnum(val imageRes: Int, val title: Int, val description: Int) {
    FIRST(R.drawable.intro_one, R.string.intro_one_title, R.string.intro_one_description),
    TWO(R.drawable.intro_two, R.string.intro_two_title, R.string.intro_two_description),
    THREE(R.drawable.intro_three, R.string.intro_three_title, R.string.intro_three_description),
    FOUR(R.drawable.intro_four, R.string.intro_four_title, R.string.intro_four_description),
    FIVE(R.drawable.intro_five, R.string.intro_five_title, R.string.intro_five_description)
}