package ir.mobilemaster.newscompose.presentation.chat

data class ChatModelState(
    var message: String = "",
    val messages: MutableList<String> = mutableListOf(),
)