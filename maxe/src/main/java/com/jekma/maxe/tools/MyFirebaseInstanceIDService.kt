package com.jekma.maxe.tools

//import com.google.firebase.messaging.FirebaseMessagingService
//import com.google.firebase.messaging.RemoteMessage


//class MyFirebaseInstanceIDService:FirebaseMessagingService(){
//
//    override fun onMessageReceived(p0: RemoteMessage) {
//        super.onMessageReceived(p0)
//        Log.e("fcm", "onMessageReceived")
//        Log.i("我是內容", p0.notification?.body)
////        Log.i("fcm2", refreshedToken)
//        Log.d("我是標題", p0.notification?.title);
//
//        val content:String = p0.notification?.body.toString();
//        val title:String = p0.notification?.title.toString();
//        NotificationTST(title,content)
//
//    }
//
//    private fun NotificationTST(title:String,content: String) {
//        lateinit var notificationManager: NotificationManager
//
//        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        val intent = Intent(this, Welcome::class.java)
//        val pendingIntent =
//                PendingIntent.getActivity(
//                        this,
//                        0,
//                        intent,
//                        PendingIntent.FLAG_UPDATE_CURRENT
//                )
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            showNotificationAboveOreo(title,content,pendingIntent,notificationManager)
//        } else {
//            showNotificationBelowOreo(title,content,notificationManager)
//        }
//
//
//
//
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun showNotificationAboveOreo(title:String , content:String ,pendingIntent: PendingIntent,notificationManager:NotificationManager) {
//
////        var aaa = BitmapFactory.decodeResource(resources, R.drawable.ic_star_black_24dp)
//
//        val builder =
//                NotificationCompat.Builder(this, "channel01")
//                        .setSmallIcon(R.drawable.ic_launcher_foreground)
//                        .setLargeIcon(BitmapFactory.decodeResource(resources ,R.drawable.ic_launcher_foreground))
//                        .setContentTitle(title)
//                        .setContentText(content)
//                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                        .setVibrate(longArrayOf(300, 600, 300, 600))
//                        .setLights(Color.GREEN, 1000, 1000)
//                        .setContentIntent(pendingIntent)
//                        .setAutoCancel(true)
//
//        val channel = NotificationChannel(
//                "channel01",
//                "MyChannel",
//                NotificationManager.IMPORTANCE_HIGH
//        )
//
//        val notificationId = 1
//        val notification = builder.build()
//        notificationManager.createNotificationChannel(channel)
//        notificationManager.notify(notificationId, notification)
//    }
//
//    fun showNotificationBelowOreo(title:String , content:String ,notificationManager:NotificationManager) {
//
//
//        var bb = BitmapFactory.Options()
//        //        bb.inBitmap=
//
//        val builder =
//                NotificationCompat.Builder(this)
//                        .setSmallIcon(R.drawable.ic_launcher_foreground)
//                        .setContentTitle(title)
//                        .setContentText(content)
//        //.setLargeIcon(BitmapFactory.decodeResource(resources ,R.drawable.ic_star_black_24dp))
//
//        val notificationId = 2
//        val notification = builder.build()
//
//        notificationManager.notify(notificationId, notification)
//    }
//
//    override fun onNewToken(p0: String) {
//        super.onNewToken(p0)
//        Log.e("fcm", "refresh token:$p0")
//    }


//}