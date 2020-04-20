package com.example.level5_example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val reminderRepo = ReminderRepository(application.applicationContext)

    val reminders: LiveData<List<Reminder>> = reminderRepo.getAllReminders()

    fun insertReminder(reminder: Reminder) {
        ioScope.launch {
            reminderRepo.insertReminder(reminder)
        }
    }

    fun deleteReminder(reminder: Reminder){
        ioScope.launch {
            reminderRepo.deleteReminder(reminder)
        }
    }
}