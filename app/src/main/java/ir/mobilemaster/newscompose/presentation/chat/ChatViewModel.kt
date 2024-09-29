package ir.mobilemaster.newscompose.presentation.chat

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {
    val state = mutableStateOf(ChatModelState())

    fun onMessageChange(message: String) {
        state.value = state.value.copy(message = message)
    }

    fun onSendMessage() {
        state.value.messages.add(state.value.message)
        state.value = state.value.copy(message = "")
    }

}