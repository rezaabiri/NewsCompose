package ir.mobilemaster.newscompose.domain.usecases

import ir.mobilemaster.newscompose.domain.manager.LocalUserManager


class SaveAppEntry(
    private val localUserManager: LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}