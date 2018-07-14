package com.alegs0501.broadcastintents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val message = p1!!.extras.getString("message")
        Toast.makeText(p0,"$message", Toast.LENGTH_SHORT).show()

        Toast.makeText(p0,"{${p1.action}}", Toast.LENGTH_SHORT).show()
    }
}