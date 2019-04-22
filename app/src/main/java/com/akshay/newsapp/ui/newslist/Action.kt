package com.akshay.newsapp.ui.newslist

import com.ww.roxie.BaseAction

/**
 * All the actions (intents) triggered due to user interaction
 */
sealed class Action : BaseAction {

    /* Indicates action to load news  */
    object LoadNews : Action() {
        override fun toString() = obfuscatedString()
    }
}