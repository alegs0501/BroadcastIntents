package com.alegs0501.broadcastintents

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//Broadcast Intents & Receivers
/*
    -Generic messages from system
    * Broadcast Intents
        -sendBroadcast() // When activity does not  wait response
        -sendStickyBroadcast()
        -sendOrderedBroadcast()

    * How to create a Broadcast Intent
        val intent = Intent()
        intent.action = "main_package_name.something "
        intent.putExtra("key", "value")
        *optional
            [intent.flags = intent.FLAG_INCLUDE_STOPPED_PACKAGES]
        sendBroadcast(intent)

    * Broadcast Receivers
        To response a Broadcast Intent, use onReceive()
        1- put Listener on code
        2- put Listener on Manifest
        App has 5 seconds to response
 */

/*
    1- create class BroadcastReceiver
        class myReceiver: BroadcastReceiver()
            override fun onReceive(context: Context, intent: Intent){
            delete throw then implement}

    2-Create Listener in manifest
        <application.....
        <receiver android:name = "myReceiver">
        <intent-filter>
        <action android:name = "main_package_name.something">
        </action>
        </intent-filter>
        </receiver>
        </application>

    3- android 8.0
        val filter = IntentFilter()
        filter.addAction("main package name")
        val receiver: MyReceiver = MyReceiver()
        registerReceiver(receiver, filter)
        unregisterReceiver(receiver)

 */
class MainActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver()
    }

    //to receive Broadcast
    fun registerReceiver(){
        val filter = IntentFilter()
        filter.addAction("com.alegs0501.broadcastintents.algoaqui")

        //Theses are broadcast from system
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")


        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    //To send broadcast
    fun sendBroadcast(view: View){
        //Launch a broadcast Intent to system
        val intent = Intent()
        intent.action = "com.alegs0501.broadcastintents.algoaqui"
        intent.putExtra("message", "Este es el mensaje del Broadcast")
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }

}
